package gamemakerstudio_.entities;

import gamemakerstudio_.*;
import gamemakerstudio_.gui.hud2_;
import gamemakerstudio_.gui.hud_;
import gamemakerstudio_.world.levels_;

import java.awt.*;

public class laserpointer_ extends gameobject_ {
    handler_ handler;
    private gameobject_ player;
    float pathX, pathY, diffX, diffY, distance;
    private int spawntimer = 50;

    public laserpointer_ (float x, float y, ID id, handler_ handler) {
        super(x, y, id);
        this.handler = handler;
        // AI
        for (int i = 0; i < handler.object.size(); i++) {
            if (game_.multiplayer) {
                if (hud_.HEALTH < hud2_.HEALTH) {
                    if (hud_.HEALTH != 0) {
                        if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
                    } else if (handler.object.get(i).getId() == ID.Player2) player = handler.object.get(i);
                } else if (hud2_.HEALTH < hud_.HEALTH) {
                    if (hud2_.HEALTH != 0) {
                        if (handler.object.get(i).getId() == ID.Player2) player = handler.object.get(i);
                    } else if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
                }
                else if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
                else if (handler.object.get(i).getId() == ID.Player2) player = handler.object.get(i);
            }
            else if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }

        if (game_.gameState == game_.STATE.GameBeta) {

            spawntimer = 1;

        }
    }

    public void tick() {
        if (spawntimer == 0) {

            if (y <= 0 || y >= game_.HEIGHT) handler.removeObject(this);
            // execute AI
            pathX = (float) ((-30.0 / distance) * diffX);
            pathY = (float) ((-30.0 / distance) * diffY);

            velX = pathX;
            velY = pathY;

            x += velX;
            y += velY;

            if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.red, 30, 30, 0.1f, handler));

        } else {
            // perform AI
            diffX = x - player.getX() - 10;
            diffY = y - player.getY() - 10;
            distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
            spawntimer--;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 30, 30);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 30, 30);
    }

    @Override
    public void health() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
