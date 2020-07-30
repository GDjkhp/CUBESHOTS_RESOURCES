/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_;

import gamemakerstudio_.entities.*;
import gamemakerstudio_.game_.STATE;
import gamemakerstudio_.gui.hud2_;
import gamemakerstudio_.gui.hud_;
import gamemakerstudio_.gui.shop_;
import gamemakerstudio_.misc.audioplayer_;
import gamemakerstudio_.world.levels_;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class KeyInput extends KeyAdapter {
    
    private handler_ handler;
    game_ game;
    hud_ hud;
    hud2_ hud2;

    private Random r = new Random();

    public boolean[] keyDownP1 = new boolean[6];
    public boolean[] keyDownP2 = new boolean[6];
//    // north
//    private static int northVelY = -5;
//    // east
//    private static int eastVelX = 5;
//    // west
//    private static int westVelX = -5;
//    int cooldownp1 = 0, cooldownp2 = 0;
//    public static int defaultcooldown = 5;
    
    public KeyInput(handler_ handler, game_ game, hud_ hud, hud2_ hud2) {
        this.handler = handler;
        this.game = game;
        this.hud = hud;
        this.hud2 = hud2;
        keyDownP1[0] = false;
        keyDownP1[1] = false;
        keyDownP1[2] = false;
        keyDownP1[3] = false;
        keyDownP1[4] = false;
        keyDownP1[5] = false;
        keyDownP2[0] = false;
        keyDownP2[1] = false;
        keyDownP2[2] = false;
        keyDownP2[3] = false;
        keyDownP2[4] = false;
        keyDownP2[5] = false;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // p1 misc
        if (key == KeyEvent.VK_E) {player_.isShooting = true; keyDownP1[4] = true;}
        if (key == KeyEvent.VK_Q) {player_.isDashing = true; keyDownP1[5] = true;}

        // p2 misc
        if (key == KeyEvent.VK_CONTROL) {player2_.isShooting = true; keyDownP2[4] = true;}
        if (key == KeyEvent.VK_SHIFT) {player2_.isDashing = true; keyDownP2[5] = true;}

        for (int i = 0; i < handler.object.size(); i++) {

            gameobject_ tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                // player one key map
                if (key == KeyEvent.VK_W) {tempObject.setVelY(-handler.spdp1); keyDownP1[0] = true;}
                if (key == KeyEvent.VK_S) {tempObject.setVelY(handler.spdp1); keyDownP1[1] = true;}
                if (key == KeyEvent.VK_A) {tempObject.setVelX(-handler.spdp1); keyDownP1[2] = true;}
                if (key == KeyEvent.VK_D) {tempObject.setVelX(handler.spdp1); keyDownP1[3] = true;}
            }

            if (tempObject.getId() == ID.Player2) {
                // player two key map
                if (key == KeyEvent.VK_UP) {tempObject.setVelY(-handler.spdp2); keyDownP2[0] = true;}
                if (key == KeyEvent.VK_DOWN) {tempObject.setVelY(handler.spdp2); keyDownP2[1] = true;}
                if (key == KeyEvent.VK_LEFT) {tempObject.setVelX(-handler.spdp2); keyDownP2[2] = true;}
                if (key == KeyEvent.VK_RIGHT) {tempObject.setVelX(handler.spdp2); keyDownP2[3] = true;}
            }
        }
        // misc
        if (key == KeyEvent.VK_P) {
            if (game.gameState == STATE.Game) {
                if (game_.paused) game_.paused = false;
                else game_.paused = true;
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            game.gameState = STATE.Menu;
            // end codes
            if (game.gameState == STATE.Game || game.gameState == STATE.GameBeta) {
                if (game.multiplayer) {
                    hud_.HEALTH = 100;
                    hud2_.HEALTH = 100;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                } else {
                    hud_.HEALTH = 100;
                    hud2_.HEALTH = 100;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
        }
        if (key == KeyEvent.VK_SPACE) {
            if (game.gameState == STATE.Game) {
                if (!game_.paused) {
                    if (game_.music) audioplayer_.getMusic("shop_music").loop();
                    game.gameState = STATE.Shop;
                }
            }
            else if (game.gameState == STATE.Shop) {
                if (game_.music) audioplayer_.getMusic("music").loop();
                game.gameState = STATE.Game;
            }
        }
        if (key == KeyEvent.VK_F1) {
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
        if (key == KeyEvent.VK_F2) {
            if (game.gameState != STATE.End) {
                if (game_.multiplayer) {
                    game_.multiplayer = false;
                    for (int i = handler.object.size() - 1; i >= 0; i--) {
                        gameobject_ tempObject = handler.object.get(i);
                        if (tempObject.getId() == ID.Player2)
                            handler.removeObject(tempObject);
                    }
                } else {
                    game_.multiplayer = true;
                    handler.addObject(new player2_(game_.WIDTH - 128, 200, ID.Player2, handler));
                }
                if (game_.music) audioplayer_.getSound("click_sound").play();
            }
        }
        // shop keys
        if (game.gameState == STATE.Game || game.gameState == STATE.Shop) {
            if (key == KeyEvent.VK_1) {
                if (hud.getXp() >= shop_.B1) {
                    hud.setXp(hud.getXp() - shop_.B1);
                    shop_.B1 += shop_.B1;
                    hud_.bounds += 20;
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                }
            }
            if (key == KeyEvent.VK_2) {
                if (hud.getXp() >= shop_.B2) {
                    hud.setXp(hud.getXp() - shop_.B2);
                    shop_.B2 += shop_.B2;
                    handler_.spdp1 += 5;
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                }
            }
            if (key == KeyEvent.VK_3) {
                if (hud.getXp() >= shop_.B3) {
                    if (hud.HEALTH != (100 + (hud.bounds / 2))) {
                        hud.setXp(hud.getXp() - shop_.B3);
                        hud.HEALTH = (100 + (hud.bounds / 2));
                        if (game_.music) audioplayer_.getSound("click_sound").play();
                    }
                }
            }
            if (key == KeyEvent.VK_4) {
                if (hud2.getXp() >= shop_.B4) {
                    hud2.setXp(hud2.getXp() - shop_.B4);
                    shop_.B4 += shop_.B4;
                    hud2_.bounds += 20;
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                }
            }
            if (key == KeyEvent.VK_5) {
                if (hud2.getXp() >= shop_.B5) {
                    hud2.setXp(hud2.getXp() - shop_.B5);
                    shop_.B5 += shop_.B5;
                    handler_.spdp2 += 5;
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                }
            }
            if (key == KeyEvent.VK_6) {
                if (hud2.getXp() >= shop_.B6) {
                    if (hud2.HEALTH != (100 + (hud2.bounds / 2))) {
                        hud2.setXp(hud2.getXp() - shop_.B6);
                        hud2.HEALTH = (100 + (hud2.bounds / 2));
                        if (game_.music) audioplayer_.getSound("click_sound").play();
                    }
                }
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        // player one key map
        if (key == KeyEvent.VK_W) keyDownP1[0] = false;
        if (key == KeyEvent.VK_S) keyDownP1[1] = false;
        if (key == KeyEvent.VK_A) keyDownP1[2] = false;
        if (key == KeyEvent.VK_D) keyDownP1[3] = false;
        if (key == KeyEvent.VK_E) keyDownP1[4] = false;
        if (key == KeyEvent.VK_Q) keyDownP1[5] = false;

        // player two key map
        if (key == KeyEvent.VK_UP) keyDownP2[0] = false;
        if (key == KeyEvent.VK_DOWN) keyDownP2[1] = false;
        if (key == KeyEvent.VK_LEFT) keyDownP2[2] = false;
        if (key == KeyEvent.VK_RIGHT) keyDownP2[3] = false;
        if (key == KeyEvent.VK_CONTROL) keyDownP2[4] = false;
        if (key == KeyEvent.VK_SHIFT) keyDownP2[5] = false;

        // p1 reset
        if (!keyDownP1[4]) {player_.isShooting = false; player_.cooldownp1 = 0;}
        if (!keyDownP1[5]) {player_.dashcooldown = 15;}

        // p2 reset
        if (!keyDownP2[4]) {player2_.isShooting = false; player2_.cooldownp2 = 0;}
        if (!keyDownP2[5]) {player2_.dashcooldown = 15;}

        for (int i = 0; i < handler.object.size(); i++) {
            
            gameobject_ tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Player) {
                // vertical movement
                if (!keyDownP1[0] && !keyDownP1[1]) tempObject.setVelY(0);
                // horizontal movement
                if (!keyDownP1[2] && !keyDownP1[3]) tempObject.setVelX(0);
            }
            
            if (tempObject.getId() == ID.Player2) {
                // vertical movement
                if (!keyDownP2[0] && !keyDownP2[1]) tempObject.setVelY(0);
                // horizontal movement
                if (!keyDownP2[2] && !keyDownP2[3]) tempObject.setVelX(0);
            }
        }
    }
}
