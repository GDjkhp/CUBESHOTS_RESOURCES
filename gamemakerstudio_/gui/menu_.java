/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.gui;

import gamemakerstudio_.*;
import gamemakerstudio_.entities.basicenemy_;
import gamemakerstudio_.entities.ghost_;
import gamemakerstudio_.entities.hardenemy_;
import gamemakerstudio_.entities.player2_;
import gamemakerstudio_.game_.STATE;
import gamemakerstudio_.misc.assets_;
import gamemakerstudio_.misc.audioplayer_;
import gamemakerstudio_.world.levels_;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class menu_ extends MouseAdapter{
    // classes
    private game_ game;
    private handler_ handler;
    private hud_ hud;
    private hud2_ hud2;

    private Random r = new Random();
    private String p1help = "help me_";
    private String p2help = "help me_";
//    private BufferedImage soundiconon, soundiconoff;
//    private BufferedImage ldm;
    private Color col;

    // animation
    boolean isRotating = true;
    int rotateTick = -90;

    // easter egg
    private  gameobject_ ghost;
    int tempGhostX;
    int tempGhostY;
    
    public menu_(game_ game, handler_ handler, hud_ hud, hud2_ hud2) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        this.hud2 = hud2;
        // easter egg
        for (int i = 0; i < handler.object.size(); i++) {
            gameobject_ tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.GHOST) ghost = tempObject;
        }
    }
    
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        if (game.gameState == STATE.Menu) {
            // play
            if (mouseOver(mx, my, game_.WIDTH / 3, 100, 200, 50)) {
                // test rotate
//                isRotating = true;
//                rotateTick++;

                game.gameState = STATE.Select;
                if (game_.music) audioplayer_.getSound("click_sound").play();
                return;
            }
            // help
            if (mouseOver(mx, my, game_.WIDTH / 3, 175, 200, 50)) {
                game.gameState = STATE.Help;
                if (game_.music) audioplayer_.getSound("click_sound").play();
                return;
            }
            // quit
            if (mouseOver(mx, my, game_.WIDTH / 3, 250, 200, 50)) {
                if (game_.music) audioplayer_.getSound("click_sound").play();
                System.exit(0);
            }
            // sounds and sfx
            if (mouseOver(mx, my, game_.WIDTH / 3, 325, 100, 50)) {
                if (game.loadstate == 100) {
                    if (game_.music) {
                        game_.music = false;
                        audioplayer_.getSound("null").play();
                        audioplayer_.getMusic("null").play();
                    }
                    else {
                        game_.music = true;
                        audioplayer_.getMusic("music").loop();
                    }

                    if (game_.music) audioplayer_.getSound("click_sound").play();
                }
            }
            // ldm
            if (mouseOver(mx, my, game_.WIDTH / 3 + 100, 325, 100, 50)) {
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.ldm) game_.ldm = false;
                else game_.ldm = true;
            }
        }
        // diff
        if (game.gameState == STATE.Select) {
            // easy
            if (mouseOver(mx, my, game_.WIDTH / 3, 100, 200, 50)) {
                game.gameState = STATE.Game;
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
                game.diff = 0;
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
            // medium
            if (mouseOver(mx, my, game_.WIDTH / 3, 175, 200, 50)) {
                game.gameState = STATE.Game;
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
                shop_.B1 = 1000;
                shop_.B2 = 1000;
                shop_.B3 = 1000;
                shop_.B4 = 1000;
                shop_.B5 = 1000;
                shop_.B6 = 1000;
                // spawn
                handler.addObject(new hardenemy_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50), ID.BasicEnemy, handler));
                game.diff = 1;
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
            // hard?
            if (mouseOver(mx, my, game_.WIDTH / 3, 250, 200, 50)) {
                System.out.println("u are too gei to die_");
            }
            // beta
            if (mouseOver(mx, my, game_.WIDTH / 3, 325, 200, 50)) {
                game.gameState = STATE.LevelSelect;
                if (game_.music) audioplayer_.getSound("tick").play();
                levels_.lazyDelayFix = 50;
            }
        }
        // help options
        if (game.gameState == STATE.Help) {
            if (mouseOver(mx, my, game_.WIDTH / 3, 100, 200, 50)) {
                p1help = "W, A, S, D";
            }
            if (mouseOver(mx, my, game_.WIDTH / 3, 175, 200, 50)) {
                p2help = "UP, DOWN, LEFT, RIGHT";
            }
            if (mouseOver(mx, my, game_.WIDTH / 3, 250, 200, 50)) {
                if (game_.multiplayer) {
                    game_.multiplayer = false;
                    for (int i = handler.object.size() - 1; i >= 0; i--) {
                        gameobject_ tempObject = handler.object.get(i);
                        if (tempObject.getId() == ID.Player2)
                            handler.removeObject(tempObject);
                    }
                }
                else {
                    game_.multiplayer = true;
                    handler.addObject(new player2_(game_.WIDTH - 128, 200, ID.Player2, handler));
                }
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
//            if (mouseOver(mx, my, game_.WIDTH / 3, 325, 200, 50)) {
//                game.gameState = STATE.Menu;
//                if (game_.music) audioplayer_.getSound("click_sound").play();
//            }
        }
        // back menu for game over
        if (game.gameState == STATE.End) {
            if (mouseOver(mx, my, game_.WIDTH / 3, 325, 200, 50)) {
                game.gameState = STATE.Menu;
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
        }
        // credits
        if (game.gameState != STATE.Game && game.gameState != STATE.LevelSelect && game.gameState != STATE.GameBeta) {
            if (mouseOver(mx, my,0, game_.HEIGHT - 65, 220, 20)) {
                game.gameState = STATE.Credits;
            }
        }
        // easter egg
        if (mouseOver(mx, my, (int)ghost.getX(), (int)ghost.getY(), 30, 30)) {
            ghost_.isControlled = true;
        }
    }
    
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        // easter egg
        if (ghost_.isControlled) {
            tempGhostX = mx - 15;
            tempGhostY = my - 15;
        }
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
    public void tick() {
        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        // easter egg
        if (ghost_.isControlled) {
            ghost.setX(tempGhostX);
            ghost.setY(tempGhostY);
        }
    }
    public void render(Graphics g) {
        // start rotate
        rotateAnimation();

        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
//        if (isRotating) g2d.rotate(Math.toRadians(rotateTick), 0, 0);

        if (game.gameState == STATE.Menu) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            // title
            g.setColor(Color.red);
            g.drawString("game_", game_.WIDTH / 3 + 10, 50);
            // play
            g.setFont(fnt);
            g.setColor(Color.green);
            g.drawRect(game_.WIDTH / 3, 100, 200, 50);
            g.drawString("play_", game_.WIDTH / 3 + 10, 125);
            // help
            g.setColor(Color.yellow);
            g.drawRect(game_.WIDTH / 3, 175, 200, 50);
            g.drawString("help my ass_", game_.WIDTH / 3 + 10, 200);
            // quit
            g.setColor(Color.cyan);
            g.drawRect(game_.WIDTH / 3, 250, 200, 50);
            g.drawString("go fuck urself_", game_.WIDTH / 3 + 10, 275);
            // sounds and sfx
            if (game_.music) {
                g.drawImage(assets_.soundiconon, game_.WIDTH / 3 + 32, 333, null);
                g.setColor(Color.green);
            }
            else {
                g.drawImage(assets_.soundiconoff, game_.WIDTH / 3 + 32, 333, null);
                g.setColor(Color.red);
            }
            g.drawRect(game_.WIDTH / 3, 325, 100, 50);

            // ldm
            if (game_.ldm) g.setColor(Color.green);
            else g.setColor(Color.red);
//            g.setFont(new Font("pusab", 0, 20));
            g.drawString("LDM", game_.WIDTH / 3 + 130, 355);
            g.drawRect(game_.WIDTH / 3 + 100, 325, 100, 50);
        }
        if (game.gameState == STATE.Help) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("help_", game_.WIDTH / 3 + 10, 50);
            g.setFont(fnt);

            g.setColor(Color.cyan);
            g.drawString(p1help, game_.WIDTH / 3 + 10, 125);
            g.setColor(Color.green);
            if (game_.multiplayer) {
                g.drawString(p2help, game_.WIDTH / 3 + 10, 200);
            } else g.setColor(Color.red);
            g.drawRect(game_.WIDTH / 3, 250, 200, 50);
            g.drawString("nigga_", game_.WIDTH / 3 + 10, 275);

//            g.setColor(Color.red);
//            g.drawString("nigga_", game_.WIDTH / 3 + 10, 350);
//            g.drawRect(game_.WIDTH / 3, 325, 200, 50);
        }
        if (game.gameState == STATE.End) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("gg_", game_.WIDTH / 3 + 10, 50);
            g.setFont(fnt);

            g.setColor(Color.cyan);
            g.drawString("p1_: " + hud.getScore() , game_.WIDTH / 3 + 10, 125);

            g.setColor(Color.green);
            if (game_.multiplayer) g.drawString("p2_: " + hud2.getScore(), game_.WIDTH / 3 + 10, 200);

            g.setColor(Color.yellow);
            g.drawString(hud.tellTime(), game_.WIDTH / 3 + 10, 275);

            g.setColor(Color.RED);
            g.drawString("menu_", game_.WIDTH / 3 + 10, 350);
            g.drawRect(game_.WIDTH / 3, 325, 200, 50);
        }
        if (game.gameState == STATE.Select) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("diff_", game_.WIDTH / 3 + 10, 50);
            g.setFont(fnt);

            g.setColor(Color.cyan);
            g.drawRect(game_.WIDTH / 3, 100, 200, 50);
            g.drawString("too young to die_", game_.WIDTH / 3 + 10, 125);

            g.setColor(Color.green);
            g.drawRect(game_.WIDTH / 3, 175, 200, 50);
            g.drawString("hurt me plenty_", game_.WIDTH / 3 + 10, 200);

            g.setColor(Color.red);
            g.drawString("nightmare?_", game_.WIDTH / 3 + 10, 275);
            g.drawRect(game_.WIDTH / 3, 250, 200, 50);

            g.setColor(col);
            g.drawString("worlds beta_", game_.WIDTH / 3 + 10, 350);
            g.drawRect(game_.WIDTH / 3, 325, 200, 50);
        }
        if (game.gameState == STATE.Credits) {
            // credits
//        g.drawString("Engine based on RealTutsGML's Wave© game", 0, game_.HEIGHT - 100);
//        g.drawString("© Kennedy \"HACKER EXPOSER\" Peña", 0, game_.HEIGHT - 50);
            g.drawString("Creator: John Kennedy Haringa Peña", 100, 100);
        }

        // end rotate
        g2d.setTransform(old);

        // default
        g.setFont(new Font("mojangles", 0, 15));
        // fps
        g.setColor(Color.green);
        g.drawString("FPS: " + game_.throwframes, game_.WIDTH - 100, game_.HEIGHT - 75);
        g.drawString("Objects: " + handler.object.size(), game_.WIDTH - 130, game_.HEIGHT - 50);
        g.drawString("© The Karakters Kompany", 0, game_.HEIGHT - 50);
        g.drawRect(0, game_.HEIGHT - 65, 220, 20);
    }
    // still unimplemented
    void rotateAnimation() {
        if (rotateTick != 0) rotateTick++;
        else {
            isRotating = false;
        }
        if (rotateTick == 90) {
            rotateTick = -90;
        }
    }
}
