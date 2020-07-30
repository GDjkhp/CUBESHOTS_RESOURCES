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
import java.awt.geom.AffineTransform;
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

    // duration bar
    double durationBar;
    int durationValue = 255;

    // music misc
    public static double bpm;
    private double tpm;
    private double spm;
    int endBar;

    private boolean metronome = true;

    public static double scoreKeep = 0;
    public static double scoreKeepStep = 0;

    private double difference;
    private double stepDifference;

    public static int levelid = 0;
    String testString = "0";

    public static int lazyDelayFix = 50;

    public levels_(handler_ handler, hud_ hud, game_ game, hud2_ hud2) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
        this.hud2 = hud2;
    }

    public void mousePressed(MouseEvent e) {
        if (lazyDelayFix == 0) {
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
                    
                    bpm = 125;
                    endBar = 84;
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
                    
                    bpm = 126;
                    endBar = 130;
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
                    
                    bpm = 120;
                    endBar = 144;
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
                    
                    bpm = 128;
                    endBar = 106;
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
                    
                    bpm = 132;
                    endBar = 122;
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
                    
                    bpm = 105;
                    endBar = 102;
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
                    
                    bpm = 87.5;
                    endBar = 88;
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
                    
                    bpm = 87.5;
                    endBar = 110;
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
                    
                    bpm = 128;
                    endBar = 90;
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
                    
                    bpm = 128;
                    endBar = 94;
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
                    
                    bpm = 127;
                    endBar = 139;
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
                    
                    bpm = 128;
                    endBar = 72;
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
                    
                    bpm = 92.5;
                    endBar = 73;
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
                    
                    bpm = 130;
                    endBar = 179;
                }
                if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    levelid = 15;
                    System.out.println("world 15");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("aether").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 165;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    levelid = 16;
                    System.out.println("world 16");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("clickbait").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 140;
                    endBar = 113;
                }
                if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    levelid = 17;
                    System.out.println("world 17");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("debug").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 130;
                    endBar = 218;
                }
                if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    levelid = 18;
                    System.out.println("world 18");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("iy").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 114;
                    endBar = 125;
                }
                // fourth row
                if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    levelid = 19;
                    System.out.println("world 19");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("ye").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 110;
                    endBar = 30;
                }
                if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    levelid = 20;
                    System.out.println("world 20");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("mocha").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 160;
                    endBar = 138;
                }
                if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    levelid = 21;
                    System.out.println("world 21");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("everything_falls").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 90;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    levelid = 22;
                    System.out.println("world 22");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("lovely_forest").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 101;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    levelid = 23;
                    System.out.println("world 23");
                    if (game_.music) audioplayer_.getSound("click_sound").play();
                    if (game_.music) audioplayer_.getMusic("saxophone").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;
                    
                    bpm = 96;
                    endBar = 31;
                }

            }
        }
    }
    public void tick() {
        if (lazyDelayFix != 0) lazyDelayFix--;
        if (game.gameState == game_.STATE.GameBeta && bpm != 0 && endBar != 0) {

            // run this code once
            tpm = (60000/bpm) / 10;
            spm = tpm * 4 / 16;

            if (levelid == 1) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                // beats
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;

                    if (handler.total_bars >= 2 && handler.total_bars != 25 && handler.total_bars != 42 && handler.total_bars != 43) {
                        handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH), 1, ID.Laser, handler));
                    }
                    if (handler.total_bars >= 10 && handler.total_bars != 25 && handler.total_bars != 42 && handler.total_bars != 43) {
                        handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                                ID.HeartFriend, handler));
                        handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                                ID.BaseCircle, handler));
                    }
                    if (handler.total_beats == 69 /*nice*/) {
                        handler.addObject(new ghost_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50), ID.GHOST));
                        handler.addObject(new starwrathenemy_(r.nextInt(game.WIDTH), r.nextInt(game.HEIGHT), ID.Star, handler));
                    }
                    if (handler.total_beats == 97) handler.removeObjectsExceptPlayers();
                    if (handler.total_bars == 25) {
                        crazyboss_.customRotateByTick = false;
                        // animation crazy boss
                        // frame one
                        if (handler.fourbarticks == 1) {
                            System.out.println("frame one");
                            handler.addObject(new crazyboss_(-128, 0, ID.CrazyBoss, handler, handler.goRight, handler.stay));
                        }
                        // frame two
                        if (handler.fourbarticks == 2) {
                            System.out.println("frame two");
                            handler.addObject(new crazyboss_(game.WIDTH, 0, ID.CrazyBoss, handler, handler.goLeft, handler.stay));
                        }
                        // frame three
                        if (handler.fourbarticks == 3) {
                            System.out.println("frame three");
                            handler.addObject(new crazyboss_(game.WIDTH / 2 - 128, -128, ID.CrazyBoss, handler, handler.stay, handler.goDown));
                        }
                        // frame four
                        if (handler.fourbarticks == 4) {
                            System.out.println("frame four");
                            handler.addObject(new crazyboss_(game.WIDTH / 2 - 128, game_.HEIGHT, ID.CrazyBoss, handler, handler.stay, handler.goUp));
                        }
                    }
                    if (handler.total_beats == 101) {
                        handler.removeAllSelectedObjectsExceptPlayers(ID.CrazyBoss);
                        handler.addObject(new crazyboss_(game_.WIDTH / 2 - 128, game_.HEIGHT / 2 - 128, ID.CrazyBoss, handler, 0, 0));
                    }
                    if (handler.total_beats >= 101) {
                        // run this code once
                        crazyboss_.customRotateByTick = true;
                        crazyboss_.minRotate = -45;
                        crazyboss_.maxRotate = 45;
                        crazyboss_.rotateThisTick = 20;
                        // run this code once the tick was called
                        if (crazyboss_.increment) crazyboss_.increment = false;
                        else crazyboss_.increment = true;
                    }
                    if (handler.total_bars == 42 || handler.total_bars == 43) {
                        // rest
                        handler.removeObjectsExceptPlayers();
                    }
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 84
            if (levelid == 2) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.Laser, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 130
            if (levelid == 3) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 144
            if (levelid == 4) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 106
            if (levelid == 5) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 122
            if (levelid == 6) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 102
            if (levelid == 7) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 88
            if (levelid == 8) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 110
            if (levelid == 9) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 90
            if (levelid == 10) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 94
            if (levelid == 11) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 139
            if (levelid == 12) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 72
            if (levelid == 13) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 73
            if (levelid == 14) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 179
            if (levelid == 15) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 66
            if (levelid == 16) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 113
            if (levelid == 17) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 218
            if (levelid == 18) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 125
            if (levelid == 19) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 30
            if (levelid == 20) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 138
            if (levelid == 21) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 66
            if (levelid == 22) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 66
            if (levelid == 23) {
                // spawn code
                scoreKeep++;
                scoreKeepStep++;
                if (scoreKeep >= tpm) {
                    if (metronome) handler.metronomeCode();
                    difference = scoreKeep - tpm;
                    scoreKeep = difference;
                    handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.HeartFriend, handler));
                    handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.BaseCircle, handler));
                }
                // steps
                if (scoreKeepStep >= spm) {
                    handler.stepsBeta();
                    stepDifference = scoreKeepStep - spm;
                    scoreKeepStep = stepDifference;
                }
                // end code
                if (handler.total_bars == endBar) {
                    game.gameState = game_.STATE.End;
                    handler.clearEnemies();
                    for (int i = 1; i <= 50; i++)
                        handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 50), r.nextInt(game.HEIGHT - 50), ID.Spicy, handler));
                }
            } // 31
            // new code
            

            // duration bar
            durationBar = (((double)handler.total_bars / (((double)endBar))) * 100);
            durationValue = (int) durationBar * 2;
            durationValue = game.clamp(durationValue, 0, 255);
        }
    }

    // this shit doesn't work, why? edit: now it works but unexpected happened.
    public void mouseMoved(MouseEvent e) {
        if (game.gameState == game_.STATE.LevelSelect) {
            int mx = e.getX();
            int my = e.getY();
            if (mouseOver(mx, my, 50, 50, 50, 50)) {
                testString = "1. Shiatsu";
            }
            else if (mouseOver(mx, my, 150, 50, 50, 50)) {
                testString = "2. Astronomia";
            }
            else if (mouseOver(mx, my, 250, 50, 50, 50)) {
                testString = "3. Andromeda";
            }
            else if (mouseOver(mx, my, 350, 50, 50, 50)) {
                testString = "4. Rock the House";
            }
            else if (mouseOver(mx, my, 450, 50, 50, 50)) {
                testString = "5. End of Time";
            }
            else if (mouseOver(mx, my, 550, 50, 50, 50)) {
                testString = "6. Breathe";
            }
            // second row
            else if (mouseOver(mx, my, 50, 150, 50, 50)) {
                testString = "7. Time Leaper";
            }
            else if (mouseOver(mx, my, 150, 150, 50, 50)) {
                testString = "8. GG WP";
            }
            else if (mouseOver(mx, my, 250, 150, 50, 50)) {
                testString = "9. Moment of Truth";
            }
            else if (mouseOver(mx, my, 350, 150, 50, 50)) {
                testString = "10. Another World";
            }
            else if (mouseOver(mx, my, 450, 150, 50, 50)) {
                testString = "11. There";
            }
            else if (mouseOver(mx, my, 550, 150, 50, 50)) {
                testString = "12. Harmonies";
            }
            // third row
            else if (mouseOver(mx, my, 50, 250, 50, 50)) {
                testString = "13. Fisher Price";
            }
            else if (mouseOver(mx, my, 150, 250, 50, 50)) {
                testString = "14. Dance of the Violins";
            }
            else if (mouseOver(mx, my, 250, 250, 50, 50)) {
                testString = "15. Aether";
            }
            else if (mouseOver(mx, my, 350, 250, 50, 50)) {
                testString = "16. Clickbait";
            }
            else if (mouseOver(mx, my, 450, 250, 50, 50)) {
                testString = "17. Debug";
            }
            else if (mouseOver(mx, my, 550, 250, 50, 50)) {
                testString = "18. F*csa Iy";
            }
            // fourth row
            else if (mouseOver(mx, my, 50, 350, 50, 50)) {
                testString = "19. Ye";
            }
            else if (mouseOver(mx, my, 150, 350, 50, 50)) {
                testString = "20. Mocha";
            }
            else if (mouseOver(mx, my, 250, 350, 50, 50)) {
                testString = "21. Everything Falls";
            }
            else if (mouseOver(mx, my, 350, 350, 50, 50)) {
                testString = "22. Lovely Forest";
            }
            else if (mouseOver(mx, my, 450, 350, 50, 50)) {
                testString = "23. Magical";
            }

            // else change to zero
            else testString = "0";
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
            g.drawRect(250, 250, 50, 50);
            g.drawRect(350, 250, 50, 50);
            g.drawRect(450, 250, 50, 50);
            g.drawRect(550, 250, 50, 50);
            // forth row
            g.drawRect(50, 350, 50, 50);
            g.drawRect(150, 350, 50, 50);
            g.drawRect(250, 350, 50, 50);
            g.drawRect(350, 350, 50, 50);
            g.drawRect(450, 350, 50, 50);
            g.drawRect(550, 350, 50, 50);
            // fifth row
            g.drawRect(50, 450, 50, 50);
            g.drawRect(150, 450, 50, 50);
            g.drawRect(250, 450, 50, 50);
            g.drawRect(350, 450, 50, 50);
            g.drawRect(450, 450, 50, 50);
            g.drawRect(550, 450, 50, 50);
            // sixth row
            g.drawRect(50, 550, 50, 50);
            g.drawRect(150, 550, 50, 50);
            g.drawRect(250, 550, 50, 50);
            g.drawRect(350, 550, 50, 50);
            g.drawRect(450, 550, 50, 50);
            g.drawRect(550, 550, 50, 50);
        }
        if (game.gameState == game_.STATE.GameBeta) {
            g.drawString("Level ID: " + levelid + ", BPm: " + bpm + ", End (Bar): " + endBar, game.WIDTH - 300, 15);
            g.drawString("BPm: " + (float)(60000/(tpm * 10)) + ", Bar: " + handler.total_bars + ", Beats: " + handler.total_beats + ", Beat: " + handler.fourbarticks, game.WIDTH - 300, 64);
            g.drawString("Difference (Beats): " + difference, game.WIDTH - 300, 80);
            g.drawString("SPm: " + (float)(60000/(spm * 10)) + ", Bar: " + handler.total_bars_steps + ", Steps: " + handler.total_steps + ", Step: " + handler.fourbarsteps, game.WIDTH - 300, 96);
            g.drawString("Difference (Steps): " + stepDifference, game.WIDTH - 300, 112);
            // duration bar
            g.setColor(new Color(75, durationValue, 0));
            g.fillRect(game.WIDTH - 300, 18, (int) durationBar * 2, 32);
            g.setColor(Color.green);
            g.drawRect(game.WIDTH - 300, 18, 200, 32);
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
        scoreKeep = 0;
        scoreKeepStep = 0;
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
        // reset music
        handler.total_bars = 1;
        handler.total_beats = 1;
        handler.fourbarticks = 1;

        handler.total_bars_steps = 1;
        handler.total_steps = 1;
        handler.fourbarsteps = 1;
    }

}
