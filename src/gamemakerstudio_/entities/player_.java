/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.entities;

import gamemakerstudio_.*;
import gamemakerstudio_.entities.guns.bullet_;
import gamemakerstudio_.entities.guns.chlorophyte_;
import gamemakerstudio_.entities.guns.electrocutebullet_;
import gamemakerstudio_.entities.guns.ricochet_;
import gamemakerstudio_.gui.hud_;
import gamemakerstudio_.misc.*;

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
    hud_ hud;

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
    // dash
    public static int dashcooldown = 15;
    private int delay = 5;

    // dumb ai
    boolean searchHearts = true;
    gameobject_ heart;

    public player_(int x, int y, ID id, handler_ handler, hud_ hud) {
        super(x, y, id);
        this.handler = handler;
        this.width = 30;
        this.height = 30;
        this.hud = hud;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }
    
    public void tick() {
        // dumb ai
        if (game_.computerP1){
            if (heart != null){
                if (getBounds().intersects(heart.getBounds())){
                    heart = null;
                    searchHearts = true;
                }
            }
            if (searchHearts){
                if (heart == null) heart = handler.getObject(ID.HeartFriend);
                if (heart != null) searchHearts = false;
            }
            if (heart != null) {
                float diffX = x - heart.getX();
                float diffY = y - heart.getY();
                float distance = (float) Math.sqrt((x - heart.getX()) * (x - heart.getX()) + (y - heart.getY()) * (y - heart.getY()));
                float pathX = (float) ((-handler.spdp1 / distance) * diffX);
                float pathY = (float) ((-handler.spdp1 / distance) * diffY);
                x += pathX;
                y += pathY;
                if (!game_.isInvincible &&
                        (game_.gameState == game_.STATE.Game || game_.gameState == game_.STATE.GameBeta)) collision();
            }
        }
        if (isShooting) {
            if (cooldownp1 == 0) {
                cooldownp1 = defaultcooldown;
                GunManager.shootCodes(x, y, handler, GunManager.playerOneGunLoadOut);
            } else cooldownp1--;
        }

        if (isDashing && dashcooldown != 0) {
            x += (velX * 3);
            y += (velY * 3);
            dashcooldown--;
        }

        else if (!game_.computerP1){
            isDashing = false;
            x += velX;
            y += velY;
            if (!game_.isInvincible &&
                    (game_.gameState == game_.STATE.Game || game_.gameState == game_.STATE.GameBeta)) collision();
        }
        
        if (hud_.HEALTH == 0) {
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
        
        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.CYAN, width, height, 0.1f, handler));
//        handler.addObject(new trailparticle_((int) x, (int) y, ID.Trail, handler, Color.CYAN, 0.05f, width, height));
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
                        hud.HEALTH -= 2;
                        if (hud.HEALTH == 0)
                            if (game_.music) audioplayer_.getSound("death").play();
                    }
            }
            /*if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.CreeperBoss || tempObject.getId() == ID.Xgamer) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hud_.HEALTH -= 2;
                }
            }*/
            if(tempObject.getId() == ID.HeartFriend) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hud.HEALTH += 10;
                    hud_.heartsTaken++;
                    heart = handler.removeObject(tempObject);
                    searchHearts = true;
//                    hud.xp++;
                }
            }
        }
    }
    
    public void render(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        if (id == ID.Player)
            g.setColor(Color.cyan);
        g.fillRect((int) x, (int) y, width, height);
    }
}
