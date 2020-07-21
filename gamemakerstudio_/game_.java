/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_;

import gamemakerstudio_.entities.*;
import gamemakerstudio_.gui.*;
import gamemakerstudio_.misc.BufferedImageLoader;
import gamemakerstudio_.misc.FontClass;
import gamemakerstudio_.misc.assets_;
import gamemakerstudio_.misc.audioplayer_;
import gamemakerstudio_.world.levels_;
import gamemakerstudio_.world.world_;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class game_ extends Canvas implements Runnable{
    
    public static final int WIDTH = 1366 / 2, HEIGHT = 768;
    
    public static int throwframes;
    
    private Thread thread;
    private boolean running = false;
    public static boolean paused = false;
    public int diff = 0;
    public static BufferedImage spritesheet;
    
    // options
    public static boolean music = false; // this is fake
    public static boolean ldm = true;
    public static boolean multiplayer = false;
    public static boolean isInvincible = false;
    
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
        Game;
    }
    
    public static STATE gameState = STATE.Load;
    
    public game_() {
        handler = new handler_();
        hud = new hud_();
        hud2 = new hud2_();
        spawner = new spawn_(handler, hud, this);
        levels = new levels_(handler, hud, this, hud2);
        shop = new shop_(handler, hud, hud2, this);
        load = new loading_();
        
        // window
        new window_(WIDTH, HEIGHT, "game_ alpha edition v1", this);

        // load
        System.out.println("==============================================================");

        r = new Random();
        for (int i = 1; i <= 50; i++) handler.addObject(new spicymenu_(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.Spicy, handler));
        handler.addObject(new player_(50, 200, ID.Player, handler));
        if (multiplayer) handler.addObject(new player2_(game_.WIDTH - 128, 200, ID.Player2, handler));

        // test entities
        handler.addObject(new ghost_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50), ID.GHOST));
        handler.addObject(new starwrathenemy_(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.Star, handler));

        stringsforloading = "loading textures...";
        System.out.println(stringsforloading);
        BufferedImageLoader loader = new BufferedImageLoader();
        spritesheet = loader.loadImage("resources_/image_/gamespritesheet.png");
        assets_.init();

        // classes with textures
        world = new world_(this, "resources_/levels_/basicworldgen.txt");
        gamecamera = new gamecamera_(0,0);
        this.getGamecamera().move(0, 0);
        menu = new menu_(this, handler, hud, hud2);

        loadstate += 25;

//        handler.addObject(new skullface_((game_.WIDTH / 2) - 128, (game_.HEIGHT) - 128, ID.Xgamer, handler));

        stringsforloading = "loading input";
        System.out.println(stringsforloading);
        this.addKeyListener(new KeyInput(handler, this, hud, hud2));
//        this.addKeyListener(new SPKeyInput());
        this.addMouseListener(menu);
        this.addMouseListener(shop);
        this.addMouseListener(levels);
        loadstate += 25;

        stringsforloading = "loading fonts...";
        System.out.println(stringsforloading);
        FontClass.loadfont();
        loadstate += 25;

        stringsforloading = "loading sounds...";
        System.out.println(stringsforloading);
        audioplayer_.load("");
        loadstate += 25;

        // loading done codes
        if (gameState == STATE.Load) gameState = STATE.Menu;
        music = true;
        audioplayer_.getMusic("music").loop();

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
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;
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
        if (!paused) {
            if (gameState == STATE.Game) {
                // end codes
                if (multiplayer) {
                    if (hud_.HEALTH == 0 && hud2_.HEALTH == 0) {
                        hud_.HEALTH = 100;
                        hud2_.HEALTH = 100;
                        gameState = STATE.End;
                        handler.clearEnemies();
                        for (int i = 1; i <= 50; i++) handler.addObject(new spicymenu_(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.Spicy, handler));
                    }
                } else {
                    if (hud_.HEALTH == 0) {
                        hud_.HEALTH = 100;
                        hud2_.HEALTH = 100;
                        gameState = STATE.End;
                        handler.clearEnemies();
                        for (int i = 1; i <= 50; i++) handler.addObject(new spicymenu_(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.Spicy, handler));
                    }
                }
                handler.tick();
                spawner.tick();
                hud.tick();
                if (multiplayer) hud2.tick();
            }
            if (gameState == STATE.LevelSelect || gameState == STATE.GameBeta) {
                // end codes beta
                if (multiplayer) {
                    if (hud_.HEALTH == 0 && hud2_.HEALTH == 0) {
                        hud_.HEALTH = 100;
                        hud2_.HEALTH = 100;
                        gameState = STATE.End;
                        handler.clearEnemies();
                        for (int i = 1; i <= 50; i++) handler.addObject(new spicymenu_(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.Spicy, handler));
                    }
                } else {
                    if (hud_.HEALTH == 0) {
                        hud_.HEALTH = 100;
                        hud2_.HEALTH = 100;
                        gameState = STATE.End;
                        handler.clearEnemies();
                        for (int i = 1; i <= 50; i++) handler.addObject(new spicymenu_(r.nextInt(WIDTH - 50), r.nextInt(HEIGHT - 50), ID.Spicy, handler));
                    }
                }
                handler.tick();
                levels.tick();
                hud.tick();
                if (multiplayer) hud2.tick();
            }
            if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Options) {
                handler.tick();
                menu.tick();
            }
            if (gameState == STATE.Load) {
                handler.tick();
                load.tick();
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
        
        // bg
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

//        rendertest.render(g);

//        if (loadstate == 100) tiles_.tilesarray[1].render(g, 0, 0);
//        if (loadstate == 100) world.render(g);

        if (gameState == STATE.Credits || gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
            handler.render(g);
            menu.render(g);
        }

        if (gameState == STATE.LevelSelect) {
            handler.render(g);
            levels.render(g);
        }

        if (gameState == STATE.Game || gameState == STATE.GameBeta) {
            Font fnt = new Font("mojangles", 1, 10);
            g.setFont(fnt);

            handler.render(g);
            hud.render(g);
            if (multiplayer) hud2.render(g);
            levels.render(g);
        }

        if (gameState == STATE.Shop) {
            handler.render(g);
            shop.render(g);
        }

        if (gameState == STATE.Load) {
            handler.render(g);
            load.render(g);
        }

        // if still loading?
        if (loadstate != 100 && gameState != STATE.Load) {
            if (gameState == STATE.Game || gameState == STATE.GameBeta)
                g.drawString(stringsforloading, WIDTH / 2 - 50, HEIGHT - 50);
            else g.drawString(stringsforloading, 0, 20);
        }

        if (paused) {
            Font fnthead = new Font("mojangles", 1, 40);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("paused_", game_.WIDTH / 3 + 10, 50);
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
    public gamecamera_ getGamecamera() {
        return gamecamera;
    }
    public static void main(String[] args) {
        System.out.println("game_ [Version 1.0] by KENNEDY");
        System.out.println("(c) 2020 The Karakters Kompany, game_ Engine. All rights reserved.");
        new game_();
    }
}
