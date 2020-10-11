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

    // test custom codes
    boolean customTicksBoolean = false;
    int customTicks = 0;

    public static final int WIDTH = 1360 / 2, HEIGHT = 760 - 26;
    
    public static int throwframes;

    // game loop variables
    private Thread thread;
    private boolean running = false;
    public static boolean paused = false;

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
    // guns
    public enum GUN {
        Default,
        Chlorophyte,
        Electrocute
    }
    // player gun load out
    public static GUN playerOneGunLoadOut = GUN.Default;
    public static GUN playerTwoGunLoadOut = GUN.Default;

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
    public static STATE gameState = STATE.Load;
    public static boolean mouseCursor = false;
    public static boolean isSelecting = false; // do not touch, unless this is xbox

    int restartCooldown = 100;
    private Random r;
    
    public static String stringsforloading = "loading...";
    public static double loadstate;
    
    // enter classes here
    private handler_ handler;
    private hud_ hud;
    private hud2_ hud2;
    private spawn_ spawner;
    private menu_ menu;
    private shop_ shop;
    private loading_ load;
    private world_ world;
    private gamecamera_ gamecamera;
    private levels_ levels;
    private devconsole_ devconsole;
    private window_ window;
    
    public game_() {

        if (JOptionPaneOption) {
            int seizure = JOptionPane.showConfirmDialog(null, "seizure warning", "Surprise Motherfucker!", JOptionPane.INFORMATION_MESSAGE);
            if (seizure == JOptionPane.NO_OPTION) System.exit(0);
        }
        r = new Random();

        // init classes
        handler = new handler_();
        hud = new hud_(handler);
        hud2 = new hud2_();
        spawner = new spawn_(handler, hud, this);
        levels = new levels_(handler, hud, this, hud2);
        shop = new shop_(handler, hud, hud2, this);
        devconsole = new devconsole_(this, handler, hud, hud2);
        load = new loading_();
        
        // window
        window = new window_(WIDTH, HEIGHT, "game_ alpha edition v1", this, handler);

        // load
        System.out.println("==============================================================");

        // test
        if (gameState != STATE.Edit) for (int i = 1; i <= 50; i++)
            handler.addObject(new spicymenu_(r.nextInt(WIDTH - 10), r.nextInt(HEIGHT - 10), ID.Spicy, handler));
        handler.addObject(new player_(50, 200, ID.Player, handler, hud));
        handler.addObject(new RangeArea(0, 0, ID.P1Range, handler));
        if (multiplayer) {
            handler.addObject(new player2_(game_.WIDTH - 128, 200, ID.Player2, handler, hud2));
            handler.addObject(new RangeArea(0, 0, ID.P2Range, handler));
        }
        if (mouseCursor) handler.addObject(new CURSOR_POINTER(0, 0, ID.CURSOR, this));
        customTicksMethod();

        // init textures
        stringsforloading = "loading textures...";
        System.out.println(stringsforloading);
        BufferedImageLoader loader = new BufferedImageLoader();
        spritesheet = loader.loadImage("resources_/image_/gamespritesheet.png");
        assets_.init();
        loadstate += 25;

        // classes with textures
        world = new world_(this, "resources_/levels_/basicworldgen.txt");
        gamecamera = new gamecamera_(0,0);
        this.getGamecamera().move(0, 0);
        menu = new menu_(this, handler, hud, hud2);

        // init input
        stringsforloading = "loading input";
        System.out.println(stringsforloading);
        this.addKeyListener(new KeyInput(handler, this, hud, hud2, levels, devconsole));
//        this.addKeyListener(new SPKeyInput());
        this.addMouseListener(menu);
        this.addMouseMotionListener(menu);
        this.addMouseListener(shop);
        this.addMouseMotionListener(levels);
        this.addMouseListener(levels);
        loadstate += 25;

        // init fonts, do i still use this?
        stringsforloading = "loading fonts...";
        System.out.println(stringsforloading);
        FontClass.loadfont();
        loadstate += 25;

        // init sounds (buggy)
        stringsforloading = "loading sounds...";
        System.out.println(stringsforloading);
        audioplayer_.load("");
        loadstate += 25;

        // loading done codes
        if (gameState == STATE.Load) gameState = STATE.Menu;
        music = true; // might let the user change this option
        if (gameState != STATE.Edit && music) audioplayer_.getMusic("music").loop();

        System.out.println("==============================================================");
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
    
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 100.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
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
                    int a = JOptionPane.showConfirmDialog(null, "An error occurred: " + e + ", \ndo you still wish to continue?", "Error", JOptionPane.INFORMATION_MESSAGE);
                    if (a == JOptionPane.NO_OPTION) System.exit(0);

                    // if error caught but continued, still work in progress
                    levels.resetMethod();
                    audioplayer_.getMusic(audioplayer_.currentMusic).loop();
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                }
                delta--;
            }
            // render this
            if (running) {
                try {
                    render();
                } catch (Exception e) {
                    e.printStackTrace();
                    int a = JOptionPane.showConfirmDialog(null, "An error occurred: " + e + ", \ndo you still wish to continue?", "Error", JOptionPane.INFORMATION_MESSAGE);
                    if (a == JOptionPane.NO_OPTION) System.exit(0);
                }
            }
            frames++;
            // reset frame count
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                System.out.println("FPS: " + frames);
//                System.out.println("Objects: " + handler.object.size());
                throwframes = frames;
                render();
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick() {
//        if (loadstate == 100) world.tick();
        window.tick();
        if (!paused) {

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
            } else if (gameState != STATE.Shop) handler.tick();

            if (gameState == STATE.Game) {
                // i dunno why i'm doing this
                currentGameStateIsBeta = false;
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
                spawner.tick();
                hud.tick();
                if (multiplayer) hud2.tick();
            }
            if (gameState == STATE.LevelSelect || gameState == STATE.GameBeta || gameState == STATE.Edit) {
                // i dunno why i'm doing this
                currentGameStateIsBeta = true;
                // end codes beta
                if (multiplayer) {
                    if (hud_.HEALTH == 0 && hud2_.HEALTH == 0) {
                        endCodesBeta();
                    }
                } else {
                    if (hud_.HEALTH == 0) {
                        hud2.HEALTH = 0;
                        endCodesBeta();
                    }
                }
                levels.tick();
                hud.tick();
                if (multiplayer) hud2.tick();
            }
            if (gameState == STATE.Menu || gameState == STATE.Help ||
                    gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Options) {
                menu.tick();
            }
            if (gameState == STATE.Load) {
                load.tick();
            }
            if (customTicksBoolean && gameState != STATE.GameBeta && gameState != STATE.Game) {
                customTicks++;
                if (customTicks == 100) {
                    customTicks = 0;
                    // run this code once
                    crazyboss_.minRotate = -45;
                    crazyboss_.maxRotate = 45;
                    crazyboss_.rotateThisTick = 20;
                    // run this code once the tick was called
                    if (crazyboss_.increment) crazyboss_.increment = false;
                    else crazyboss_.increment = true;
                }
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

        // grids
        g.setColor(Color.black);
        for (int a = 50, b = 50; a <= 1250 && b <= 650; a += 10) {
            g.drawRect(a, b, 10, 10);
            if (a == 1250) {
                a = 40;
                b += 10;
            }
        }
        // pixels
        g.setColor(Color.green);
        int x = ((50 + (int)(Math.random() * 1250)) / 10) * 10, y = ((50 + (int)(Math.random() * 650)) / 10) * 10;
        g.fillRect(x, y, 10, 10);

//        rendertest.render(g);

//        if (loadstate == 100) tiles_.tilesarray[1].render(g, 0, 0);
//        if (loadstate == 100) world.render(g);

        // main render

        // bg
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        try {
            handler.render(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (gameState == STATE.Credits || gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
            menu.render(g);
        }

        if (gameState == STATE.LevelSelect) {
            levels.render(g);
        }

        if (gameState == STATE.Game || gameState == STATE.GameBeta || gameState == STATE.Edit) {
            Font fnt = new Font("mojangles", 1, 10);
            g.setFont(fnt);
            levels.render(g);
            hud.render(g);
            if (multiplayer) hud2.render(g);
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
            g.drawString("paused_", WIDTH / 3 + 10, HEIGHT / 2);
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
    public gamecamera_ getGamecamera() {
        return gamecamera;
    }

    public void customTicksMethod() {
        // test entities
        if (customTicksBoolean) {
            handler.addObject(new ghost_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10), ID.GHOST, 1, 1, 0));
            handler.addObject(new starwrathenemy_(0, 0, ID.STARGHOST, handler, 30, 30, 0));
            handler.addObject(new crazyboss_(game_.WIDTH / 2 - 128, game_.HEIGHT / 2 - 128, ID.CrazyBoss, handler, 0, 0, 0));
            //        handler.addObject(new skullface_((game_.WIDTH / 2) - 128, (game_.HEIGHT) - 128, ID.Xgamer, handler));
        }
    }

    public void endCodes() {
        hud.HEALTH = 100;
        hud2.HEALTH = 100;
        gameState = STATE.End;
        handler.clearEnemies();
        for (int i = 1; i <= 50; i++)
            handler.addObject(new spicymenu_(r.nextInt(WIDTH - 10), r.nextInt(HEIGHT - 10), ID.Spicy, handler));
        if (customTicksBoolean) customTicksMethod();
    }
    public void endCodesBeta() {
        if (!autoRestart) {
            hud.HEALTH = 100;
            hud2.HEALTH = 100;
            gameState = STATE.End;
            handler.clearEnemies();
            for (int i = 1; i <= 50; i++)
                handler.addObject(new spicymenu_(r.nextInt(WIDTH - 10), r.nextInt(HEIGHT - 10), ID.Spicy, handler));
            if (customTicksBoolean) customTicksMethod();
        } else {
            if (restartCooldown == 100) {
                if (gameState == STATE.GameBeta) audioplayer_.getMusic(audioplayer_.currentMusic).pause();
                handler.removeAllSelectedObjectsExceptPlayers(ID.Trail);
            }
            restartCooldown--;
            if (restartCooldown == 0) {
                restartCooldown = 100;
                levels.resetMethod();
                if (gameState == STATE.GameBeta) audioplayer_.getMusic(audioplayer_.currentMusic).loop();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("game_ [Version 1.0] by KENNEDY");
        System.out.println("(c) 2020 The Karakters Kompany, game_ Engine. All rights reserved.");

        new game_();
    }
}
