/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.entities;

import gamemakerstudio_.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.gameobject_;
import gamemakerstudio_.handler_;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class tnt_ extends gameobject_ {
    
    private handler_ handler;
    Random r = new Random();
    
    public tnt_ (int x, int y, ID id, handler_ handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 10, 10);
    }
    
    public void tick() {
        x += velX;
        y += velY;

        // screen limit
//        if (x <= 0 || x >= game_.WIDTH - 50) velX *= -1;
//        if (y <= 0 || y >= game_.HEIGHT - 50) velY *= -1;

        if (y <= 0 || y >= game_.HEIGHT) handler.removeObject(this);
        // trail
        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.red, 10, 10, 0.1f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 10, 10);
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
