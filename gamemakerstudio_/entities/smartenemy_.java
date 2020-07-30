/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.entities;

import gamemakerstudio_.*;
import gamemakerstudio_.gui.hud2_;
import gamemakerstudio_.gui.hud_;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author ACER
 */
public class smartenemy_ extends gameobject_ {
    
    private handler_ handler;
    private gameobject_ player;
    
    public smartenemy_ (int x, int y, ID id, handler_ handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        for (int i = 0; i < handler.object.size(); i++) {
            if (game_.multiplayer) {
                if (hud_.HEALTH < hud2_.HEALTH) {
                    if (hud_.HEALTH != 0) {
                        if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
                    } else if (handler.object.get(i).getId() == ID.Player2) player = handler.object.get(i);
                }
                else if (hud2_.HEALTH < hud_.HEALTH) {
                    if (hud2_.HEALTH != 0) {
                        if (handler.object.get(i).getId() == ID.Player2) player = handler.object.get(i);
                    } else if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
                }
                else if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
                else if (handler.object.get(i).getId() == ID.Player2) player = handler.object.get(i);
            } else if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }
//        velX = 5;
//        velY = 5;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 30);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        float diffX = x - player.getX();
        float diffY = y - player.getY();
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = (float) ((-3.0 / distance) * diffX);
        velY = (float) ((-3.0 / distance) * diffY);
        // screen limit
//        if (x <= 0 || x >= game_.WIDTH - 50) velX *= -1;
//        if (y <= 0 || y >= game_.HEIGHT - 50) velY *= -1;
        // trail
        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.yellow, 30, 30, 0.1f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, 30, 30);
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
