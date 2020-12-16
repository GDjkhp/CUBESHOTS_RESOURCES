package gamemakerstudio_.misc;

import gamemakerstudio_.entities.guns.*;

public class GunManager {
    // guns
    public enum GUN {
        Default,
        Chlorophyte,
        Electrocute,
        Ricochet,
        Whip,
        Rocket,
        Arkhalis
    }

    // player gun load out
    public static GUN playerOneGunLoadOut = GUN.Default;
    public static GUN playerTwoGunLoadOut = GUN.Default;

    public static GUN switchWeapon(GUN current){
        if (current == GUN.Default)
            return GUN.Chlorophyte;
        else if (current == GUN.Chlorophyte)
            return GUN.Electrocute;
        else if (current == GUN.Electrocute)
            return GUN.Ricochet;
        else if (current == GUN.Ricochet)
            return GUN.Rocket;
        else if (current == GUN.Rocket)
            return GUN.Default;
        else return GUN.Default;
    }

    public static void shootCodes(float x, float y, handler_ handler, GUN current){
        // default bullets
        if (current == GunManager.GUN.Default) {
            handler.addObject(new bullet_(x + 10, y + 10, ID.BulletHell,
                    handler, 0, -5));
            handler.addObject(new bullet_(x + 10, y + 10, ID.BulletHell,
                    handler, 5, -5));
            handler.addObject(new bullet_(x + 10, y + 10, ID.BulletHell,
                    handler, -5, -5));
        }
        // chlorophyte bullets
        if (current == GunManager.GUN.Chlorophyte) {
            handler.addObject(new chlorophyte_(x + 10, y + 10, ID.ChlorophyteP1,
                    handler, 0, -15));
            handler.addObject(new chlorophyte_(x + 20, y + 20, ID.ChlorophyteP1,
                    handler, 15, -15));
            handler.addObject(new chlorophyte_(x, y + 20, ID.ChlorophyteP1, handler,
                    -15, -15));
        }
        // electrocute bullets
        if (current == GunManager.GUN.Electrocute) {
            handler.addObject(new electrocutebullet_(x + 10, y + 10, ID.ElectrocuteP1,
                    handler, 0, -15));
        }
        // ricochet
        if (current == GunManager.GUN.Ricochet){
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, 0, -10));
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, 0, 10));
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, 10, 0));
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, -10, 0));
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, 10, -10));
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, -10, -10));
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, 10, 10));
            handler.addObject(new ricochet_(x + 10, y + 10, ID.Ricochet, handler, -10, 10));
        }
        // rocket
        if (current == GUN.Rocket)
            handler.addObject(new rocket_(x, y, ID.Rocket, handler, 0, -3));
    }
}
