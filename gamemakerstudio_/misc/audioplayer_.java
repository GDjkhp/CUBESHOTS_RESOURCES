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

import javax.swing.*;

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
                case "lonely_forest":
                    musicMap.put(key, new Music("resources_/music_/lonely forest.ogg"));
                    break;
                case "saxophone":
                    musicMap.put(key, new Music("resources_/music_/saxophone.ogg"));
                    break;
                case "overcharge":
                    musicMap.put(key, new Music("resources_/music_/overcharge.ogg"));
                    break;
                case "flavored_ice":
                    musicMap.put(key, new Music("resources_/music_/flavored ice.ogg"));
                    break;
                case "shape_of_the_sun":
                    musicMap.put(key, new Music("resources_/music_/shape of the sun.ogg"));
                    break;
                case "angels":
                    musicMap.put(key, new Music("resources_/music_/angels.ogg"));
                    break;
                case "perseverance":
                    musicMap.put(key, new Music("resources_/music_/perseverance.ogg"));
                    break;
                case "dynasty":
                    musicMap.put(key, new Music("resources_/music_/dynasty.ogg"));
                    break;
                case "bloom":
                    musicMap.put(key, new Music("resources_/music_/bloom.ogg"));
                    break;
                case "canyon":
                    musicMap.put(key, new Music("resources_/music_/canyon.ogg"));
                    break;
                case "overcloud":
                    musicMap.put(key, new Music("resources_/music_/overcloud.ogg"));
                    break;
                case "ppaper_pplanes":
                    musicMap.put(key, new Music("resources_/music_/ppaper pplanes.ogg"));
                    break;
                case "prelude":
                    musicMap.put(key, new Music("resources_/music_/prelude.ogg"));
                    break;
                case "spirit":
                    musicMap.put(key, new Music("resources_/music_/spirit.ogg"));
                    break;
                case "catalyze":
                    musicMap.put(key, new Music("resources_/music_/catalyze.ogg"));
                    break;
                case "stray":
                    musicMap.put(key, new Music("resources_/music_/stray.ogg"));
                    break;
                case "jazz":
                    musicMap.put(key, new Music("resources_/music_/jazz.ogg"));
                    break;
                    // the time i started to think about my existence
                case "success":
                    musicMap.put(key, new Music("resources_/music_/success.ogg"));
                    break;
                case "supernova":
                    musicMap.put(key, new Music("resources_/music_/supernova.ogg"));
                    break;
                case "time":
                    musicMap.put(key, new Music("resources_/music_/time.ogg"));
                    break;
                case "marbl":
                    musicMap.put(key, new Music("resources_/music_/marbl.ogg"));
                    break;
                case "dreamer":
                    musicMap.put(key, new Music("resources_/music_/dreamer.ogg"));
                    break;
                case "ghost_house":
                    musicMap.put(key, new Music("resources_/music_/ghost house.ogg"));
                    break;
                case "jude":
                    musicMap.put(key, new Music("resources_/music_/jude.ogg"));
                    break;
                case "don't_hold_back":
                    musicMap.put(key, new Music("resources_/music_/don't hold back.ogg"));
                    break;
                case "ouais_ouais":
                    musicMap.put(key, new Music("resources_/music_/ouais ouais.ogg"));
                    break;
                case "things_that_you_do":
                    musicMap.put(key, new Music("resources_/music_/things that you do.ogg"));
                    break;
                case "sad_summer":
                    musicMap.put(key, new Music("resources_/music_/sad summer.ogg"));
                    break;
                case "wishing":
                    musicMap.put(key, new Music("resources_/music_/wishing.ogg"));
                    break;
                case "popo":
                    musicMap.put(key, new Music("resources_/music_/popo.ogg"));
                    break;
                case "ocean_biome":
                    musicMap.put(key, new Music("resources_/music_/ocean biome.ogg"));
                    break;
                case "snowcone":
                    musicMap.put(key, new Music("resources_/music_/snowcone.ogg"));
                    break;
                case "sawdust_angels":
                    musicMap.put(key, new Music("resources_/music_/sawdust angels.ogg"));
                    break;

                case "sky_high":
                    musicMap.put(key, new Music("resources_/music_/sky high.ogg"));
                    break;
                case "my_heart":
                    musicMap.put(key, new Music("resources_/music_/my heart.ogg"));
                    break;
                case "nekozilla":
                    musicMap.put(key, new Music("resources_/music_/nekozilla.ogg"));
                    break;
                case "cloud_9":
                    musicMap.put(key, new Music("resources_/music_/cloud 9.ogg"));
                    break;
                case "sunburst":
                    musicMap.put(key, new Music("resources_/music_/sunburst.ogg"));
                    break;
                case "hellcat":
                    musicMap.put(key, new Music("resources_/music_/hellcat.ogg"));
                    break;
                case "denise":
                    musicMap.put(key, new Music("resources_/music_/denise 102.42.ogg"));
                    break;
                case "dollar_needles_1":
                    musicMap.put(key, new Music("resources_/music_/dollar needles 1.ogg"));
                    break;
                case "dollar_needles_3":
                    musicMap.put(key, new Music("resources_/music_/dollar needles 3.ogg"));
                    break;
                case "behind_these_closed_doors":
                    musicMap.put(key, new Music("resources_/music_/behind these closed doors.ogg"));
                    break;
                case "otis_mcmusic":
                    musicMap.put(key, new Music("resources_/music_/otis mcmusic.ogg"));
                    break;
                case "not_for_nothing":
                    musicMap.put(key, new Music("resources_/music_/not for nothing 86.40.ogg"));
                    break;
                case "mind_control":
                    musicMap.put(key, new Music("resources_/music_/mind control 129.46.ogg"));
                    break;
                case "memories":
                    musicMap.put(key, new Music("resources_/music_/memories.ogg"));
                    break;
                case "2011":
                    musicMap.put(key, new Music("resources_/music_/2011 102.10.ogg"));
                    break;
                case "10000":
                    musicMap.put(key, new Music("resources_/music_/10000.ogg"));
                    break;
                case "merry_christmas":
                    musicMap.put(key, new Music("resources_/music_/merry christmas.ogg"));
                    break;
                case "crab_rave":
                    musicMap.put(key, new Music("resources_/music_/crab rave.ogg"));
                    break;
                case "insurgent":
                    musicMap.put(key, new Music("resources_/music_/insurgent.ogg"));
                    break;
                case "late_night_lo-fi":
                    musicMap.put(key, new Music("resources_/music_/late night lo-fi.ogg"));
                    break;
                case "holystone":
                    musicMap.put(key, new Music("resources_/music_/holystone.ogg"));
                    break;
                case "lith_harbor":
                    musicMap.put(key, new Music("resources_/music_/lith harbor.ogg"));
                    break;
                case "lost_in_thought":
                    musicMap.put(key, new Music("resources_/music_/lost in thought.ogg"));
                    break;
                case "pounce":
                    musicMap.put(key, new Music("resources_/music_/pounce.ogg"));
                    break;
                case "dick":
                    musicMap.put(key, new Music("resources_/music_/dick.ogg"));
                    break;
                case "golden_haze":
                    musicMap.put(key, new Music("resources_/music_/golden haze.ogg"));
                    break;
                case "grim_reaper":
                    musicMap.put(key, new Music("resources_/music_/grim reaper.ogg"));
                    break;
                case "highscore":
                    musicMap.put(key, new Music("resources_/music_/highscore.ogg"));
                    break;
                case "purity":
                    musicMap.put(key, new Music("resources_/music_/purity.ogg"));
                    break;
                case "yellow_orange":
                    musicMap.put(key, new Music("resources_/music_/yellow orange.ogg"));
                    break;
                case "surface":
                    musicMap.put(key, new Music("resources_/music_/surface.ogg"));
                    break;
                case "nokia_arabic":
                    musicMap.put(key, new Music("resources_/music_/nokia arabic.ogg"));
                    break;
                case "nrg_drink":
                    musicMap.put(key, new Music("resources_/music_/nrg drink.ogg"));
                    break;
                case "happy":
                    musicMap.put(key, new Music("resources_/music_/happy.ogg"));
                    break;
                case "moonsugar":
                    musicMap.put(key, new Music("resources_/music_/moonsugar.ogg"));
                    break;
                case "rubik":
                    musicMap.put(key, new Music("resources_/music_/rubik.ogg"));
                    break;
                case "ignition":
                    musicMap.put(key, new Music("resources_/music_/ignition.ogg"));
                    break;
                case "the_force":
                    musicMap.put(key, new Music("resources_/music_/the force.ogg"));
                    break;
                case "candyland":
                    musicMap.put(key, new Music("resources_/music_/candyland.ogg"));
                    break;
                case "infectious":
                    musicMap.put(key, new Music("resources_/music_/infectious.ogg"));
                    break;
                case "crazy":
                    musicMap.put(key, new Music("resources_/music_/crazy.ogg"));
                    break;
                case "race":
                    musicMap.put(key, new Music("resources_/music_/race.ogg"));
                    break;
                case "ice_flow":
                    musicMap.put(key, new Music("resources_/music_/ice flow.ogg"));
                    break;
                case "kalimba":
                    musicMap.put(key, new Music("resources_/music_/kalimba 119.70.ogg"));
                    break;
                case "party":
                    musicMap.put(key, new Music("resources_/music_/party.ogg"));
                    break;
                case "bass":
                    musicMap.put(key, new Music("resources_/music_/bass.ogg"));
                    break;
                case "hazmat":
                    musicMap.put(key, new Music("resources_/music_/hazmat.ogg"));
                    break;
                case "panda_dance":
                    musicMap.put(key, new Music("resources_/music_/panda dance.ogg"));
                    break;
                case "get_up":
                    musicMap.put(key, new Music("resources_/music_/get up.ogg"));
                    break;
                case "river":
                    musicMap.put(key, new Music("resources_/music_/river.ogg"));
                    break;
                case "follow":
                    musicMap.put(key, new Music("resources_/music_/follow.ogg"));
                    break;
                case "slime":
                    musicMap.put(key, new Music("resources_/music_/slime.ogg"));
                    break;
                case "euphoria":
                    musicMap.put(key, new Music("resources_/music_/euphoria.ogg"));
                    break;
                case "nautilus":
                    musicMap.put(key, new Music("resources_/music_/nautilus.ogg"));
                    break;
                    // template
                /*case "null":
                    musicMap.put(key, new Music("resources_/music_/null.ogg"));
                    break;*/
            }
        } catch (Exception e) {
            e.printStackTrace();
            int a = JOptionPane.showConfirmDialog(null, "An error occurred: " + e + ", \ndo you still wish to continue?", "Error", JOptionPane.INFORMATION_MESSAGE);
            if (a == JOptionPane.NO_OPTION) System.exit(0);
        }
    }
    
    public static Music getMusic (String key) {
        // load codes
        if (key != "music" && key != "null" && key != "shop_music" && game_.gameState != game_.STATE.GameBeta) {
            currentMusic = key;
            game_.gameState = game_.STATE.Load;
            game_.stringsforloading = "loading music: " + key;
            game_.loadstate -= 25;
            load(key);
            game_.loadstate += 25;
        }
        return musicMap.get(key);
    }
    
    public static Sound getSound (String key) {
        return soundMap.get(key);
    }

}
