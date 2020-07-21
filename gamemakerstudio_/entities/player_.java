/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.entities;

import gamemakerstudio_.*;
import gamemakerstudio_.gui.hud_;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class player_ extends gameobject_ {
    
    Random r = new Random();
    handler_ handler;

    public static boolean isShooting = false;
    public static boolean isDashing = false;


    // north
    private static int northVelY = -5;
    // east
    private static int eastVelX = 5;
    // west
    private static int westVelX = -5;


    // shoot
    public static int cooldownp1 = 0;
    public static int defaultcooldown = 15;
    //dash
    public static int dashcooldown = 15;
    private int delay = 5;

    public player_(int x, int y, ID id, handler_ handler) {
        super(x, y, id);
        this.handler = handler;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 30);
    }
    
    public void tick() {

        if (isShooting) {
            if (cooldownp1 == 0) {
                cooldownp1 = defaultcooldown;
                handler.addObject(new bullet_(this.getX() + 10, this.getY() + 10, ID.BulletHell,
                        handler, 0, northVelY));
                handler.addObject(new bullet_(this.getX() + 10, this.getY() + 10, ID.BulletHell,
                        handler, eastVelX, northVelY));
                handler.addObject(new bullet_(this.getX() + 10, this.getY() + 10, ID.BulletHell,
                        handler, westVelX, northVelY));
            } else cooldownp1--;
        }

        if (isDashing && dashcooldown != 0) {
            x += (velX * 3);
            y += (velY * 3);
            dashcooldown--;
        }
        else {
            x += velX;
            y += velY;
            if (!game_.isInvincible) collision();
            isDashing = false;
        }
        
        if (hud_.HEALTH == 0) {
            x = 1000;
            y = 1000;
        }
        else {
            x = game_.clamp((int) x, 0, game_.WIDTH - 50);
            y = game_.clamp((int) y, 0, game_.HEIGHT - 80);
        }
        
        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.CYAN, 30, 30, 0.1f, handler));

    }
    
    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            gameobject_ tempObject = handler.object.get(i);
            switch (tempObject.getId()) {
                case BasicEnemy:
                case Laser:
                case FastEnemy:
                case SmartEnemy:
                case CreeperBoss:
                case BaseCircle:
                case Xgamer:
                case HardEnemy:
                    if(getBounds().intersects(tempObject.getBounds())) {
                        hud_.HEALTH -= 2;
                    }
            }
            /*if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.CreeperBoss || tempObject.getId() == ID.Xgamer) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hud_.HEALTH -= 2;
                }
            }*/
            if(tempObject.getId() == ID.HeartFriend) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hud_.HEALTH += 10;
                    handler.removeObject(tempObject);
                }
            }
        }
    }
    
    public void render(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        if (id == ID.Player)
            g.setColor(Color.cyan);
        g.fillRect((int) x, (int) y, 30, 30);
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
