package gamemakerstudio_.entities;

import gamemakerstudio_.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.gameobject_;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ghost_ extends gameobject_ {
    public static boolean isControlled = false;
    int rotateTick = 0;
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

        if (rotateTick == 360) rotateTick = 0;
        rotateTick++;

        // screen limit
        if (x <= 0 || x >= game_.WIDTH - 50) velX *= -1;
        if (y <= 0 || y >= game_.HEIGHT - 50) velY *= -1;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();
        if (isControlled) g2d.rotate(Math.toDegrees(rotateTick), x + 15, y + 15);
        g.setColor(Color.RED);
        g.drawRect((int) x, (int) y, 30, 30);
        g2d.setTransform(old);
    }

    public Rectangle getBounds() {
        return null;
    }

    public void health() {

    }

}
