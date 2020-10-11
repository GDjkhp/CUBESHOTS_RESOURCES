package gamemakerstudio_.entities.boss;

import gamemakerstudio_.entities.laserpointer_;
import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.assets_;
import gamemakerstudio_.misc.gameobject_;
import gamemakerstudio_.misc.handler_;

import java.awt.*;
import java.util.Random;

public class skullface_ extends gameobject_ {
    handler_ handler;
    private int timer = 100;
    private int timer2 = 200;
    Random r = new Random();

    public skullface_(float x, float y, ID id, handler_ handler) {
        super(x, y, id);
        this.handler = handler;
        this.width = 256;
        this.height = 256;
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

            handler.addObject(new laserpointer_((int) x + 169, (int) y + 93, ID.Laser, handler, 30, 30, 0));
            handler.addObject(new laserpointer_((int) x + 57, (int) y + 101, ID.Laser, handler, 30, 30, 0));
        } else timer2--;
    }

    public void render(Graphics g) {
        g.drawImage(assets_.upscaledxgamer, (int) x, (int) y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle ((int) x, (int) y, width, height);
    }


}
