package gamemakerstudio_.entities;

import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.gameobject_;
import gamemakerstudio_.misc.handler_;

import java.awt.*;

public class RangeArea extends gameobject_ {

    handler_ handler;
    gameobject_ player;
    boolean showBoundingBox = false;

    public RangeArea(float x, float y, ID id, handler_ handler) {
        super(x, y, id);
        this.handler = handler;
        this.width = 450;
        this.height = 450;
        // locate player one
        if (this.id == ID.P1Range) {
            for (int i = 0; i < handler.object.size(); i++) {
                gameobject_ tempObject = handler.object.get(i);
                if (tempObject.getId() == ID.Player) player = tempObject;
            }
        }
        // locate player two
        if (this.id == ID.P2Range) {
            for (int i = 0; i < handler.object.size(); i++) {
                gameobject_ tempObject = handler.object.get(i);
                if (tempObject.getId() == ID.Player2) player = tempObject;
            }
        }
        // locate entity
        if (this.id == ID.EntityRangeP1) {
            for (int i = 0; i < handler.object.size(); i++) {
                gameobject_ tempObject = handler.object.get(i);
                if (tempObject.getId() == ID.ElectrocuteP1) player = tempObject;
            }
        }
        if (this.id == ID.EntityRangeP2) {
            for (int i = 0; i < handler.object.size(); i++) {
                gameobject_ tempObject = handler.object.get(i);
                if (tempObject.getId() == ID.ElectrocuteP2) player = tempObject;
            }
        }
    }

    @Override
    public void tick() {
        x = player.getX() - 210;
        y = player.getY() - 210;
    }

    @Override
    public void render(Graphics g) {
        if (showBoundingBox) {
            if (this.id == ID.EntityRangeP1 || this.id == ID.EntityRangeP2)
                g.setColor(Color.RED);
            if (this.id == ID.P1Range)
                g.setColor(Color.CYAN);
            if (this.id == ID.P2Range)
                g.setColor(Color.GREEN);
            g.drawRect((int) x, (int) y, width, height);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }


}
