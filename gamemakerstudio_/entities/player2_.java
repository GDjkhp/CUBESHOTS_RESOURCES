/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.entities;

import gamemakerstudio_.*;
import gamemakerstudio_.gui.hud2_;
import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.gameobject_;
import gamemakerstudio_.misc.handler_;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class player2_ extends gameobject_ {
    
    Random r = new Random();
    handler_ handler;
    hud2_ hud2;

    // north
    private static int northVelY = -5;
    // east
    private static int eastVelX = 5;
    // west
    private static int westVelX = -5;

    //shoot
    public static int cooldownp2 = 0;
    public static int defaultcooldown = 15;
    //dash
    public static int dashcooldown = 15;
    private int delay = 5;

    public static boolean isShooting = false;
    public static boolean isDashing = false;

    public player2_(int x, int y, ID id, handler_ handler, hud2_ hud2) {
        super(x, y, id);
        this.handler = handler;
        this.width = 30;
        this.height = 30;
        this.hud2 = hud2;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }
    
    public void tick() {

        if (isShooting) {
            if (cooldownp2 == 0) {
                cooldownp2 = defaultcooldown;

                // default bullets
                if (game_.playerTwoGunLoadOut == game_.GUN.Default) {
                    handler.addObject(new bullet_(this.getX() + 10, this.getY() + 10, ID.BulletHell,
                            handler, 0, northVelY));
                    handler.addObject(new bullet_(this.getX() + 10, this.getY() + 10, ID.BulletHell,
                            handler, eastVelX, northVelY));
                    handler.addObject(new bullet_(this.getX() + 10, this.getY() + 10, ID.BulletHell,
                            handler, westVelX, northVelY));
                }
                // chlorophyte bullets
                if (game_.playerTwoGunLoadOut == game_.GUN.Chlorophyte) {
                    handler.addObject(new chlorophyte_(this.getX() + 10, this.getY() + 10, ID.ChlorophyteP2, handler, 0, -15));
                    handler.addObject(new chlorophyte_(this.getX() + 20, this.getY() + 20, ID.ChlorophyteP2, handler, 15, -15));
                    handler.addObject(new chlorophyte_(this.getX(), this.getY() + 20, ID.ChlorophyteP2, handler, -15, -15));
                }
                // electrocute bullets
                if (game_.playerTwoGunLoadOut == game_.GUN.Electrocute) {
                    handler.addObject(new electrocutebullet_(this.getX() + 10, this.getY() + 10, ID.ElectrocuteP2, handler, 0, -15));
                }
            } else cooldownp2--;
        }

        if (isDashing && dashcooldown != 0) {
            x += (velX * 3);
            y += (velY * 3);
            dashcooldown--;
        }
        else {
            isDashing = false;
            x += velX;
            y += velY;
            if (!game_.isInvincible &&
                    (game_.gameState == game_.STATE.Game || game_.gameState == game_.STATE.GameBeta)) collision();
        }
        
        if (hud2_.HEALTH == 0) {
            x = 1000;
            y = 1000;
        }
        else {
            // clamp
            x = game_.clamp((int) x, 0, game_.WIDTH - 30);
            y = game_.clamp((int) y, 0, game_.HEIGHT - 30);

            // snake portal
            /*if (x <= 0) x = game_.WIDTH - 30;
            else if (x >= game_.WIDTH - 30) x = 0;
            else if (y <= 0) y = game_.HEIGHT - 30;
            else if (y >= game_.HEIGHT - 30) y = 0;*/
        }
        
        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.GREEN, width, height, 0.1f, handler));
    }
    
    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            gameobject_ tempObject = handler.object.get(i);
            switch (tempObject.getId()) {
                case BasicEnemy:
                case FastEnemy:
                case SmartEnemy:
                case HardEnemy:
                case BaseCircle:
                case Laser:
                case Star:
                case TNT:
                case CircleWithPatterns:
                    if(getBounds().intersects(tempObject.getBounds())) {
                        hud2.HEALTH -= 2;
                    }
            }
            /*if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.CreeperBoss) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hud2_.HEALTH -= 2;
                }
            }*/
            if(tempObject.getId() == ID.HeartFriend) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hud2.HEALTH += 10;
                    hud2.heartsTaken++;
                    handler.removeObject(tempObject);
                }
            }
        }
    }
    
    public void render(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        if (id == ID.Player2)
            g.setColor(Color.green);
        g.fillRect((int) x, (int) y, width, height);
    }


}
