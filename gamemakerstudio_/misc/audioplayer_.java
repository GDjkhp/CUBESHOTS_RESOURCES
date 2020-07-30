/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.misc;

import java.util.HashMap;
import java.util.Map;

import gamemakerstudio_.game_;
import org.newdawn.slick.Sound;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

/**
 *
 * @author ACER
 */
public class audioplayer_ {
    public static String currentMusic = "";
    public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    public static Map<String, Music> musicMap = new HashMap<String, Music>();
    
    public static void load(String key) {
        try {
            // default music
            musicMap.put("null", new Music("resources_/sounds_/null.ogg"));
            musicMap.put("music", new Music("resources_/music_/97945.ogg"));
            musicMap.put("shop_music", new Music("resources_/music_/reminds me of elevators.ogg"));
            // default sound
            soundMap.put("null", new Sound("resources_/sounds_/null.ogg"));
            soundMap.put("click_sound", new Sound("resources_/sounds_/Gun-Reload-Sound-Effect.ogg"));
            soundMap.put("tick", new Sound("resources_/sounds_/tick.ogg"));
            soundMap.put("first_tick", new Sound("resources_/sounds_/tickstart.ogg"));
            // new code for custom music
            switch (key) {
                case "dead_meme":
                    musicMap.put(key, new Music("resources_/music_/dead meme.ogg"));
                    break;
                case "dead_meme_2":
                    musicMap.put(key, new Music("resources_/music_/dead meme 2.ogg"));
                    break;
                case "eschew":
                    musicMap.put(key, new Music("resources_/music_/eschew.ogg"));
                    break;
                case "rock_the_house":
                    musicMap.put(key, new Music("resources_/music_/rock the house.ogg"));
                    break;
                case "end_of_time":
                    musicMap.put(key, new Music("resources_/music_/end of time.ogg"));
                    break;
                case "nova_music":
                    musicMap.put(key, new Music("resources_/music_/nova music.ogg"));
                    break;
                case "time_leaper":
                    musicMap.put(key, new Music("resources_/music_/time leaper.ogg"));
                    break;
                case "gg":
                    musicMap.put(key, new Music("resources_/music_/gg.ogg"));
                    break;
                case "namice1":
                    musicMap.put(key, new Music("resources_/music_/namice1.ogg"));
                    break;
                case "namice2":
                    musicMap.put(key, new Music("resources_/music_/namice2.ogg"));
                    break;
                case "namice3":
                    musicMap.put(key, new Music("resources_/music_/namice3.ogg"));
                    break;
                case "there":
                    musicMap.put(key, new Music("resources_/music_/there.ogg"));
                    break;
                case "fisher_price":
                    musicMap.put(key, new Music("resources_/music_/fisher price.ogg"));
                    break;
                case "dance_violins":
                    musicMap.put(key, new Music("resources_/music_/dance violins.ogg"));
                    break;
                    // new
                case "aether":
                    musicMap.put(key, new Music("resources_/music_/aether.ogg"));
                    break;
                case "clickbait":
                    musicMap.put(key, new Music("resources_/music_/clickbait.ogg"));
                    break;
                case "debug":
                    musicMap.put(key, new Music("resources_/music_/debug.ogg"));
                    break;
                case "iy":
                    musicMap.put(key, new Music("resources_/music_/iy.ogg"));
                    break;
                case "ye":
                    musicMap.put(key, new Music("resources_/music_/ye.ogg"));
                    break;
                case "mocha":
                    musicMap.put(key, new Music("resources_/music_/mocha.ogg"));
                    break;
                case "everything_falls":
                    musicMap.put(key, new Music("resources_/music_/everything falls.ogg"));
                    break;
                case "lovely_forest":
                    musicMap.put(key, new Music("resources_/music_/lovely forest.ogg"));
                    break;
                case "saxophone":
                    musicMap.put(key, new Music("resources_/music_/saxophone.ogg"));
                    break;
            }
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
    public static Music getMusic (String key) {
        currentMusic = key;
        // load codes
        if (key != "music" && key != "null") game_.gameState = game_.STATE.Load;
        game_.stringsforloading = "loading music: " + key;
        game_.loadstate -= 25;
        load(key);
        game_.loadstate += 25;
        return musicMap.get(key);
    }
    
    public static Sound getSound (String key) {
        return soundMap.get(key);
    }

}
