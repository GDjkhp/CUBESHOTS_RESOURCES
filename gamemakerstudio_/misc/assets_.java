package gamemakerstudio_.misc;

import gamemakerstudio_.game_;

import java.awt.*;
import java.awt.image.BufferedImage;

public class assets_ {

    public static BufferedImage tile1, tile2, tile3, xgamer, heartimage, soundiconon, soundiconoff, crazyboss;
    public static Image upscaledxgamer, upscaledcrazyboss;

    public static void init() {
        SpriteSheet ss = new SpriteSheet(game_.spritesheet);

        tile1 = ss.grabImage(1, 4, 32, 32);
        tile2 = ss.grabImage(2, 4, 32, 32);
        tile3 = ss.grabImage(3,4,32,32);
        heartimage = ss.grabImage(1, 1, 16, 16);
        soundiconon = ss.grabImage(2, 1, 32, 32);
        soundiconoff = ss.grabImage(3, 1, 32, 32);

        // test for upscale
        xgamer = ss.grabImage(2, 2, 32, 32);
        upscaledxgamer = xgamer.getScaledInstance(256, 256,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        crazyboss = ss.grabImage(1, 2, 32, 32);
        upscaledcrazyboss = crazyboss.getScaledInstance(256, 256, Image.SCALE_SMOOTH);
    }

}
