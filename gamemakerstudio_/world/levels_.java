/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.world;

import gamemakerstudio_.ID;
import gamemakerstudio_.entities.*;
import gamemakerstudio_.game_;
import gamemakerstudio_.gui.hud2_;
import gamemakerstudio_.gui.hud_;
import gamemakerstudio_.handler_;
import gamemakerstudio_.misc.audioplayer_;
import gamemakerstudio_.spawn_;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class levels_ extends MouseAdapter{
    private handler_ handler;
    private hud_ hud;
    private game_ game;
    private hud2_ hud2;
    private Random r = new Random();
    // music misc
    public static double bpm;
    private double tpm;

    private boolean metronome = true;

    public static double scoreKeep = 0;
    private double difference;

    public static int levelid = 0;
    String testString = "0";

    public levels_(handler_ handler, hud_ hud, game_ game, hud2_ hud2) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
        this.hud2 = hud2;
    }

    public void tick() {
        if (game.gameState == game_.STATE.GameBeta) {
            tpm = (60000/bpm) / 10;
            if (levelid == 1) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 84) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 2) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.Laser, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 130) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 3) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 144) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 4) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 106) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 5) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 122) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 6) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 102) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 7) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 88) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 8) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 110) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 9) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 90) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 10) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 94) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 11) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 139) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 12) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 72) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 13) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 73) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
            if (levelid == 14) {
                // spawn code
                scoreKeep++;
                if (scoreKeep >= tpm) {
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                    if (metronome) handler.metronomeCode();
                }
                // end code
                if (handler.total_bars == 179) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (game.gameState == game_.STATE.LevelSelect) {
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, 50, 50, 50, 50)) {
                levelid = 1;
                System.out.println("world 1");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("dead_meme").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 125;
            }
            if (mouseOver(mx, my, 150, 50, 50, 50)) {
                levelid = 2;
                System.out.println("world 2");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("dead_meme_2").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 126;
            }
            if (mouseOver(mx, my, 250, 50, 50, 50)) {
                levelid = 3;
                System.out.println("world 3");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("eschew").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 120;
            }
            if (mouseOver(mx, my, 350, 50, 50, 50)) {
                levelid = 4;
                System.out.println("world 4");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("rock_the_house").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 128;
            }
            if (mouseOver(mx, my, 450, 50, 50, 50)) {
                levelid = 5;
                System.out.println("world 5");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("end_of_time").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 132;
            }
            if (mouseOver(mx, my, 550, 50, 50, 50)) {
                levelid = 6;
                System.out.println("world 6");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("nova_music").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 105;
            }
            // second row
            if (mouseOver(mx, my, 50, 150, 50, 50)) {
                levelid = 7;
                System.out.println("world 7");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("time_leaper").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 87.5;
            }
            if (mouseOver(mx, my, 150, 150, 50, 50)) {
                levelid = 8;
                System.out.println("world 8");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("gg").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 87.5;
            }
            if (mouseOver(mx, my, 250, 150, 50, 50)) {
                levelid = 9;
                System.out.println("world 9");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("namice1").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 128;
            }
            if (mouseOver(mx, my, 350, 150, 50, 50)) {
                levelid = 10;
                System.out.println("world 10");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("namice2").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 128;
            }
            if (mouseOver(mx, my, 450, 150, 50, 50)) {
                levelid = 11;
                System.out.println("world 11");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("there").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 127;
            }
            if (mouseOver(mx, my, 550, 150, 50, 50)) {
                levelid = 12;
                System.out.println("world 12");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("namice3").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 128;
            }
            // third row
            if (mouseOver(mx, my, 50, 250, 50, 50)) {
                levelid = 13;
                System.out.println("world 13");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("fisher_price").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 92.5;
            }
            if (mouseOver(mx, my, 150, 250, 50, 50)) {
                levelid = 14;
                System.out.println("world 14");
                if (game_.music) audioplayer_.getSound("click_sound").play();
                if (game_.music) audioplayer_.getMusic("dance_violins").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;
                handler.total_bars = 1;
                handler.total_beats = 1;
                handler.fourbarticks = 1;
                bpm = 130;
            }
        }
    }
    // this shit doesn't work, why?
    public void mouseMoved(MouseEvent e) {
        if (game.gameState == game_.STATE.LevelSelect) {
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, 50, 50, 50, 50)) {
                if (game_.music) audioplayer_.getSound("click_sound").play();
                testString = "1";
            }
        }
    }



    public void render(Graphics g) {
        if (game.gameState == game_.STATE.LevelSelect) {
            g.setColor(Color.green);
            g.drawString(testString, 0, 20);
            g.drawRect(50, 50, 50, 50);
            g.drawRect(150, 50, 50, 50);
            g.drawRect(250, 50, 50, 50);
            g.drawRect(350, 50, 50, 50);
            g.drawRect(450, 50, 50, 50);
            g.drawRect(550, 50, 50, 50);
            // second row
            g.drawRect(50, 150, 50, 50);
            g.drawRect(150, 150, 50, 50);
            g.drawRect(250, 150, 50, 50);
            g.drawRect(350, 150, 50, 50);
            g.drawRect(450, 150, 50, 50);
            g.drawRect(550, 150, 50, 50);
            // third row
            g.drawRect(50, 250, 50, 50);
            g.drawRect(150, 250, 50, 50);
        }
        if (game.gameState == game_.STATE.GameBeta) {
            g.drawString("Bar: " + handler.total_bars + ", Beat: " + handler.total_beats, game.WIDTH - 300, 64);
            g.drawString(String.valueOf(difference), game.WIDTH - 300, 80);
        }
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
    private void resetMethod() {
        // reset
        game.gameState = game_.STATE.GameBeta;
        hud.resetTimer();
        handler.clearEnemies();
        hud.setLevel(1);
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
    }

}
