/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_;

import gamemakerstudio_.entities.*;
import gamemakerstudio_.gui.hud_;

import java.util.Random;

/**
 *
 * @author ACER
 */
public class spawn_ {
    
    private handler_ handler;
    private hud_ hud;
    private game_ game;
    private Random r = new Random();
    
    public static int scoreKeep = 0;
    
    public spawn_(handler_ handler, hud_ hud, game_ game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }
    public void tick() {
        scoreKeep++;
        if (scoreKeep == 100) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            // enemies to be spawned
            // easy
            if (game.diff == 0) {
                handler.addObject(new basicenemy_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.BasicEnemy, handler));
                handler.addObject(new heart_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.HeartFriend, handler));
                handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.BaseCircle, handler));
                handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.Laser, handler));
                if (hud.getLevel() == 10){
                    // remove objects except players
                    handler.removeObjectsExceptPlayers();
                    handler.addObject(new skullface_((game_.WIDTH / 2) - 128, (game_.HEIGHT) - 128, ID.Xgamer, handler));
                }
            }
            // medium
            if (game.diff == 1) {
                handler.addObject(new hardenemy_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.BasicEnemy, handler));
                handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.BaseCircle, handler));
                handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.Laser, handler));
                if (hud.getLevel() % 3 == 0)
                    handler.addObject(new fastenemy_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                        ID.FastEnemy, handler));
                if (hud.getLevel() % 5 == 0)
                    handler.addObject(new smartenemy_(r.nextInt(game_.WIDTH - 50), r.nextInt(game_.HEIGHT - 50),
                            ID.SmartEnemy, handler));

                if (hud.getLevel() == 10) {
                    // remove objects except players
                    handler.removeObjectsExceptPlayers();
                    handler.addObject(new creeperboss_((game_.WIDTH / 2) - 200, -253, ID.CreeperBoss, handler));
                }
            }
            // hardmode
        }
    }
}
