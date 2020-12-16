/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.gui;

import gamemakerstudio_.*;
import gamemakerstudio_.entities.*;
import gamemakerstudio_.game_.STATE;
import gamemakerstudio_.misc.*;
import gamemakerstudio_.world.levels_;
import gamemakerstudio_.world.spawn_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class menu_ implements KeyListener, MouseMotionListener, MouseListener {
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
    private gameobject_ ghost;
    int tempGhostX;
    int tempGhostY;
    
    // grid fix
    int xOffset = game_.WIDTH/2 - 100;
    
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

    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        // menu
        if (game.gameState == STATE.Menu) {
            // play
            if (mouseOver(mx, my, xOffset, 100, 200, 50)) {
                // test rotate
//                isRotating = true;
//                rotateTick++;

                game.gameState = STATE.Select;
                if (game_.music) audioplayer_.getSound("click_sound").play();
                return;
            }
            // help
            if (mouseOver(mx, my, xOffset, 175, 200, 50)) {
                game.gameState = STATE.Help;
                if (game_.music) audioplayer_.getSound("click_sound").play();
                return;
            }
            // quit
            if (mouseOver(mx, my, xOffset, 250, 200, 50)) {
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game.JOptionPaneOption) {
                    int a = JOptionPane.showConfirmDialog(null, "Are you sure?", "Quit", JOptionPane.INFORMATION_MESSAGE);
                    if (a == JOptionPane.YES_OPTION) System.exit(0);
                } else System.exit(0);
            }
            // sounds and sfx
            if (mouseOver(mx, my, xOffset, 325, 100, 50)) {
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
            if (mouseOver(mx, my, xOffset + 100, 325, 100, 50)) {
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.ldm) game_.ldm = false;
                else game_.ldm = true;
            }
        }
        // diff
        if (game.gameState == STATE.Select) {
            // easy
            if (mouseOver(mx, my, xOffset, 100, 200, 50)) {
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
                hud.heartsTaken = 0;
                // p2 reset
                hud2.setScore(0);
                hud2.setXp(0);
                hud2_.HEALTH = 100;
                handler_.spdp2 = 5;
                hud2_.bounds = 0;
                hud2.heartsTaken = 0;
                // reset shop
                shop_.B1 = 100;
                shop_.B2 = 100;
                shop_.B3 = 100;
                shop_.B4 = 100;
                shop_.B5 = 100;
                shop_.B6 = 100;
                // spawn
                handler.addObject(new basicenemy_(r.nextInt(game_.WIDTH - 1), r.nextInt(game_.HEIGHT - 1), ID.BasicEnemy, handler));
                game.diff = 0;
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
            // medium
            if (mouseOver(mx, my, xOffset, 175, 200, 50)) {
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
                handler.addObject(new hardenemy_(r.nextInt(game_.WIDTH - 1), r.nextInt(game_.HEIGHT - 1), ID.BasicEnemy, handler));
                game.diff = 1;
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
            // hard?
            if (mouseOver(mx, my, xOffset, 250, 200, 50)) {
                System.out.println("u are too gei to die_");
                // ideas: circle of darkness mode, just like in caves in pokemon
            }
            // beta
            if (mouseOver(mx, my, xOffset, 325, 200, 50)) {
                game.gameState = STATE.LevelSelect;
                if (game_.music) audioplayer_.getSound("tick").play();
                levels_.lazyDelayFix = 100;
            }
        }
        // help options
        if (game.gameState == STATE.Help) {
            if (mouseOver(mx, my, xOffset, 100, 200, 50)) {
                p1help = "W, A, S, D";
            }
            if (mouseOver(mx, my, xOffset, 175, 200, 50)) {
                p2help = "UP, DOWN, LEFT, RIGHT";
            }
            if (mouseOver(mx, my, xOffset, 250, 200, 50)) {
                if (game_.multiplayer) {
                    game_.multiplayer = false;
                    for (int i = handler.object.size() - 1; i >= 0; i--) {
                        gameobject_ tempObject = handler.object.get(i);
                        if (tempObject.getId() == ID.Player2 || tempObject.getId() == ID.P2Range)
                            handler.removeObject(tempObject);
                    }
                    if (game_.music) audioplayer_.getSound("alert").play();
                }
                else {
                    if (game_.music) audioplayer_.getSound("alert").play();
                    game_.multiplayer = true;
                    handler.addObject(new player2_(game_.WIDTH - 128, 200, ID.Player2, handler, hud2));
                    handler.addObject(new RangeArea(0, 0, ID.P2Range, handler));
                }
            }
            if (mouseOver(mx, my, xOffset, 325, 100, 50)) {
                if (game.computerP1) game.computerP1 = false;
                else game.computerP1 = true;
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
            if (mouseOver(mx, my, xOffset + 100, 325, 100, 50)) {
                if (game.computerP2) game.computerP2 = false;
                else game.computerP2 = true;
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
        }
        // back menu for game over
        if (game.gameState == STATE.End) {
            if (mouseOver(mx, my, xOffset, 325, 200, 50)) {
                game.gameState = STATE.Menu;
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("music").loop();
            }
        }
        // credits
        if (game.gameState != STATE.Game && game.gameState != STATE.LevelSelect && game.gameState != STATE.GameBeta) {
            if (mouseOver(mx, my,0, game_.HEIGHT - 65, 220, 20)) {
                game.gameState = STATE.Credits;
            }
        }
        // easter egg
        for (int i = handler.object.size() - 1; i >= 0; i--) {
            gameobject_ tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.GHOST) {
                if (mouseOver(mx, my, (int)ghost.getX(), (int)ghost.getY(), 30, 30)) {
                    ghost_.isControlled = true;
                }
            }
        }
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

    int percentHud, percentHud2;

    double tpmTemp, spmTemp;
    
    public void tick() {
        // dumb init
        try {
            // old
            percentHud = (int) ((((double) hud.getScore()) /
                    (((60000 / levels_.bpm) / 10) * ((double) (levels_.endBar * 4) - 3))) * 100);
            percentHud2 = (int) ((((double) hud2.getScore()) /
                    (((60000 / levels_.bpm) / 10) * ((double) (levels_.endBar * 4) - 3))) * 100);
            // new
            /* fix the percentHud code */
            tpmTemp = (60000 / levels_.bpm) / 10;
            spmTemp = tpmTemp * 4 / 16;

        } catch (Exception e){

        }
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
        // menu
        if (game.gameState == STATE.Menu) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            // title
            g.setColor(Color.red);
            g.drawString("game_", xOffset + 10, 50);
            // play
            g.setFont(fnt);
            g.setColor(Color.green);
            g.drawRect(xOffset, 100, 200, 50);
            g.drawString("play_", xOffset + 10, 125);
            // help
            g.setColor(Color.yellow);
            g.drawRect(xOffset, 175, 200, 50);
            g.drawString("help_", xOffset + 10, 200);
            // quit
            g.setColor(Color.cyan);
            g.drawRect(xOffset, 250, 200, 50);
            g.drawString("quit_", xOffset + 10, 275);
            // sounds and sfx
            if (game_.music) {
                g.drawImage(assets_.soundiconon, xOffset + 32, 333, null);
                g.setColor(Color.green);
            }
            else {
                g.drawImage(assets_.soundiconoff, xOffset + 32, 333, null);
                g.setColor(Color.red);
            }
            g.drawRect(xOffset, 325, 99, 50);

            // ldm
            if (game_.ldm) g.setColor(Color.green);
            else g.setColor(Color.red);
//            g.setFont(new Font("pusab", 0, 20));
            g.drawString("LDM", xOffset + 130, 355);
            g.drawRect(xOffset + 100, 325, 100, 50);
        }
        // help
        if (game.gameState == STATE.Help) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("help_", xOffset + 10, 50);
            g.setFont(fnt);

            g.setColor(Color.cyan);
            g.drawString(p1help, xOffset + 10, 125);

            g.setColor(Color.green);
            if (game_.multiplayer) {
                g.drawString(p2help, xOffset + 10, 200);
            } else g.setColor(Color.red);

            g.drawRect(xOffset, 250, 200, 50);
            g.drawString("multiplayer_", xOffset + 10, 275);

            if (game.computerP1) g.setColor(Color.CYAN);
            else g.setColor(Color.RED);
            g.drawRect(xOffset, 325, 99, 50);

            if (game.computerP2) g.setColor(Color.GREEN);
            else g.setColor(Color.RED);
            g.drawRect(xOffset + 100, 325, 100, 50);

//            g.setColor(Color.red);
//            g.drawString("nigga_", xOffset + 10, 350);
//            g.drawRect(xOffset, 325, 200, 50);
        }
        // game over
        if (game.gameState == STATE.End) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("gg_", xOffset + 10, 50);
            g.setFont(fnt);

            g.setColor(Color.cyan);
            if (!game.currentGameStateIsBeta)
                g.drawString("p1_: " + hud.getScore(), xOffset + 10, 125);
            else {
                g.drawString("p1_: " + hud.getScore() + " - " + game.clamp(percentHud, 0, 100) + "%",
                        xOffset + 10, 125);

                g.drawString("hearts_: " + hud.heartsTaken,
                        xOffset + 10, 150);
            }

            g.setColor(Color.green);
            if (game_.multiplayer) {
                if (!game.currentGameStateIsBeta)
                    g.drawString("p2_: " + hud2.getScore(), xOffset + 10, 200);
                else {
                    g.drawString("p2_: " + hud2.getScore() + " - " + game.clamp(percentHud2, 0, 100) + "%",
                            xOffset + 10, 200);
                    g.drawString("hearts_: " + hud2.heartsTaken,
                            xOffset + 10, 225);
                }
            }

            /*g.setColor(Color.cyan);
            g.drawRect(xOffset, 100, 200, 50);

            g.setColor(Color.green);
            g.drawRect(xOffset, 175, 200, 50);*/

            g.setColor(Color.yellow);
            // i know this is not the efficient way
            if (!game.currentGameStateIsBeta)
                g.drawString(hud.tellTime(), xOffset + 10, 275);
            else
                g.drawString(hud.tellTime() + " - " + (int) levels_.durationBar + "%", xOffset + 10, 275);

            g.setColor(Color.RED);
            g.drawString("menu_", xOffset + 10, 350);
            g.drawRect(xOffset, 325, 200, 50);
        }
        // diff selection
        if (game.gameState == STATE.Select) {
            Font fnthead = new Font("mojangles", 1, 50);
            Font fnt = new Font("mojangles", 0, 20);
            g.setFont(fnthead);
            g.setColor(Color.red);
            g.drawString("diff_", xOffset + 10, 50);
            g.setFont(fnt);

            g.setColor(Color.cyan);
            g.drawRect(xOffset, 100, 200, 50);
            g.drawString("too young to die_", xOffset + 10, 125);

            g.setColor(Color.green);
            g.drawRect(xOffset, 175, 200, 50);
            g.drawString("hurt me plenty_", xOffset + 10, 200);

            g.setColor(Color.red);
            g.drawString("nightmare?_", xOffset + 10, 275);
            g.drawRect(xOffset, 250, 200, 50);

            g.setColor(col);
            g.drawString("worlds beta_", xOffset + 10, 350);
            g.drawRect(xOffset, 325, 200, 50);
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
        g.drawString("FPS/TPS: " + game_.throwframes + "/" + game_.throwTick, game_.WIDTH - 150, game_.HEIGHT - 75);
        g.drawString("Objects: " + handler.object.size(), game_.WIDTH - 125, game_.HEIGHT - 50);
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

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}
}
