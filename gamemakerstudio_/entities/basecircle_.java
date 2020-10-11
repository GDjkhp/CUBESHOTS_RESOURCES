package gamemakerstudio_.entities;

import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.gameobject_;
import gamemakerstudio_.misc.handler_;

import java.awt.*;

public class basecircle_ extends gameobject_ {

    private handler_ handler;
    public static int patternVel = 5;
    // north
    private static int northVelY = -patternVel;
    // south
    private static int southVelY = patternVel;
    // east
    private static int eastVelX = patternVel;
    // west
    private static int westVelX = -patternVel;

    public basecircle_(float x, float y, ID id, handler_ handler, float velX, float velY, int spawnTimer) {
        super(x, y, id);
        this.width = 30;
        this.height = 30;
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;
        this.spawnTimer = spawnTimer;
    }

    public void tick() {
        if (spawnTimer == 0) {
            if (this.id == ID.BaseCircle) {
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, 0, northVelY));
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, 0, southVelY));
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, eastVelX, 0));
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, westVelX, 0));
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, eastVelX, northVelY));
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, westVelX, northVelY));
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, eastVelX, southVelY));
                handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.CircleWithPatterns, handler, westVelX, southVelY));
                handler.removeObject(this);
            }
        } else {
            x += velX;
            y += velY;
            if (this.id == ID.BaseCircle) spawnTimer--;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        if (this.id == ID.BaseCircle)
            g.fillOval((int) x, (int) y, width, height);
        if (this.id == ID.BASECIRCLEGHOST)
            g.drawOval((int) x, (int) y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }


}
