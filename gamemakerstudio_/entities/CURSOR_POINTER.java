package gamemakerstudio_.entities;

import gamemakerstudio_.misc.ID;
import gamemakerstudio_.game_;
import gamemakerstudio_.misc.gameobject_;
import gamemakerstudio_.misc.assets_;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CURSOR_POINTER extends gameobject_ implements MouseMotionListener {
    game_ game;
    int dispX, dispY;
    public CURSOR_POINTER(float x, float y, ID id, game_ game) {
        super(x, y, id);
        this.game = game;
        game.addMouseMotionListener(this);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(assets_.targetimage, (int)x, (int)y, null);
        g.setColor(Color.CYAN);
        g.drawString("x = " + dispX, (int)x + 35, (int)y + 35);
        g.drawString("y = " + dispY, (int)x + 35, (int)y + 50);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        x = mx - 15;
        y = my - 15;
        dispX = mx;
        dispY = my;
    }
}
