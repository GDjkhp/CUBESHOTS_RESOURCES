/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_;

import gamemakerstudio_.entities.player2_;
import gamemakerstudio_.entities.player_;
import gamemakerstudio_.misc.audioplayer_;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author ACER
 */
public class handler_ {
    public static LinkedList <gameobject_> object = new LinkedList <gameobject_>();

    public int total_bars = 1;
    public int total_beats = 1;
    public int fourbarticks = 1;
    
    public static int spdp1 = 5;
    public static int spdp2 = 5;
    
    public void tick() {
        for (int i = 0; i < object.size(); i++/*int i = object.size() - 1; i >= 0; i--*/) {
            gameobject_ tempObject = object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++/*int i = object.size() - 1; i >= 0; i--*/) {
            gameobject_ tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    public void clearEnemies() {
        for (int i = object.size() - 1; i >= 0; i--) {
            gameobject_ tempObject = object.get(i);
            if (tempObject.getId() != ID.Trail)
                removeObject(tempObject);
        }
        addObject(new player_(50, 200, ID.Player, this));
        if (game_.multiplayer) addObject(new player2_(game_.WIDTH - 128, 200, ID.Player2, this));
    }
    public void removeObjectsExceptPlayers() {
        // remove objects except players
        for (int i = object.size() - 1; i >= 0; i--) {
            gameobject_ tempObject = object.get(i);
            if (tempObject.getId() != ID.Player) {
                if (tempObject.getId() != ID.Player2) {
                    if (tempObject.getId() != ID.HeartFriend) {
                        if (tempObject.getId() != ID.Trail) {
                            if (tempObject.getId() != ID.BulletHell) {
                                    removeObject(tempObject);
                            }
                        }
                    }
                }
            }
        }
    }
    public void metronomeCode () {
        // metronome codes
        fourbarticks++;
        total_beats++;
        if (fourbarticks == 1) {
            total_bars++;
            if (game_.music) audioplayer_.getSound("first_tick").play();
        } else if (game_.music) audioplayer_.getSound("tick").play();
        if (fourbarticks == 4) fourbarticks = 0;
    }
    public void addObject(gameobject_ object) {
        this.object.add(object);
    }
    public void removeObject(gameobject_ object) {
        this.object.remove(object);
    }
}
