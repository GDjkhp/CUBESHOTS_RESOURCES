/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_;

import gamemakerstudio_.entities.*;
import gamemakerstudio_.entities.boss.crazyboss_;
import gamemakerstudio_.gui.*;
import gamemakerstudio_.misc.*;
import gamemakerstudio_.world.levels_;
import gamemakerstudio_.world.spawn_;
import gamemakerstudio_.world.world_;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class game_ extends Canvas implements Runnable{
    // dimension
    public static final int WIDTH = 1360/2, HEIGHT = 720;
    // game loop variables
    public Thread thread;
    public boolean running = false;
    public static boolean paused = false;
    public static int throwFrames, throwTick;
    public static long throwWait, throwErrorWait;
    // states
    public enum STATE {
        Menu,
        Help,
        End,
        Select,
        Shop,
        Load,
        Options,
        LevelSelect,
        GameBeta,
        Credits,
        Edit,
        Game
    }
    // difficulty
    public int diff = 0;
    // textures
    public static BufferedImage spritesheet;
    // i dunno why is this here
    public static boolean currentGameStateIsBeta;
    // options
    public static boolean music = false; // this is fake
    public static boolean ldm = false;
    public static boolean multiplayer = false;
    public static boolean isInvincible = false;
    public static boolean autoRestart = true;
    public static boolean JOptionPaneOption = false;
    public static STATE gameState = STATE.Load; // default is STATE.Load
    public static boolean mouseCursor = false;
    public static boolean isSelecting = false; // do not touch, unless this is xbox
    public static boolean computerP1 = false;
    public static boolean computerP2 = false;
    public static boolean gridLines = false;
    public static boolean hideHud = false;
    public static boolean backgroundRender = true;

    int restartCooldown = 100;
    public Random r = new Random();

    public static String stringsforloading = "loading failed, press alt + f4 to exit...";
    public static double loadstate;

    // enter classes here
    public handler_ handler;
    public hud_ hud;
    public hud2_ hud2;
    public spawn_ spawner;
    public menu_ menu;
    public shop_ shop;
    public loading_ load;
    public world_ world;
    public gamecamera_ gamecamera;
    public levels_ levels;
    public devconsole_ devconsole;
    public window_ window;
    public KeyInput keyMain;
    public leveleditor_ editor;

    // load codes here, run this once
    public game_() {

        if (JOptionPaneOption) {
            int seizure = JOptionPane.showConfirmDialog(null, "seizure warning", "Surprise Motherf*!", JOptionPane.INFORMATION_MESSAGE);
            if (seizure == JOptionPane.NO_OPTION) System.exit(0);
        }

        // init classes
        handler = new handler_();
        hud = new hud_(handler);
        hud2 = new hud2_();
        spawner = new spawn_(handler, hud, this);
        levels = new levels_(handler, hud, this, hud2);
        shop = new shop_(handler, hud, hud2, this);
        devconsole = new devconsole_(this, handler, hud, hud2);
        load = new loading_();
        keyMain = new KeyInput(handler, this, hud, hud2, levels, devconsole);
        editor = new leveleditor_(this, handler);

        // window
        window = new window_(WIDTH, HEIGHT, "game_ alpha edition v1", this, handler);

        // load
        System.out.println("==============================================================");
        System.out.println("loading window: " + game_.WIDTH + "x" + game_.HEIGHT);

        // test
        handler.addObject(new player_(50, 200, ID.Player, handler, hud));
        handler.addObject(new RangeArea(0, 0, ID.P1Range, handler));
        if (multiplayer) {
            handler.addObject(new player2_(game_.WIDTH - 128, 200, ID.Player2, handler, hud2));
            handler.addObject(new RangeArea(0, 0, ID.P2Range, handler));
        }
        if (mouseCursor) handler.addObject(new CURSOR_POINTER(0, 0, ID.CURSOR, this));
        if (customTicksBoolean) customTicksMethod();
        else if (gameState != STATE.Edit) for (int i = 1; i <= 50; i++)
            handler.addObject(new spicymenu_(r.nextInt(WIDTH - 20), r.nextInt(HEIGHT - 20), ID.Spicy, handler));

        // init textures
        stringsforloading = "loading textures...";
        System.out.println(stringsforloading);
        BufferedImageLoader loader = new BufferedImageLoader();
        spritesheet = loader.loadImage("resources_/image_/gamespritesheet.png");
        assets_.init();
        loadstate += 25;

        // classes with textures
        world = new world_(this, "resources_/levels_/basicworldgen.txt");
        gamecamera = new gamecamera_(0, 0);
        this.getGameCamera().move(0, 0);
        menu = new menu_(this, handler, hud, hud2);

        // init input, might remove class input later, do not remove keyMain
        stringsforloading = "loading input...";
        System.out.println(stringsforloading);
        this.addKeyListener(keyMain);
//        this.addKeyListener(new SPKeyInput());
        loadstate += 25;

        // init fonts, do i still use this?
        stringsforloading = "loading fonts...";
        System.out.println(stringsforloading);
        FontClass.loadfont();
        loadstate += 25;

        // init sounds (buggy), to fix, replace Slick2D lib, it's the only way
        // edit: or not
        stringsforloading = "loading sounds...";
        System.out.println(stringsforloading);
//        TinySound.init();
        audioplayer_.load("");
        loadstate += 25;
        System.out.println("==============================================================");
        // loading done codes
        if (gameState == STATE.Load) gameState = STATE.Menu;
        // let the user change this option
        int confirmSound = JOptionPane.showConfirmDialog(null,
                "Enable sounds?", "Music", JOptionPane.INFORMATION_MESSAGE);
        if (confirmSound == JOptionPane.YES_OPTION) music = true;
        if (gameState != STATE.Edit && music) audioplayer_.getMusic("music").loop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick() {
//        if (loadstate == 100) world.tick();
        window.tick();
        keyMain.tick();
        if (!paused) {
            // handler tick
            if (gameState == STATE.GameBeta) {
                if (multiplayer) {
                    if (hud_.HEALTH != 0 || hud2_.HEALTH != 0) {
                        handler.tick();
                    }
                } else {
                    if (hud_.HEALTH != 0) {
                        handler.tick();
                    }
                }
            }
            else if (gameState != STATE.Shop) handler.tick();
            // custom
            if (gameState == STATE.Game) {
                // i dunno why i'm doing this
                currentGameStateIsBeta = false;
                // tick codes here
                spawner.tick();
                hud.tick();
                if (multiplayer) hud2.tick();
                // end codes
                if (multiplayer) {
                    if (hud_.HEALTH == 0 && hud2_.HEALTH == 0) {
                        endCodes();
                    }
                } else {
                    if (hud_.HEALTH == 0) {
                        endCodes();
                    }
                }
            }
            if (gameState == STATE.LevelSelect || gameState == STATE.GameBeta || gameState == STATE.Edit) {
                // i dunno why i'm doing this
                currentGameStateIsBeta = true;
                // tick codes here
                levels.tick();
                hud.tick();
                if (game_.multiplayer) hud2.tick();
                // end codes beta
                if (multiplayer) {
                    if (hud_.HEALTH == 0 && hud2_.HEALTH == 0 && gameState == STATE.GameBeta) {
                        endCodesBeta();
                    }
                } else {
                    if (hud_.HEALTH == 0 && gameState == STATE.GameBeta) {
                        hud2.HEALTH = 0;
                        endCodesBeta();
                    }
                }
            }
            if (gameState == STATE.Menu || gameState == STATE.Help ||
                    gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Options) {
                menu.tick();
            }
            if (gameState == STATE.Load) {
                load.tick();
            }
            if (customTicksBoolean && gameState != STATE.GameBeta && gameState != STATE.Game) {
                // only trigger this at menu only
                customTickLoopMethod();
            }
            if (gameState == STATE.Edit){
                editor.tick();
            }
        }
    }
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        // all test codes
        // X
        /*g.setColor(Color.green);
        g.drawString("X", x, y);
        g.dispose();*/

        // eyes and mouth
        /*g.setColor(Color.black);
        g.fillRect(500, 250, 100, 100);
        g.fillRect(700, 250, 100, 100);
        g.fillRect(600, 350, 100, 100);
        g.fillRect(600, 400, 100, 100);
        g.fillRect(550, 400, 50, 150);
        g.fillRect(700, 400, 50, 150);*/

        if (backgroundRender){
            // grids (background), aka n00b l00p
            g.setColor(Color.black);
            for (int a = 50, b = 50; a <= 1250 && b <= 650; a += 10) {
                g.drawRect(a, b, 10, 10);
                if (a == 1250) {
                    a = 40;
                    b += 10;
                }
            }
            // pixels (background), aka rand0m n00b
            g.setColor(Color.green);
            int x = ((50 + (int)(Math.random() * 1250)) / 10) * 10, y = ((50 + (int)(Math.random() * 650)) / 10) * 10;
            g.fillRect(x, y, 10, 10);
        }

//        rendertest.render(g);

//        if (loadstate == 100) tiles_.tilesarray[1].render(g, 0, 0);
//        if (loadstate == 100) world.render(g);

        // main render

        // bg
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // grid
        if (gridLines){
            g.setColor(Color.BLACK);
            for(int xAxis = 0; xAxis <= 680; xAxis += 10){
                for(int yAxis = 0; yAxis <= 730; yAxis += 10){
                    g.drawRect(xAxis, yAxis, 10, 10);
                }
            }
            g.setColor(Color.ORANGE);
            for(int xAxis = 0; xAxis <= 650; xAxis += 50){
                for (int yAxis = 0; yAxis <= 700; yAxis += 50){
                    g.drawRect(xAxis, yAxis, 50, 50);
                }
            }
            g.setColor(Color.RED);
            for(int xAxis = 0; xAxis <= 600; xAxis += 200){
                for (int yAxis = 0; yAxis <= 600; yAxis += 200){
                    g.drawRect(xAxis, yAxis, 200, 200);
                }
            }
        }

        try {
            handler.render(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (gameState == STATE.Credits || gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
            menu.render(g);
        }

        if (gameState == STATE.LevelSelect) {
            Font fnt = new Font("mojangles", 1, 16);
            g.setFont(fnt);
            levels.render(g);
        }

        if (gameState == STATE.Game || gameState == STATE.GameBeta || gameState == STATE.Edit) {
            Font fnt = new Font("mojangles", 1, 10);
            g.setFont(fnt);
            levels.render(g);
            if (!hideHud) {
                hud.render(g);
                if (multiplayer) hud2.render(g);
            }
        }

        if (gameState == STATE.Edit){
            editor.render(g);
        }

        if (gameState == STATE.Shop) {
            shop.render(g);
        }

        if (gameState == STATE.Load) {
            load.render(g);
        }

        // if still loading?
        if (loadstate != 100 && gameState != STATE.Load) {
            if (gameState == STATE.Game || gameState == STATE.GameBeta || gameState == STATE.Edit)
                g.drawString(stringsforloading, game_.WIDTH / 2 - 50, game_.HEIGHT - 75);
            else g.drawString(stringsforloading, 0, 20);
        }

        if (paused) {
            Font fnthead = new Font("mojangles", 1, 40);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("paused_", WIDTH / 2 - getTextWidth(g, "paused_")/2, HEIGHT / 2);
        }

        g.dispose();

        bs.show();
    }
    
    public static int clamp(int var, int min, int max) {
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    }

    public static double clampDouble(double var, double min, double max) {
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    }

    // the ultimate fix, for center
    public static int getTextWidth(Graphics g, String message){
        return g.getFontMetrics().stringWidth(message);
    }

    public gamecamera_ getGameCamera() {
        return gamecamera;
    }

    // halt
    public void endCodes() {
        hud.HEALTH = 100;
        hud2.HEALTH = 100;
        gameState = STATE.End;
        handler.clearEnemies();
        if (customTicksBoolean) customTicksMethod();
        else {
            for (int i = 1; i <= 50; i++)
                handler.addObject(new spicymenu_(r.nextInt(WIDTH - 20), r.nextInt(HEIGHT - 20), ID.Spicy, handler));
        }
    }
    public void endCodesBeta() {
        if (!autoRestart) {
            if (restartCooldown == 100) {
                if (gameState == STATE.GameBeta) audioplayer_.getMusic(audioplayer_.currentMusic).pause();
                handler.removeAllSelectedObjects(ID.Trail);
            }
            restartCooldown--;
            if (restartCooldown == 0) {
                if (music) audioplayer_.getMusic("game_over").loop();
                restartCooldown = 100;
                hud.HEALTH = 100;
                hud2.HEALTH = 100;
                gameState = STATE.End;
                handler.clearEnemies();
                if (customTicksBoolean) customTicksMethod();
                else {
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(WIDTH - 20), r.nextInt(HEIGHT - 20), ID.Spicy, handler));
                }
            }
        } else {
            if (restartCooldown == 100) {
                if (gameState == STATE.GameBeta) audioplayer_.getMusic(audioplayer_.currentMusic).pause();
                handler.removeAllSelectedObjects(ID.Trail);
            }
            restartCooldown--;
            if (restartCooldown == 0) {
                restartCooldown = 100;
                levels.resetMethod();
                if (gameState == STATE.GameBeta) audioplayer_.getMusic(audioplayer_.currentMusic).loop();
            }
        }
    }
    public void restartBeta() {
        if (paused) paused = false;
        // restart
        if ((gameState == STATE.GameBeta || gameState == STATE.End) && currentGameStateIsBeta) {
            levels.resetMethod();
            if (music) audioplayer_.getMusic(audioplayer_.currentMusic).loop(); // library change error
            if (music) audioplayer_.getSound("click_sound").play();
        }
    }
    
    // reset
    public void easy(){
        gameState = STATE.Game;
        hud.resetTimer();
        handler.clearEnemies();
        hud.setLevel(1);
        spawn_.scoreKeep = 0;
        levels_.scoreKeep = 0;
        // p1 reset
        hud.setScore(0);
        hud.setXp(0);
        hud_.HEALTH = 100;
        handler_.spdp1 = 5;
        hud_.bounds = 0;
        // p2 reset
        hud2.setScore(0);
        hud2.setXp(0);
        hud2_.HEALTH = 100;
        handler_.spdp2 = 5;
        hud2_.bounds = 0;
        // reset shop
        shop_.B1 = 100;
        shop_.B2 = 100;
        shop_.B3 = 100;
        shop_.B4 = 100;
        shop_.B5 = 100;
        shop_.B6 = 100;
        // spawn
        handler.addObject(new basicenemy_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50), ID.BasicEnemy, handler));
        diff = 0;
        // gameloop fix
        spawner.lastTime = System.nanoTime();
        spawner.delta = 0;
        hud.lastTime = System.nanoTime();
        hud.delta = 0;
        hud2.lastTime = System.nanoTime();
        hud2.delta = 0;
        // testing purposes
        hud.hudTick = 0;
    }
    public void medium(){
        gameState = STATE.Game;
        hud.resetTimer();
        handler.clearEnemies();
        hud.setLevel(1);
        spawn_.scoreKeep = 0;
        levels_.scoreKeep = 0;
        // p1 reset
        hud.setScore(0);
        hud.setXp(0);
        hud_.HEALTH = 100;
        handler_.spdp1 = 5;
        hud_.bounds = 0;
        hud.heartsTaken = 0;
        // p2 reset
        hud2.setScore(0);
        hud2.setXp(0);
        hud2_.HEALTH = 100;
        handler_.spdp2 = 5;
        hud2_.bounds = 0;
        hud2.heartsTaken = 0;
        // reset shop
        shop_.B1 = 1000;
        shop_.B2 = 1000;
        shop_.B3 = 1000;
        shop_.B4 = 1000;
        shop_.B5 = 1000;
        shop_.B6 = 1000;
        // spawn
        handler.addObject(new hardenemy_(r.nextInt(game_.WIDTH - 1), r.nextInt(game_.HEIGHT - 1), ID.HardEnemy, handler));
        diff = 1;
        // gameloop fix
        spawner.lastTime = System.nanoTime();
        spawner.delta = 0;
        hud.lastTime = System.nanoTime();
        hud.delta = 0;
        hud2.lastTime = System.nanoTime();
        hud2.delta = 0;
        // testing purposes
        hud.hudTick = 0;
    }

    public static void main(String[] args) {
        System.out.println("game_ Engine [Version 1.0] by KENNEDY");
        System.out.println("(c) 2020 The Karakters Kompany, game_ Engine. All rights reserved.");

        new game_();
    }

    // test custom codes
    public boolean customTicksBoolean = false;
    int customTicks = 0;
    int timer, timer2;
    gameobject_ boss;

    public void customTicksMethod() {
        System.out.println("Custom Code Activated!");
        // test entities
//        handler.addObject(new ghost_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10), ID.GHOST, 1, 1));
//        handler.addObject(new starwrathenemy_(0, 0, ID.STARGHOST, handler, 30, 30, 0));
//        handler.addObject(new crazyboss_(game_.WIDTH / 2 - 128, game_.HEIGHT / 2 - 128, ID.CrazyBoss, handler, 0, 0, 0));
        /*boss = handler.addObject(new skullface_((game_.WIDTH / 2) - 128, (game_.HEIGHT) - 128, ID.Xgamer, handler,
                0, -5, 0));
        timer = 100;
        timer2 = 200;*/

        /*handler.addObject(new moresmarterenemy_(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MoreSmarter,
                handler, 20, 20));*/

//        handler.addObject(new osc_(0, 0, ID.NULL));

        /*handler.addObject(new portalblue_(r.nextInt(WIDTH-64), r.nextInt(HEIGHT-64), ID.PortalBlue,
                handler,0, 0));
        handler.addObject(new portalred_(r.nextInt(WIDTH-64), r.nextInt(HEIGHT-64), ID.PortalRed,
                handler,0, 0));*/

        // run this code once
        crazyboss_.minRotate = -45;
        crazyboss_.maxRotate = 45;
        crazyboss_.rotateThisTick = 20;

//        handler.addObject(new testSpawnScreenLimit(0, 0, ID.NULL, handler));
//        handler.addObject(new water_(0, 0, ID.NULL));
//        handler.addObject(new tictactoe_(0, 0, ID.NULL, this));
//        handler.addObject(new conwaysgameoflife_(0, 0, ID.NULL, this));
//        handler.addObject(new pathfinder_(0, 0, ID.NULL, this));
    }

    public void customTickLoopMethod(){
        // run this code once the tick was called
        customTicks++;

        // old temp codes
        /*if (customTicks == 100) {
            customTicks = 0;
            if (crazyboss_.increment) crazyboss_.increment = false;
            else crazyboss_.increment = true;
        }*/

        if (customTicks == 100) {
            customTicks = 0;
        }

        /*if (timer == 0) {
            boss.setVelY(0);
        } else timer--;
        if (timer2 == 0) {
            timer2 = 100;
            handler.addObject(new laserpointer_((int) boss.getX() + 169, (int) boss.getY() + 93, ID.Laser, handler, 30, 30, 0));
            handler.addObject(new laserpointer_((int) boss.getX() + 57, (int) boss.getY() + 101, ID.Laser, handler, 30, 30, 0));
        } else timer2--;*/

    }
    String loops = "noob";

    public void run() {
        this.requestFocus();

        // main loop
        if (loops == "pro"){
            long lastTime = System.nanoTime();
            double amountOfTicks = 100.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            // frame test
            long timer = System.currentTimeMillis();
            int frames = 0;
            // tick test
            int tick = 0;
            long timerTick = System.currentTimeMillis();
            while(running) {
                // loop this
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                // loop this tick
                while (delta >= 1) {
                    try {
                        tick();
                    } catch (Exception e) {
                        e.printStackTrace();
                        int a = JOptionPane.showConfirmDialog(null, "An error occurred: " + e + ", " +
                                "\ndo you still wish to continue?", "Error", JOptionPane.INFORMATION_MESSAGE);
                        if (a == JOptionPane.NO_OPTION) System.exit(0);

                        // if error caught but continued, still work in progress
                        if (gameState == STATE.GameBeta) {
                            levels.resetMethod();
                            if (game_.music) audioplayer_.getMusic(audioplayer_.currentMusic).loop();
                            if (game_.music) audioplayer_.getSound("click_sound").play();
                        }
                    }
                    delta--;
                    // tick test
                    tick++;
                }
                // render this
                if (running) {
                    try {
                        render();
                    } catch (Exception e) {
                        e.printStackTrace();
                        int a = JOptionPane.showConfirmDialog(null, "An error occurred: " + e + ", " +
                                "\ndo you still wish to continue?", "Error", JOptionPane.INFORMATION_MESSAGE);
                        if (a == JOptionPane.NO_OPTION) System.exit(0);
                    }
                }
                frames++;
                // reset frame count
                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
//                System.out.println("FPS: " + frames);
//                System.out.println("Objects: " + handler.object.size());
                    throwFrames = frames;
//                    render();
                    frames = 0;
                }
                // test tick
                if (System.currentTimeMillis() - timerTick > 1000) {
                    timerTick += 1000;
//                    System.out.println(tick);
                    throwTick = tick;
                    tick = 0;
                }
            }
            stop();
        }
        if (loops == "noob"){
            // redundant
            /*long now;
            long updateTime;
            long wait;*/

            /*final int TARGET_FPS = 100; // also tick
            final long OPTIMAL_TIME = 1000000000 / TARGET_FPS; // also ns*/

            int tick = 0;
            long timerTick = System.currentTimeMillis();

            long timer = System.currentTimeMillis();
            int frames = 0;

            while (running) {
//                now = System.nanoTime();

                try {
                    tick();
                } catch (Exception e) {
                    e.printStackTrace();
                    int a = JOptionPane.showConfirmDialog(null, "An error occurred: " + e + ", " +
                            "\ndo you still wish to continue?", "Error", JOptionPane.INFORMATION_MESSAGE);
                    if (a == JOptionPane.NO_OPTION) System.exit(0);

                    // if error caught but continued, still work in progress
                    if (gameState == STATE.GameBeta) {
                        levels.resetMethod();
                        if (game_.music) audioplayer_.getMusic(audioplayer_.currentMusic).loop();
                        if (game_.music) audioplayer_.getSound("click_sound").play();
                    }
                }

                try {
                    render();
                } catch (Exception e) {
                    e.printStackTrace();
                    int a = JOptionPane.showConfirmDialog(null, "An error occurred: " + e + ", " +
                            "\ndo you still wish to continue?", "Error", JOptionPane.INFORMATION_MESSAGE);
                    if (a == JOptionPane.NO_OPTION) System.exit(0);
                }

                // removing this code bcz it's redundant
                /*updateTime = System.nanoTime() - now;
                wait = (OPTIMAL_TIME - updateTime) / 1000000000;*/

                // test tick
                tick++;
                if (System.currentTimeMillis() - timerTick > 1000) {
                    timerTick += 1000;
//                    System.out.println(tick);
                    throwTick = tick;
                    tick = 0;
                }
                // frame count
                frames++;
                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
//                System.out.println("FPS: " + frames);
//                System.out.println("Objects: " + handler.object.size());
                    throwFrames = frames;
//                    render();
                    frames = 0;
                }

                // yow wtf removing this codes fixes everything!

                /*try {
                    throwWait = wait;
                    Thread.sleep(wait);
                } catch (Exception e) {
                    throwErrorWait = wait;
                    e.printStackTrace();
                }*/
            }
        }
    }
}
