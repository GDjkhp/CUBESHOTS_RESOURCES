package gamemakerstudio_;

import gamemakerstudio_.entities.heart_;
import gamemakerstudio_.entities.laserpointer_;

import java.util.Random;

public class synchronizeTest {

    handler_ handler;
    Random r = new Random();
    public static int scoreKeep = 0;

    public synchronizeTest () {

    }

    public void spawnCodeTest () {
        long lastTime = System.nanoTime();
        double amountOfTicks = (60000 / 126)/10;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tickModified();
                delta--;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
            }
        }
    }
    private void tickModified() {
    // spawn code
        handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                ID.HeartFriend, handler));
        handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                ID.Laser, handler));
        handler.metronomeCode();
    }

}
