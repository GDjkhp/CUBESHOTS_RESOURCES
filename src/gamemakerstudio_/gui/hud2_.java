/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.gui;

import gamemakerstudio_.game_;
import gamemakerstudio_.misc.GunManager;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ACER
 */
public class hud2_ {
    public static int heartsTaken = 0;
    public static int bounds = 0;
    public static int HEALTH = 100;
    private int greenValue = 255;

    public static int score = 0;
    public static int level = 1;
    public static int xp = 0;

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
            greenValue = HEALTH * 2;
            greenValue = game_.clamp(greenValue, 0, 255);
            if (HEALTH != 0) {
                if (!game_.isInvincible && game_.gameState != game_.STATE.Edit && game_.gameState != game_.STATE.End) {
                    score++;
                    xp++;
                }
            }
            delta--;
        }
    }
    public void render(Graphics g) {
        // player hud
        // health bar
        g.setColor(Color.gray);
        g.fillRect(15, 103, 200 + bounds, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 103, HEALTH * 2, 32);
        // boarder
        g.setColor(Color.green);
        g.drawRect(15, 103, 200 + bounds, 32);
        // level and score and health
//        g.drawString("Level: " + level, 450, 64);
        g.drawString("Score: " + score, 15, 149);
        g.drawString("Experience: " + xp, 15, 165);
        g.drawString("Health: " + (HEALTH) + "/" + (100 + (bounds / 2)) + ", Hearts: " + heartsTaken  + ", " +
                "Gun: " + GunManager.playerTwoGunLoadOut, 15, 100);
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
}
