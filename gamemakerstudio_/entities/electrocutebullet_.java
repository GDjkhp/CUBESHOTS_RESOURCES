package gamemakerstudio_.entities;

import gamemakerstudio_.misc.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.misc.gameobject_;
import gamemakerstudio_.misc.handler_;
import gamemakerstudio_.misc.assets_;

import java.awt.*;
import java.util.Random;

public class electrocutebullet_ extends gameobject_ {

    handler_ handler;
    gameobject_ playerRange, target;
    int bulletRange = 15;
    float diffX, diffY, pathX, pathY, distance, speed;
    Random r = new Random();

    public electrocutebullet_(float x, float y, ID id, handler_ handler, float velX, float velY) {
        super(x, y, id);
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;
        this.width = 10;
        this.height = 10;

        // Init Player Range
        if (this.id == ID.ElectrocuteP1) {
            for (int i = 0; i < handler.object.size(); i++) {
                gameobject_ tempObject = handler.object.get(i);
                switch (tempObject.getId()) {
                    case P1Range:
                        this.playerRange = tempObject;
                        break;
                }
            }
        }
        if (this.id == ID.ElectrocuteP2) {
            for (int i = 0; i < handler.object.size(); i++) {
                gameobject_ tempObject = handler.object.get(i);
                switch (tempObject.getId()) {
                    case P2Range:
                        this.playerRange = tempObject;
                        break;
                }
            }
        }
        if (this.id == ID.ElectrocuteFriend) {
            for (int i = 0; i < handler.object.size(); i++) {
                gameobject_ tempObject = handler.object.get(i);
                switch (tempObject.getId()) {
                    case EntityRangeP1:
                    case EntityRangeP2:
                        this.playerRange = tempObject;
                        break;
                }
            }
        }

        // Init Target
        for (int i = 0; i < handler.object.size() && target == null; i++) {
            int randTarget = r.nextInt(handler.object.size());
            gameobject_ tempObject = handler.object.get(randTarget);
            switch (tempObject.getId()) {
                case BasicEnemy:
                case FastEnemy:
                case SmartEnemy:
                case HardEnemy:
                case BaseCircle:
                case Laser:
                case Star:
                case TNT:
                case CircleWithPatterns:
                    if (tempObject.getBounds().intersects(this.playerRange.getBounds())) {
                        target = tempObject;
                    }
            }
        }

        // stay longer
        if (target != null) bulletRange = 50;
    }

    @Override
    public void tick() {
        if (bulletRange != 0) {
            if (target != null) {
                // multiply this when finished
                if (this.target.getBounds().intersects(this.getBounds())) {
                    if (this.id == ID.ElectrocuteP1) {
                        handler.addObject(new RangeArea(this.getX() - 210, this.getY() - 210, ID.EntityRangeP1, handler));
                        handler.addObject(new electrocutebullet_(this.getX(), this.getY(), ID.ElectrocuteFriend, handler, 0, 0));
                    }
                    if (this.id == ID.ElectrocuteP2) {
                        handler.addObject(new RangeArea(this.getX() - 210, this.getY() - 210, ID.EntityRangeP2, handler));
                        handler.addObject(new electrocutebullet_(this.getX(), this.getY(), ID.ElectrocuteFriend, handler, 0, 0));
                    }
                    // kill the target
                    handler.removeObject(this.target);
                }

                // remove when entity out of bounds
                if (this.id == ID.ElectrocuteFriend) {
                    if (!this.getBounds().intersects(playerRange.getBounds()) || this.target == null) {
                        handler.removeObject(playerRange);
                        handler.removeObject(this);
                    }
                }
                else if (!this.getBounds().intersects(playerRange.getBounds())) {
                    handler.removeObject(this);
                }

                // perform AI
                diffX = x - target.getX();
                diffY = y - target.getY();
                distance = (float) Math.sqrt((x - target.getX()) * (x - target.getX()) + (y - target.getY()) * (y - target.getY()));

                pathX = (float) ((-/*(speed)*/15 / distance) * diffX);
                pathY = (float) ((-/*(speed)*/15 / distance) * diffY);

                x += pathX;
                y += pathY;
            } else {
                x += velX;
                y += velY;
                collision();
            }
            bulletRange--;
        } else {
            if (this.getId() == ID.ElectrocuteFriend)
                handler.removeObject(playerRange);
            handler.removeObject(this);
        }
        if (!game_.ldm) handler.addObject(new trail_((int) x, (int) y, ID.Trail, Color.CYAN, width, height, 0.1f, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int) x, (int) y, width, height);
        if (target != null) g.drawImage(assets_.locktargetimage, (int)target.getX(),
                (int)target.getY(), null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            gameobject_ tempObject = handler.object.get(i);
            switch (tempObject.getId()) {
                case BasicEnemy:
                case FastEnemy:
                case SmartEnemy:
                case HardEnemy:
                case BaseCircle:
                case Laser:
                case Star:
                case TNT:
                case CircleWithPatterns:
                    if (getBounds().intersects(tempObject.getBounds())) {
                        handler.removeObject(tempObject);
                        handler.removeObject(this);
                    }
            }
        }
    }
}
