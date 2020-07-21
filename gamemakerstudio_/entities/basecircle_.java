package gamemakerstudio_.entities;

import gamemakerstudio_.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.gameobject_;
import gamemakerstudio_.handler_;

import java.awt.*;

public class basecircle_ extends gameobject_ {

    private handler_ handler;
    private int spawntimer = 50;
    // north
    private static int northVelY = -5;
    // south
    private static int southVelY = 5;
    // east
    private static int eastVelX = 5;
    // west
    private static int westVelX = -5;

    public basecircle_(float x, float y, ID id, handler_ handler) {
        super(x, y, id);
        this.handler = handler;
        if (game_.gameState == game_.STATE.GameBeta) {
            spawntimer = 0;
        }
    }

    public void tick() {
        if (spawntimer == 0) {
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, 0, northVelY));
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, 0, southVelY));
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, eastVelX, 0));
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, westVelX, 0));
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, eastVelX, northVelY));
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, westVelX, northVelY));
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, eastVelX, southVelY));
            handler.addObject(new circlewithpatterns_((int) x + 10, (int) y + 10, ID.BasicEnemy, handler, westVelX, southVelY));
            handler.removeObject(this);
        } else spawntimer--;
    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillOval((int) x, (int) y, 20, 20);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 20, 20);
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
