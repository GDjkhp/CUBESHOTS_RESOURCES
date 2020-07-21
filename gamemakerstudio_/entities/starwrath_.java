package gamemakerstudio_.entities;

import gamemakerstudio_.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.gameobject_;
import gamemakerstudio_.handler_;

import java.awt.*;
import java.util.Random;

public class starwrath_ extends gameobject_ {
    private handler_ handler;
    private Color col;
    private Random r = new Random();
    private gameobject_ ghost;
    float pathX, pathY, diffX, diffY, distance;
    private int spawntimer = 1;
    public starwrath_(int x, int y, ID id, handler_ handler){
        super(x, y, id);
        this.handler = handler;
        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        // AI
        for (int i = 0; i < handler.object.size(); i++) {
            gameobject_ tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.GHOST) {
                ghost = tempObject;
            }
        }
        // perform AI
        diffX = x - ghost.getX() - 10;
        diffY = y - ghost.getY() - 10;
        distance = (float) Math.sqrt((x - ghost.getX()) * (x - ghost.getX()) + (y - ghost.getY()) * (y - ghost.getY()));
    }
    public void tick() {
        // execute AI
        pathX = (float) ((-30.0 / distance) * diffX);
        pathY = (float) ((-30.0 / distance) * diffY);

        velX = pathX;
        velY = pathY;

        x += velX;
        y += velY;

        if (x <= 0 || x >= game_.WIDTH - 50) {
            handler.removeObject(this);
        }
        if (y <= 0 || y >= game_.HEIGHT - 50) {
            handler.removeObject(this);
        }

        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, col, 30, 30, 0.1f, handler));

    }

    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int) x, (int) y, 30, 30);
    }

    public Rectangle getBounds() {
        return null;
    }

    public void health() {

    }
}
