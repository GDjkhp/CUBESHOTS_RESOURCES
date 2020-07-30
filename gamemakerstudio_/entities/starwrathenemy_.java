package gamemakerstudio_.entities;

import gamemakerstudio_.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.gameobject_;
import gamemakerstudio_.handler_;

import java.awt.*;
import java.util.Random;

public class starwrathenemy_ extends gameobject_ {

    handler_ handler;

    private int inttick = 60;
    Random r = new Random();

    public starwrathenemy_(float x, float y, ID id, handler_ handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        handler.addObject(new starwrath_(r.nextInt(game_.WIDTH), 0, ID.Star, handler));
    }

    public void render(Graphics g) {

    }

    public Rectangle getBounds() {
        return null;
    }

    public void health() {

    }
}
