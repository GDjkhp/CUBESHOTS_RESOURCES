package gamemakerstudio_.entities;

import gamemakerstudio_.*;
import gamemakerstudio_.misc.SpriteSheet;
import gamemakerstudio_.misc.assets_;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class skullface_ extends gameobject_ {
    handler_ handler;
    private int timer = 100;
    private int timer2 = 200;
    Random r = new Random();

    public skullface_(float x, float y, ID id, handler_ handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = -5;
    }

    public void tick() {
        x += velX;
        y += velY;
        if (timer == 0) {
            velY = 0;
        } else timer--;
        if (timer2 == 0) {
            timer2 = 100;

            /*int spawn = r.nextInt(5);
            if (spawn == 0)*/

            handler.addObject(new laserpointer_((int) x + 169, (int) y + 93, ID.Laser, handler));
            handler.addObject(new laserpointer_((int) x + 57, (int) y + 101, ID.Laser, handler));
        } else timer2--;
    }

    public void render(Graphics g) {
        g.drawImage(assets_.upscaledxgamer, (int) x, (int) y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle ((int) x, (int) y, 256, 256);
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
