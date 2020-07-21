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
                    musicMap.put("dead_meme", new Music("resources_/music_/dead meme.ogg"));
                    break;
                case "dead_meme_2":
                    musicMap.put("dead_meme_2", new Music("resources_/music_/dead meme 2.ogg"));
                    break;
                case "eschew":
                    musicMap.put("eschew", new Music("resources_/music_/eschew.ogg"));
                    break;
                case "rock_the_house":
                    musicMap.put("rock_the_house", new Music("resources_/music_/rock the house.ogg"));
                    break;
                case "end_of_time":
                    musicMap.put("end_of_time", new Music("resources_/music_/end of time.ogg"));
                    break;
                case "nova_music":
                    musicMap.put("nova_music", new Music("resources_/music_/nova music.ogg"));
                    break;
                case "time_leaper":
                    musicMap.put("time_leaper", new Music("resources_/music_/time leaper.ogg"));
                    break;
                case "gg":
                    musicMap.put("gg", new Music("resources_/music_/gg.ogg"));
                    break;
                case "namice1":
                    musicMap.put("namice1", new Music("resources_/music_/namice1.ogg"));
                    break;
                case "namice2":
                    musicMap.put("namice2", new Music("resources_/music_/namice2.ogg"));
                    break;
                case "namice3":
                    musicMap.put("namice3", new Music("resources_/music_/namice3.ogg"));
                    break;
                case "there":
                    musicMap.put("there", new Music("resources_/music_/there.ogg"));
                    break;
                case "fisher_price":
                    musicMap.put("fisher_price", new Music("resources_/music_/fisher price.ogg"));
                    break;
                case "dance_violins":
                    musicMap.put("dance_violins", new Music("resources_/music_/dance violins.ogg"));
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
