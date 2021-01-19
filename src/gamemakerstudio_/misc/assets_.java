package gamemakerstudio_.misc;

import gamemakerstudio_.game_;

import java.awt.*;
import java.awt.image.BufferedImage;

public class assets_ {

    public static BufferedImage tile1, tile2, tile3, xgamer, heartimage,
            soundiconon, soundiconoff, crazyboss, targetimage, explode, 
            portalBlue1, portalBlue2, portalBlue3, portalBlue4,
            portalRed1, portalRed2, portalRed3, portalRed4;
    public static Image upscaledxgamer, upscaledcrazyboss, locktargetimage, maxExplode,
            maxBlue1, maxBlue2, maxBlue3, maxBlue4,
            maxRed1, maxRed2, maxRed3, maxRed4;

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
        crazyboss = ss.grabImage(1, 2, 32, 32);
        targetimage = ss.grabImage(4, 2, 32, 32);
        explode = ss.grabImage(5, 5, 128, 128);
        
        portalBlue1 = ss.grabImage(9, 1, 64, 64);
        portalBlue2 = ss.grabImage(11, 1, 64, 64);
        portalBlue3 = ss.grabImage(13, 1, 64, 64);
        portalBlue4 = ss.grabImage(15, 1, 64, 64);
        portalRed1 = ss.grabImage(9, 3, 64, 64);
        portalRed2 = ss.grabImage(11, 3, 64, 64);
        portalRed3 = ss.grabImage(13, 3, 64, 64);
        portalRed4 = ss.grabImage(15, 3, 64, 64);

        upscaledxgamer = upscale(xgamer, 256, 256);
        upscaledcrazyboss = upscale(crazyboss, 256, 256);
        locktargetimage = upscale(targetimage, 30, 30);
        maxExplode = upscale(explode, 512, 512);
        
        maxBlue1 = upscale(portalBlue1, 128, 128);
        maxBlue2 = upscale(portalBlue2, 128, 128);
        maxBlue3 = upscale(portalBlue3, 128, 128);
        maxBlue4 = upscale(portalBlue4, 128, 128);
        maxRed1 = upscale(portalRed1, 128, 128);
        maxRed2 = upscale(portalRed2, 128, 128);
        maxRed3 = upscale(portalRed3, 128, 128);
        maxRed4 = upscale(portalRed4, 128, 128);
    }
    public static Image upscale(BufferedImage img, int width, int height){
        return img.getScaledInstance(width, height, Image.SCALE_SMOOTH);  // scale it the smooth way
    }

}
