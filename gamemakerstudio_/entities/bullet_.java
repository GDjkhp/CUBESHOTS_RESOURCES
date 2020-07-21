package gamemakerstudio_.entities;

import gamemakerstudio_.ID;
import gamemakerstudio_.gameobject_;
import gamemakerstudio_.handler_;
import org.lwjgl.Sys;

import java.awt.*;

public class bullet_ extends gameobject_ {

    handler_ handler;
    int range = 50;

    public bullet_(float x, float y, ID id, handler_ handler, int velX, int velY) {
        super(x, y, id);
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;
    }

    public void tick() {
        if (range != 0) {
            x += velX;
            y += velY;
            range--;
        } else handler.removeObject(this);
        collision();
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval((int) x, (int) y, 10, 10);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 10, 10);
    }
    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            gameobject_ tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.BasicEnemy) {
                if(getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    handler.removeObject(this);
                }
            }
        }
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
