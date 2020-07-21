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
public class creeperboss_ extends gameobject_ {
    
    private handler_ handler;
    private int timer = 50;
    private int timer2 = 200;
    Random r = new Random();
    
    public creeperboss_ (int x, int y, ID id, handler_ handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 0;
        velY = 5;
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 400, 400);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        if (timer == 0) velY = 0;
        else timer--;
        
        if (timer2 == 0) {
            if (velX == 0) velX = 20;
            int spawn = r.nextInt(5);
            if (spawn == 0) handler.addObject(new tnt_ ((int) x + 200, (int) y + 200, ID.BasicEnemy, handler));
        } else timer2--;
        
        // screen limit
        if (x <= 0 || x >= game_.WIDTH - 400) velX *= -1;
//        if (y <= 0 || y >= game_.HEIGHT - 50) velY *= -1;
        // trail
//        handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.green, 400, 400, 0.1f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) x, (int) y, 400, 400);
        g.setColor(Color.black);
        g.fillRect((int) x + 50, (int) y + 50, 100, 100);
        g.fillRect((int) x + 250, (int) y + 50, 100, 100);
        g.fillRect((int) x + 150, (int) y + 150, 100, 100);
        g.fillRect((int) x + 150, (int) y + 200, 100, 100);
        g.fillRect((int) x + 100, (int) y + 200, 50, 150);
        g.fillRect((int) x + 250, (int) y + 200, 50, 150);
        
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
