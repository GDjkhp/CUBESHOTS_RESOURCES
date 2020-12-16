/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.gui;

import gamemakerstudio_.game_;
import gamemakerstudio_.misc.GunManager;
import gamemakerstudio_.misc.handler_;
import gamemakerstudio_.misc.audioplayer_;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ACER
 */
public class hud_ {
    handler_ handler;
    public static int heartsTaken = 0;
    public static int bounds = 0;
    public static int HEALTH = 100;
    private int blueValue = 255;

    public static int score = 0;
    public static int level = 1;
    public static int xp = 0;

    public int milliseconds = 0;
    public int seconds = 0;
    public int minutes = 0;

    // vars for gameloop fix
    public long lastTime = System.nanoTime();
    double amountOfTicks = 100.0;
    double ns = 1000000000 / amountOfTicks;
    public double delta = 0;

    public void tick() {
        // gameloop
        long now = System.nanoTime();
        delta += (now - lastTime) / ns;
        lastTime = now;
        while (delta >= 1) {
            HEALTH = game_.clamp(HEALTH, 0, 100 + (bounds / 2));
            blueValue = HEALTH * 2;
            blueValue = game_.clamp(blueValue, 0, 255);
            if (HEALTH != 0) {
                if (!game_.isInvincible && game_.gameState != game_.STATE.Edit && game_.gameState != game_.STATE.End) {
                    score++;
                    xp++;
                }
            }
            // crappy watch
            if (game_.gameState == game_.STATE.GameBeta || game_.gameState == game_.STATE.Game) {
                milliseconds++;
                if (milliseconds == 100) {
                    milliseconds = 0;
                    seconds++;
                }
                if (seconds == 60) {
                    milliseconds = 0;
                    seconds = 0;
                    minutes++;
                }
            }
            delta--;
        }
    }
    public void render(Graphics g) {
        // player hud
        // health bar
        g.setColor(Color.gray);
        g.fillRect(15, 18, 200 + bounds, 32);
        g.setColor(new Color(75, 0, blueValue));
        g.fillRect(15, 18, HEALTH * 2, 32);
        // boarder
        g.setColor(Color.CYAN);
        g.drawRect(15, 18, 200 + bounds, 32);
        // level and score and health and xp
        g.drawString("Score: " + score, 15, 64);
        g.drawString("Experience: " + xp, 15, 80);
        g.drawString("Health: " + (HEALTH) + "/" + (100 + (bounds / 2)) + ", Hearts: " + heartsTaken + ", " +
                "Gun: " + GunManager.playerOneGunLoadOut, 15, 15);
        g.setColor(Color.WHITE);
        if (game_.gameState == game_.STATE.Game) g.drawString("Level: " + level, 15, game_.HEIGHT - 50);
        else g.drawString("Level: " + audioplayer_.currentMusic, 15, game_.HEIGHT - 50);
        // fps
        g.setColor(Color.green);
//        g.drawString("string", game_.WIDTH - 75, game_.HEIGHT - 100);
        g.drawString("FPS/TPS: " + game_.throwframes + "/" + game_.throwTick, game_.WIDTH - 125, game_.HEIGHT - 75);
        g.drawString("Objects: " + handler.object.size(), game_.WIDTH - 100, game_.HEIGHT - 50);
        // render crappy watch
        g.drawString(tellTime(), game_.WIDTH / 2 - 50, game_.HEIGHT - 100);
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getXp() {
        return xp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void resetTimer(){
        milliseconds = 0;
        seconds = 0;
        minutes = 0;
    }
    public String tellTime() {
        String tempMilli, tempSec, tempMin, rawTime;
        if (milliseconds / 10 == 0) tempMilli = "0" + milliseconds;
        else tempMilli = String.valueOf(milliseconds);
        if (seconds / 10 == 0) tempSec = "0" + seconds;
        else tempSec = String.valueOf(seconds);
        if (minutes / 10 == 0) tempMin = "0" + minutes;
        else tempMin = String.valueOf(minutes);
        return rawTime = tempMin + ":" + tempSec + ":" + tempMilli;
    }
    public hud_ (handler_ handler) {
        this.handler = handler;
    }
}
