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

/**
 *
 * @author ACER
 */
public class circlewithpatterns_ extends gameobject_ {

    private handler_ handler;
    public static boolean dvd = false;


    public circlewithpatterns_ (int x, int y, ID id, handler_ handler, int velX, int velY) {
        super(x, y, id);

        this.handler = handler;
        this.velX = velX;
        this.velY = velY;


    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 10, 10);
    }

    public void tick() {
        x += velX;
        y += velY;
        // screen limit
        if (dvd) {
            if (x <= 0 || x >= game_.WIDTH - 50) velX *= -1;
            if (y <= 0 || y >= game_.HEIGHT - 50) velY *= -1;
        }
        else {
            if (x <= 0 || x >= game_.WIDTH) handler.removeObject(this);
            if (y <= 0 || y >= game_.HEIGHT) handler.removeObject(this);
        }
        // trail
        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.magenta, 10, 10, 0.1f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval((int) x, (int) y, 10, 10);
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
