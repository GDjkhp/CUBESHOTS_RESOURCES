package gamemakerstudio_.entities;

import gamemakerstudio_.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.gameobject_;

import java.awt.*;

public class ghost_ extends gameobject_ {
    public static boolean isControlled = false;
    public ghost_ (int x, int y, ID id) {
        super(x, y, id);
        velX = 1;
        velY = 1;
    }
    public void tick() {
        if (!isControlled) {
            x += velX;
            y += velY;
        }

        // screen limit
        if (x <= 0 || x >= game_.WIDTH - 50) velX *= -1;
        if (y <= 0 || y >= game_.HEIGHT - 50) velY *= -1;
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int) x, (int) y, 30, 30);
    }

    public Rectangle getBounds() {
        return null;
    }

    public void health() {

    }

}
