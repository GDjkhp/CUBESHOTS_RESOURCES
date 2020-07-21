/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.entities;

import gamemakerstudio_.*;
import gamemakerstudio_.misc.assets_;

import java.awt.*;

/**
 *
 * @author ACER
 */
public class heart_ extends gameobject_ {
    
    private handler_ handler;
    
    public heart_ (int x, int y, ID id, handler_ handler) {
        super((x / 16) * 16, (y / 16) * 16, id);
        
        this.handler = handler;

    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
    
    public void tick() {
//        x += velX;
//        y += velY;
        // screen limit
        if (x <= 0 || x >= game_.WIDTH - 50) velX *= -1;
        if (y <= 0 || y >= game_.HEIGHT - 50) velY *= -1;
        // trail
//        handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.red, 10, 10, 0.1f, handler));
        collision();
        if (game_.isInvincible) handler.removeObject(this);
    }

    public void render(Graphics g) {
        if (!game_.isInvincible)
            g.drawImage(assets_.heartimage, (int) x, (int) y, null);
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            gameobject_ tempObject = handler.object.get(i);
            switch (tempObject.getId()) {
                case CreeperBoss:
                case Xgamer:
                    if(getBounds().intersects(tempObject.getBounds())) {
                        handler.removeObject(this);
                    }
            }
            /*if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.CreeperBoss || tempObject.getId() == ID.Xgamer) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    hud_.HEALTH -= 2;
                }
            }*/
        }
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
