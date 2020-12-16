/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.world;

import gamemakerstudio_.misc.ID;
import gamemakerstudio_.entities.*;
import gamemakerstudio_.entities.boss.crazyboss_;
import gamemakerstudio_.game_;
import gamemakerstudio_.gui.hud2_;
import gamemakerstudio_.gui.hud_;
import gamemakerstudio_.misc.gameobject_;
import gamemakerstudio_.misc.handler_;
import gamemakerstudio_.misc.audioplayer_;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class levels_ implements MouseMotionListener, MouseListener, KeyListener, ActionListener {
    private handler_ handler;
    private hud_ hud;
    private game_ game;
    private hud2_ hud2;
    private Random r = new Random();

    // duration bar
    public static double durationBar;
    int durationValue = 255;

    // music misc
    public static double bpm;
    public double tpm;
    public double spm;
    public static int endBar;

    private boolean metronome = true;

    public static double scoreKeep = 0;
    public static double scoreKeepStep = 0;

    public double difference;
    public double stepDifference;

    // level
    public static int page = 1;
    public static int levelid = 0;
    public int maxPage = 4;
    public String testString = "";

    // select if lazy
    int gridSelectX = 50, gridSelectY = 50;

    // bug fix
    public static int lazyDelayFix = 100;
    boolean lazyFixAgain = false;

    public levels_(handler_ handler, hud_ hud, game_ game, hud2_ hud2) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
        this.hud2 = hud2;
        game.addKeyListener(this);
    }

    public void hoverOnLevels(int mx, int my) {
        if (game.gameState == game_.STATE.LevelSelect) {
            if (page == 1) {
                if (mouseOver(mx, my, 50, 50, 50, 50)) {
                    testString = "1. Shiatsu";
                } else if (mouseOver(mx, my, 150, 50, 50, 50)) {
                    testString = "2. Astronomia";
                } else if (mouseOver(mx, my, 250, 50, 50, 50)) {
                    testString = "3. Andromeda";
                } else if (mouseOver(mx, my, 350, 50, 50, 50)) {
                    testString = "4. Rock the House";
                } else if (mouseOver(mx, my, 450, 50, 50, 50)) {
                    testString = "5. End of Time";
                } else if (mouseOver(mx, my, 550, 50, 50, 50)) {
                    testString = "6. Breathe";
                }
                // second row
                else if (mouseOver(mx, my, 50, 150, 50, 50)) {
                    testString = "7. Time Leaper";
                } else if (mouseOver(mx, my, 150, 150, 50, 50)) {
                    testString = "8. GG WP";
                } else if (mouseOver(mx, my, 250, 150, 50, 50)) {
                    testString = "9. Moment of Truth";
                } else if (mouseOver(mx, my, 350, 150, 50, 50)) {
                    testString = "10. Another World";
                } else if (mouseOver(mx, my, 450, 150, 50, 50)) {
                    testString = "11. There";
                } else if (mouseOver(mx, my, 550, 150, 50, 50)) {
                    testString = "12. Harmonies";
                }
                // third row
                else if (mouseOver(mx, my, 50, 250, 50, 50)) {
                    testString = "13. Fisher Price";
                } else if (mouseOver(mx, my, 150, 250, 50, 50)) {
                    testString = "14. Dance of the Violins";
                } else if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    testString = "15. Aether";
                } else if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    testString = "16. Clickbait";
                } else if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    testString = "17. Debug";
                } else if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    testString = "18. Fuchsia City";
                }
                // fourth row
                else if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    testString = "19. Ye";
                } else if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    testString = "20. Mocha";
                } else if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    testString = "21. Everything Falls";
                } else if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    testString = "22. Lonely Forest";
                } else if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    testString = "23. Magical";
                } else if (mouseOver(mx, my, 550, 350, 50, 50)) {
                    testString = "24. Overcharge";
                }
                // fifth row
                else if (mouseOver(mx, my, 50, 450, 50, 50)) {
                    testString = "25. Flavored Ice";
                } else if (mouseOver(mx, my, 150, 450, 50, 50)) {
                    testString = "26. Shape of the Sun";
                } else if (mouseOver(mx, my, 250, 450, 50, 50)) {
                    testString = "27. Angels";
                } else if (mouseOver(mx, my, 350, 450, 50, 50)) {
                    testString = "28. Perseverance";
                } else if (mouseOver(mx, my, 450, 450, 50, 50)) {
                    testString = "29. Dynasty";
                } else if (mouseOver(mx, my, 550, 450, 50, 50)) {
                    testString = "30. Bloom";
                }
                // sixth row
                else if (mouseOver(mx, my, 50, 550, 50, 50)) {
                    testString = "31. Canyon";
                } else if (mouseOver(mx, my, 150, 550, 50, 50)) {
                    testString = "32. Overcloud";
                } else if (mouseOver(mx, my, 250, 550, 50, 50)) {
                    testString = "32. Ppaper Pplanes";
                } else if (mouseOver(mx, my, 350, 550, 50, 50)) {
                    testString = "33. Prelude";
                } else if (mouseOver(mx, my, 450, 550, 50, 50)) {
                    testString = "34. Spirit";
                } else if (mouseOver(mx, my, 550, 550, 50, 50)) {
                    testString = "35. Catalyze";
                }
                // seventh row
                else if (mouseOver(mx, my, 50, 650, 50, 50)) {
                    testString = "36. Stray";
                } else if (mouseOver(mx, my, 150, 650, 50, 50)) {
                    testString = "37. Jazz Battle";
                } else if (mouseOver(mx, my, 250, 650, 50, 50)) {
                    testString = "38. Success";
                } else if (mouseOver(mx, my, 350, 650, 50, 50)) {
                    testString = "39. Supernova";
                } else if (mouseOver(mx, my, 450, 650, 50, 50)) {
                    testString = "40. The Beginning of Time";
                } else if (mouseOver(mx, my, 550, 650, 50, 50)) {
                    testString = "41. Marbl";
                }
                // else change to zero
                else testString = "";
            }
            if (page == 2) {
                // first row
                if (mouseOver(mx, my, 50, 50, 50, 50)) {
                    testString = "42. A Dreamer";
                } else if (mouseOver(mx, my, 150, 50, 50, 50)) {
                    testString = "43. Ghost House";
                } else if (mouseOver(mx, my, 250, 50, 50, 50)) {
                    testString = "44. Jude";
                } else if (mouseOver(mx, my, 350, 50, 50, 50)) {
                    testString = "45. Don't Hold Back";
                } else if (mouseOver(mx, my, 450, 50, 50, 50)) {
                    testString = "46. Ouais Ouais";
                } else if (mouseOver(mx, my, 550, 50, 50, 50)) {
                    testString = "47. Things That You Do";
                }
                // second row
                else if (mouseOver(mx, my, 50, 150, 50, 50)) {
                    testString = "48. Sad Summer";
                } else if (mouseOver(mx, my, 150, 150, 50, 50)) {
                    testString = "49. Wishing";
                } else if (mouseOver(mx, my, 250, 150, 50, 50)) {
                    testString = "50. Call the Popo";
                } else if (mouseOver(mx, my, 350, 150, 50, 50)) {
                    testString = "51. Ocean Ambiance Remix";
                } else if (mouseOver(mx, my, 450, 150, 50, 50)) {
                    testString = "52. Snowcone";
                } else if (mouseOver(mx, my, 550, 150, 50, 50)) {
                    testString = "53. Sawdust Angels";
                }
                // third row
                else if (mouseOver(mx, my, 50, 250, 50, 50)) {
                    testString = "54. Sky High";
                } else if (mouseOver(mx, my, 150, 250, 50, 50)) {
                    testString = "55. My Heart";
                } else if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    testString = "56. Nekozilla";
                } else if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    testString = "57. Cloud 9";
                } else if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    testString = "58. Sunburst";
                } else if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    testString = "59. Hellcat";
                }
                // fourth row
                else if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    testString = "60. Song for Denise";
                }
                else if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    testString = "61. Dollar Needles 1";
                }
                else if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    testString = "62. Dollar Needles 3";
                }
                else if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    testString = "63. Behind These Closed Doors";
                }
                else if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    testString = "64. Otis McMusic";
                }
                else if (mouseOver(mx, my, 550, 350, 50, 50)) {
                    testString = "65. Not for Nothing";
                }
                // fifth row
                else if (mouseOver(mx, my, 50, 450, 50, 50)) {
                    testString = "66. Mind Control";
                }
                else if (mouseOver(mx, my, 150, 450, 50, 50)) {
                    testString = "67. Memories";
                }
                else if (mouseOver(mx, my, 250, 450, 50, 50)) {
                    testString = "68. 2011";
                }
                else if (mouseOver(mx, my, 350, 450, 50, 50)) {
                    testString = "69. 10000";
                }
                else if (mouseOver(mx, my, 450, 450, 50, 50)) {
                    testString = "70. Merry Christmas";
                }
                else if (mouseOver(mx, my, 550, 450, 50, 50)) {
                    testString = "71. Crab Rave";
                }
                // sixth row
                else if (mouseOver(mx, my, 50, 550, 50, 50)) {
                    testString = "72. Insurgent";
                }
                else if (mouseOver(mx, my, 150, 550, 50, 50)) {
                    testString = "73. Late Night Lo-Fi";
                }
                else if (mouseOver(mx, my, 250, 550, 50, 50)) {
                    testString = "74. Lith Harbor";
                }
                else if (mouseOver(mx, my, 350, 550, 50, 50)) {
                    testString = "75. Lost in Thought";
                }
                else if (mouseOver(mx, my, 450, 550, 50, 50)) {
                    testString = "76. Holystone";
                }
                else if (mouseOver(mx, my, 550, 550, 50, 50)) {
                    testString = "77. Pounce";
                }
                // seventh row
                else if (mouseOver(mx, my, 50, 650, 50, 50)) {
                    testString = "78. Futa Dick";
                }
                else if (mouseOver(mx, my, 150, 650, 50, 50)) {
                    testString = "79. Golden Haze";
                }
                else if (mouseOver(mx, my, 250, 650, 50, 50)) {
                    testString = "80. Grim Reaper";
                }
                else if (mouseOver(mx, my, 350, 650, 50, 50)) {
                    testString = "81. Highscore";
                }
                else if (mouseOver(mx, my, 450, 650, 50, 50)) {
                    testString = "82. Purity";
                }
                else if (mouseOver(mx, my, 550, 650, 50, 50)) {
                    testString = "83. Yellow Orange Afternoon";
                }
                // else change to zero
                else testString = "";
            }
            if (page == 3) {
                // first row
                if (mouseOver(mx, my, 50, 50, 50, 50)) {
                    testString = "84. Surface";
                }
                else if (mouseOver(mx, my, 150, 50, 50, 50)) {
                    testString = "85. Arabic Nokia Type Beat";
                }
                else if (mouseOver(mx, my, 250, 50, 50, 50)) {
                    testString = "86. Energy Drink";
                }
                else if (mouseOver(mx, my, 350, 50, 50, 50)) {
                    testString = "87. Happy";
                }
                else if (mouseOver(mx, my, 450, 50, 50, 50)) {
                    testString = "88. Moonsugar";
                }
                else if (mouseOver(mx, my, 550, 50, 50, 50)) {
                    testString = "89. Rubik";
                }
                // second row
                else if (mouseOver(mx, my, 50, 150, 50, 50)) {
                    testString = "90. Ignition";
                }
                else if (mouseOver(mx, my, 150, 150, 50, 50)) {
                    testString = "91. The Force";
                }
                else if (mouseOver(mx, my, 250, 150, 50, 50)) {
                    testString = "92. Candyland";
                }
                else if (mouseOver(mx, my, 350, 150, 50, 50)) {
                    testString = "93. Infectious";
                }
                else if (mouseOver(mx, my, 450, 150, 50, 50)) {
                    testString = "94. Crazy";
                }
                else if (mouseOver(mx, my, 550, 150, 50, 50)) {
                    testString = "95. Race Around the World";
                }
                // third row
                else if (mouseOver(mx, my, 50, 250, 50, 50)) {
                    testString = "96. Ice Flow";
                }
                else if (mouseOver(mx, my, 150, 250, 50, 50)) {
                    testString = "97. Kalimba";
                }
                else if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    testString = "98. Who Likes to Party";
                }
                else if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    testString = "99. Invasion of the Gabber Robots";
                }
                else if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    testString = "100. Hazmat";
                }
                else if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    testString = "101. Panda Dance";
                }
                // forth row
                else if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    testString = "102. Get Up";
                }
                else if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    testString = "103. River";
                }
                else if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    testString = "104. Follow";
                }
                else if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    testString = "105. Slime";
                }
                else if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    testString = "106. Euphoria";
                }
                else if (mouseOver(mx, my, 550, 350, 50, 50)) {
                    testString = "107. Nautilus";
                }
                // fifth row
                else if (mouseOver(mx, my, 50, 450, 50, 50)) {
                    testString = "108. Crystal Corruption";
                }
                else if (mouseOver(mx, my, 150, 450, 50, 50)) {
                    testString = "109. Crazy Frog";
                }
                else if (mouseOver(mx, my, 250, 450, 50, 50)) {
                    testString = "110. Never Lose Hope";
                }
                else if (mouseOver(mx, my, 350, 450, 50, 50)) {
                    testString = "111. Skystrike";
                }
                else if (mouseOver(mx, my, 450, 450, 50, 50)) {
                    testString = "112. Starchaser";
                }
                else if (mouseOver(mx, my, 550, 450, 50, 50)) {
                    testString = "113. A Newer Dawn";
                }
                // sixth row
                else if (mouseOver(mx, my, 50, 550, 50, 50)) {
                    testString = "114. Monody";
                }
                else if (mouseOver(mx, my, 150, 550, 50, 50)) {
                    testString = "115. Unity";
                }
                else if (mouseOver(mx, my, 250, 550, 50, 50)) {
                    testString = "116. Xenogenesis";
                }
                else if (mouseOver(mx, my, 350, 550, 50, 50)) {
                    testString = "117. Time Stops";
                }
                else if (mouseOver(mx, my, 450, 550, 50, 50)) {
                    testString = "118. Badland";
                }
                else if (mouseOver(mx, my, 550, 550, 50, 50)) {
                    testString = "119. Challenger";
                }
                // seventh row
                else if (mouseOver(mx, my, 50, 650, 50, 50)) {
                    testString = "120. Bluemoon";
                }
                else if (mouseOver(mx, my, 150, 650, 50, 50)) {
                    testString = "121. Cherry Blossoms";
                }
                else if (mouseOver(mx, my, 250, 650, 50, 50)) {
                    testString = "122. Walkman";
                }
                else if (mouseOver(mx, my, 350, 650, 50, 50)) {
                    testString = "123. Beyond the Walls";
                }
                else if (mouseOver(mx, my, 450, 650, 50, 50)) {
                    testString = "124. April";
                }
                else if (mouseOver(mx, my, 550, 650, 50, 50)) {
                    testString = "125. Sunlight";
                }
                // else change to zero
                else testString = "";
            }
            if (page == 4) {
                // first row
                if (mouseOver(mx, my, 50, 50, 50, 50)){
                    testString = "126. Cyptik Dance";
                }
                else if (mouseOver(mx, my, 150, 50, 50, 50)){
                    testString = "127. Leaving Leafwood Forest";
                }
                else if (mouseOver(mx, my, 250, 50, 50, 50)){
                    testString = "128. Troglodyte";
                }
                else if (mouseOver(mx, my, 350, 50, 50, 50)){
                    testString = "129. The Maze of Mayonnaise";
                }
                else if (mouseOver(mx, my, 450, 50, 50, 50)){
                    testString = "130. Starship Showdown";
                }
                else if (mouseOver(mx, my, 550, 50, 50, 50)){
                    testString = "131. Kumquat";
                }
                // second row
                else if (mouseOver(mx, my, 50, 150, 50, 50)){
                    testString = "132. O-Oh Hi-i T-There, J-J-Jaclyn";
                }
                else if (mouseOver(mx, my, 150, 150, 50, 50)){
                    testString = "133. This Chap Named Jacques";
                }
                else if (mouseOver(mx, my, 250, 150, 50, 50)){
                    testString = "134. Liftoff";
                }
                else if (mouseOver(mx, my, 350, 150, 50, 50)){
                    testString = "135. Never Be Alone";
                }
                else if (mouseOver(mx, my, 450, 150, 50, 50)){
                    testString = "136. Solitude";
                }
                else if (mouseOver(mx, my, 550, 150, 50, 50)){
                    testString = "137. Close to the Sun";
                }
                // third row
                else if (mouseOver(mx, my, 50, 250, 50, 50)){
                    testString = "138. Nanamori";
                }
                else if (mouseOver(mx, my, 150, 250, 50, 50)){
                    testString = "139. Fury";
                }
                else if (mouseOver(mx, my, 250, 250, 50, 50)){
                    testString = "140. Desu Ka";
                }
                else if (mouseOver(mx, my, 350, 250, 50, 50)){
                    testString = "141. Voices";
                }
                else if (mouseOver(mx, my, 450, 250, 50, 50)){
                    testString = "142. Dancing";
                }
                else if (mouseOver(mx, my, 550, 250, 50, 50)){
                    testString = "143. Shining Space";
                }
                // fourth row
                else if (mouseOver(mx, my, 50, 350, 50, 50)){
                    testString = "144. Space Invaders";
                }
                else if (mouseOver(mx, my, 150, 350, 50, 50)){
                    testString = "145. Drippy Dub";
                }
                else if (mouseOver(mx, my, 250, 350, 50, 50)){
                    testString = "146. Fake Princess";
                }
                else if (mouseOver(mx, my, 350, 350, 50, 50)){
                    testString = "147. The Beauty and The Lazergun";
                }
                else if (mouseOver(mx, my, 450, 350, 50, 50)){
                    testString = "148. Afterimage";
                }
                else if (mouseOver(mx, my, 550, 350, 50, 50)){
                    testString = "149. Star Wars Remix";
                }
                // fifth row
                else if (mouseOver(mx, my, 50, 450, 50, 50)){
                    testString = "150. Kiss Me Kiss You";
                }
                else if (mouseOver(mx, my, 150, 450, 50, 50)){
                    testString = "151. Enigma";
                }
                else if (mouseOver(mx, my, 250, 450, 50, 50)){
                    testString = "152. Never Make It";
                }
                else if (mouseOver(mx, my, 350, 450, 50, 50)){
                    testString = "153. Flight";
                }
                else if (mouseOver(mx, my, 450, 450, 50, 50)){
                    testString = "154. Journey";
                }
                else if (mouseOver(mx, my, 550, 450, 50, 50)){
                    testString = "155. Lonely Forest";
                }
                // sixth row
                else if (mouseOver(mx, my, 50, 550, 50, 50)){
                    testString = "156. He's a Pirate";
                }
                else if (mouseOver(mx, my, 150, 550, 50, 50)){
                    testString = "157. Aquamarine";
                }
                else if (mouseOver(mx, my, 250, 550, 50, 50)){
                    testString = "158. Boombox 2012";
                }
                else if (mouseOver(mx, my, 350, 550, 50, 50)){
                    testString = "159. Dreams";
                }
                else if (mouseOver(mx, my, 450, 550, 50, 50)){
                    testString = "160. Requiem for a Dream";
                }
                else if (mouseOver(mx, my, 550, 550, 50, 50)){
                    testString = "161. Eurodancer";
                }
                // seventh row
                else if (mouseOver(mx, my, 50, 650, 50, 50)){
                    testString = "162. Hello";
                }
                else if (mouseOver(mx, my, 150, 650, 50, 50)){
                    testString = "163. Mayday";
                }
                else if (mouseOver(mx, my, 250, 650, 50, 50)){
                    testString = "164. Firefiles (Zyzyx Remix)";
                }
                else if (mouseOver(mx, my, 350, 650, 50, 50)){
                    testString = "165. Echolands";
                }
                else if (mouseOver(mx, my, 450, 650, 50, 50)){
                    testString = "166. Voiceless";
                }
                else if (mouseOver(mx, my, 550, 650, 50, 50)){
                    testString = "167. Vaporwave Aesthetics";
                }

                // else change to zero
                else testString = "";
            }
            /*if (mouseOver(mx, my, 50, 50, 50, 50)){
                testString = "";
            }
            else if (mouseOver(mx, my, 50, 50, 50, 50)){
                testString = "";
            }
            // else change to zero
                else testString = "";*/
        }
    }

    public void levelsList(int mx, int my) {
        if (game.loadstate == 100) {
            if (page == 1) {
                if (mouseOver(mx, my, 50, 50, 50, 50)) {
                    levelid = 1;
                    System.out.println("world 1");

                    if (game_.music) audioplayer_.getMusic("dead_meme").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 125;
                    endBar = 84;
                }
                if (mouseOver(mx, my, 150, 50, 50, 50)) {
                    levelid = 2;
                    System.out.println("world 2");

                    if (game_.music) audioplayer_.getMusic("dead_meme_2").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 126;
                    endBar = 130;
                }
                if (mouseOver(mx, my, 250, 50, 50, 50)) {
                    levelid = 3;
                    System.out.println("world 3");

                    if (game_.music) audioplayer_.getMusic("eschew").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 120;
                    endBar = 144;
                }
                if (mouseOver(mx, my, 350, 50, 50, 50)) {
                    levelid = 4;
                    System.out.println("world 4");

                    if (game_.music) audioplayer_.getMusic("rock_the_house").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 106;
                }
                if (mouseOver(mx, my, 450, 50, 50, 50)) {
                    levelid = 5;
                    System.out.println("world 5");

                    if (game_.music) audioplayer_.getMusic("end_of_time").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 132;
                    endBar = 122;
                }
                if (mouseOver(mx, my, 550, 50, 50, 50)) {
                    levelid = 6;
                    System.out.println("world 6");

                    if (game_.music) audioplayer_.getMusic("nova_music").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 105;
                    endBar = 102;
                }
                // second row
                if (mouseOver(mx, my, 50, 150, 50, 50)) {
                    levelid = 7;
                    System.out.println("world 7");

                    if (game_.music) audioplayer_.getMusic("time_leaper").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 87.5;
                    endBar = 88;
                }
                if (mouseOver(mx, my, 150, 150, 50, 50)) {
                    levelid = 8;
                    System.out.println("world 8");

                    if (game_.music) audioplayer_.getMusic("gg").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 87.5;
                    endBar = 110;
                }
                if (mouseOver(mx, my, 250, 150, 50, 50)) {
                    levelid = 9;
                    System.out.println("world 9");

                    if (game_.music) audioplayer_.getMusic("namice1").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 90;
                }
                if (mouseOver(mx, my, 350, 150, 50, 50)) {
                    levelid = 10;
                    System.out.println("world 10");

                    if (game_.music) audioplayer_.getMusic("namice2").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 94;
                }
                if (mouseOver(mx, my, 450, 150, 50, 50)) {
                    levelid = 11;
                    System.out.println("world 11");

                    if (game_.music) audioplayer_.getMusic("there").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 127;
                    endBar = 139;
                }
                if (mouseOver(mx, my, 550, 150, 50, 50)) {
                    levelid = 12;
                    System.out.println("world 12");

                    if (game_.music) audioplayer_.getMusic("namice3").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 72;
                }
                // third row
                if (mouseOver(mx, my, 50, 250, 50, 50)) {
                    levelid = 13;
                    System.out.println("world 13");

                    if (game_.music) audioplayer_.getMusic("fisher_price").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 92.5;
                    endBar = 73;
                }
                if (mouseOver(mx, my, 150, 250, 50, 50)) {
                    levelid = 14;
                    System.out.println("world 14");

                    if (game_.music) audioplayer_.getMusic("dance_violins").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 130;
                    endBar = 179;
                }
                if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    levelid = 15;
                    System.out.println("world 15");

                    if (game_.music) audioplayer_.getMusic("aether").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 165;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    levelid = 16;
                    System.out.println("world 16");

                    if (game_.music) audioplayer_.getMusic("clickbait").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 113;
                }
                if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    levelid = 17;
                    System.out.println("world 17");

                    if (game_.music) audioplayer_.getMusic("debug").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 130;
                    endBar = 218;
                }
                if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    levelid = 18;
                    System.out.println("world 18");

                    if (game_.music) audioplayer_.getMusic("iy").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 114;
                    endBar = 125;
                }
                // fourth row
                if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    levelid = 19;
                    System.out.println("world 19");

                    if (game_.music) audioplayer_.getMusic("ye").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 30;
                }
                if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    levelid = 20;
                    System.out.println("world 20");

                    if (game_.music) audioplayer_.getMusic("mocha").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 160;
                    endBar = 138;
                }
                if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    levelid = 21;
                    System.out.println("world 21");

                    if (game_.music) audioplayer_.getMusic("everything_falls").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 90;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    levelid = 22;
                    System.out.println("world 22");

                    if (game_.music) audioplayer_.getMusic("lonely_forest").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 101;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    levelid = 23;
                    System.out.println("world 23");

                    if (game_.music) audioplayer_.getMusic("saxophone").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 96;
                    endBar = 31;
                }
                if (mouseOver(mx, my, 550, 350, 50, 50)) {
                    levelid = 24;
                    System.out.println("world 24");

                    if (game_.music) audioplayer_.getMusic("overcharge").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 80;
                    endBar = 70;
                }
                // fifth row
                if (mouseOver(mx, my, 50, 450, 50, 50)) {
                    levelid = 25;
                    System.out.println("world 25");

                    if (game_.music) audioplayer_.getMusic("flavored_ice").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 160;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 150, 450, 50, 50)) {
                    levelid = 26;
                    System.out.println("world 26");

                    if (game_.music) audioplayer_.getMusic("shape_of_the_sun").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 82.52;
                    endBar = 68;
                }
                if (mouseOver(mx, my, 250, 450, 50, 50)) {
                    levelid = 27;
                    System.out.println("world 27");

                    if (game_.music) audioplayer_.getMusic("angels").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 114;
                }
                if (mouseOver(mx, my, 350, 450, 50, 50)) {
                    levelid = 28;
                    System.out.println("world 28");

                    if (game_.music) audioplayer_.getMusic("perseverance").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 130;
                    endBar = 162;
                }
                if (mouseOver(mx, my, 450, 450, 50, 50)) {
                    levelid = 29;
                    System.out.println("world 29");

                    if (game_.music) audioplayer_.getMusic("dynasty").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 131;
                }
                if (mouseOver(mx, my, 550, 450, 50, 50)) {
                    levelid = 30;
                    System.out.println("world 30");

                    if (game_.music) audioplayer_.getMusic("bloom").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 106;
                    endBar = 86;
                }
                // sixth row
                if (mouseOver(mx, my, 50, 550, 50, 50)) {
                    levelid = 31;
                    System.out.println("world 31");

                    if (game_.music) audioplayer_.getMusic("canyon").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 85;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 150, 550, 50, 50)) {
                    levelid = 31;
                    System.out.println("world 31");

                    if (game_.music) audioplayer_.getMusic("overcloud").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 138;
                }
                if (mouseOver(mx, my, 250, 550, 50, 50)) {
                    levelid = 32;
                    System.out.println("world 32");

                    if (game_.music) audioplayer_.getMusic("ppaper_pplanes").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 89.8;
                    endBar = 57;
                }
                if (mouseOver(mx, my, 350, 550, 50, 50)) {
                    levelid = 33;
                    System.out.println("world 33");

                    if (game_.music) audioplayer_.getMusic("prelude").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 113;
                    endBar = 100;
                }
                if (mouseOver(mx, my, 450, 550, 50, 50)) {
                    levelid = 34;
                    System.out.println("world 34");

                    if (game_.music) audioplayer_.getMusic("spirit").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 87;
                    endBar = 91;
                }
                if (mouseOver(mx, my, 550, 550, 50, 50)) {
                    levelid = 35;
                    System.out.println("world 35");

                    if (game_.music) audioplayer_.getMusic("catalyze").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 170;
                }
                // seventh row
                if (mouseOver(mx, my, 50, 650, 50, 50)) {
                    levelid = 36;
                    System.out.println("world 36");

                    if (game_.music) audioplayer_.getMusic("stray").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 108;
                    endBar = 99;
                }
                if (mouseOver(mx, my, 150, 650, 50, 50)) {
                    levelid = 37;
                    System.out.println("world 37");

                    if (game_.music) audioplayer_.getMusic("jazz").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 91;
                }
                if (mouseOver(mx, my, 250, 650, 50, 50)) {
                    levelid = 38;
                    System.out.println("world 38");

                    if (game_.music) audioplayer_.getMusic("success").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 140;
                }
                if (mouseOver(mx, my, 350, 650, 50, 50)) {
                    levelid = 39;
                    System.out.println("world 39");

                    if (game_.music) audioplayer_.getMusic("supernova").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 85;
                    endBar = 110;
                }
                if (mouseOver(mx, my, 450, 650, 50, 50)) {
                    levelid = 40;
                    System.out.println("world 40");

                    if (game_.music) audioplayer_.getMusic("time").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 170;
                    endBar = 116;
                }
                if (mouseOver(mx, my, 550, 650, 50, 50)) {
                    levelid = 41;
                    System.out.println("world 41");

                    if (game_.music) audioplayer_.getMusic("marbl").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 134;
                }
            }
            if (page == 2) {
                // first row
                if (mouseOver(mx, my, 50, 50, 50, 50)) {
                    levelid = 42;
                    System.out.println("world 42");

                    if (game_.music) audioplayer_.getMusic("dreamer").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 139;
                }
                if (mouseOver(mx, my, 150, 50, 50, 50)) {
                    levelid = 43;
                    System.out.println("world 43");

                    if (game_.music) audioplayer_.getMusic("ghost_house").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 130;
                    endBar = 117;
                }
                if (mouseOver(mx, my, 250, 50, 50, 50)) {
                    levelid = 44;
                    System.out.println("world 44");

                    if (game_.music) audioplayer_.getMusic("jude").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 180;
                    endBar = 113;
                }
                if (mouseOver(mx, my, 350, 50, 50, 50)) {
                    levelid = 45;
                    System.out.println("world 45");

                    if (game_.music) audioplayer_.getMusic("don't_hold_back").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 116;
                    endBar = 111;
                }
                if (mouseOver(mx, my, 450, 50, 50, 50)) {
                    levelid = 46;
                    System.out.println("world 46");

                    if (game_.music) audioplayer_.getMusic("ouais_ouais").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 120;
                    endBar = 116;
                }
                if (mouseOver(mx, my, 550, 50, 50, 50)) {
                    levelid = 47;
                    System.out.println("world 47");

                    if (game_.music) audioplayer_.getMusic("things_that_you_do").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 120;
                    endBar = 138;
                }
                // second row
                if (mouseOver(mx, my, 50, 150, 50, 50)) {
                    levelid = 48;
                    System.out.println("world 48");

                    if (game_.music) audioplayer_.getMusic("sad_summer").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 75;
                    endBar = 49;
                }
                if (mouseOver(mx, my, 150, 150, 50, 50)) {
                    levelid = 49;
                    System.out.println("world 49");

                    if (game_.music) audioplayer_.getMusic("wishing").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 74;
                    endBar = 48;
                }
                if (mouseOver(mx, my, 250, 150, 50, 50)) {
                    levelid = 50;
                    System.out.println("world 50");

                    if (game_.music) audioplayer_.getMusic("popo").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 79;
                    endBar = 61;
                }
                if (mouseOver(mx, my, 350, 150, 50, 50)) {
                    levelid = 51;
                    System.out.println("world 51");

                    if (game_.music) audioplayer_.getMusic("ocean_biome").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 120;
                }
                if (mouseOver(mx, my, 450, 150, 50, 50)) {
                    levelid = 52;
                    System.out.println("world 52");

                    if (game_.music) audioplayer_.getMusic("snowcone").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 87;
                    endBar = 90;
                }
                if (mouseOver(mx, my, 550, 150, 50, 50)) {
                    levelid = 53;
                    System.out.println("world 53");

                    if (game_.music) audioplayer_.getMusic("sawdust_angels").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 174;
                    endBar = 142;
                }
                // third row
                if (mouseOver(mx, my, 50, 250, 50, 50)) {
                    levelid = 54;
                    System.out.println("world 54");

                    if (game_.music) audioplayer_.getMusic("sky_high").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 120;
                }
                if (mouseOver(mx, my, 150, 250, 50, 50)) {
                    levelid = 55;
                    System.out.println("world 55");

                    if (game_.music) audioplayer_.getMusic("my_heart").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 87;
                    endBar = 98;
                }
                if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    levelid = 56;
                    System.out.println("world 56");

                    if (game_.music) audioplayer_.getMusic("nekozilla").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 88;
                }
                if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    levelid = 57;
                    System.out.println("world 57");

                    if (game_.music) audioplayer_.getMusic("cloud_9").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 146;
                }
                if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    levelid = 58;
                    System.out.println("world 58");

                    if (game_.music) audioplayer_.getMusic("sunburst").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 100;
                }
                if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    levelid = 59;
                    System.out.println("world 59");

                    if (game_.music) audioplayer_.getMusic("hellcat").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 87;
                    endBar = 82;
                }
                // fourth row
                if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    levelid = 60;
                    System.out.println("world 60");

                    if (game_.music) audioplayer_.getMusic("denise").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 102.42;
                    endBar = 82;
                }
                if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    levelid = 61;
                    System.out.println("world 61");

                    if (game_.music) audioplayer_.getMusic("dollar_needles_1").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 88;
                    endBar = 53;
                }
                if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    levelid = 62;
                    System.out.println("world 62");

                    if (game_.music) audioplayer_.getMusic("dollar_needles_3").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 83;
                    endBar = 50;
                }
                if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    levelid = 63;
                    System.out.println("world 63");

                    if (game_.music) audioplayer_.getMusic("behind_these_closed_doors").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 88;
                    endBar = 48;
                }
                if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    levelid = 64;
                    System.out.println("world 64");

                    if (game_.music) audioplayer_.getMusic("otis_mcmusic").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 92;
                    endBar = 50;
                }
                if (mouseOver(mx, my, 550, 350, 50, 50)) {
                    levelid = 65;
                    System.out.println("world 65");

                    if (game_.music) audioplayer_.getMusic("not_for_nothing").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 86.4;
                    endBar = 44;
                }
                // fifth row
                if (mouseOver(mx, my, 50, 450, 50, 50)) {
                    levelid = 66;
                    System.out.println("world 66");

                    if (game_.music) audioplayer_.getMusic("mind_control").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 129.46;
                    endBar = 140;
                }
                if (mouseOver(mx, my, 150, 450, 50, 50)) {
                    levelid = 67;
                    System.out.println("world 67");

                    if (game_.music) audioplayer_.getMusic("memories").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 130;
                }
                if (mouseOver(mx, my, 250, 450, 50, 50)) {
                    levelid = 68;
                    System.out.println("world 68");

                    if (game_.music) audioplayer_.getMusic("2011").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 102.1;
                    endBar = 82;
                }
                if (mouseOver(mx, my, 350, 450, 50, 50)) {
                    levelid = 69;
                    System.out.println("world 69");

                    if (game_.music) audioplayer_.getMusic("10000").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 100;
                    endBar = 102;
                }
                if (mouseOver(mx, my, 450, 450, 50, 50)) {
                    levelid = 70;
                    System.out.println("world 70");

                    if (game_.music) audioplayer_.getMusic("merry_christmas").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 200;
                    endBar = 50;
                }
                if (mouseOver(mx, my, 550, 450, 50, 50)) {
                    levelid = 71;
                    System.out.println("world 71");

                    if (game_.music) audioplayer_.getMusic("crab_rave").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 125;
                    endBar = 82;
                }
                // sixth row
                if (mouseOver(mx, my, 50, 550, 50, 50)) {
                    levelid = 72;
                    System.out.println("world 72");

                    if (game_.music) audioplayer_.getMusic("insurgent").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 127;
                }
                if (mouseOver(mx, my, 150, 550, 50, 50)) {
                    levelid = 73;
                    System.out.println("world 73");

                    if (game_.music) audioplayer_.getMusic("late_night_lo-fi").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 98;
                }
                if (mouseOver(mx, my, 250, 550, 50, 50)) {
                    levelid = 74;
                    System.out.println("world 74");

                    if (game_.music) audioplayer_.getMusic("lith_harbor").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 127;
                    endBar = 79;
                }
                if (mouseOver(mx, my, 350, 550, 50, 50)) {
                    levelid = 75;
                    System.out.println("world 75");

                    if (game_.music) audioplayer_.getMusic("lost_in_thought").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 90;
                    endBar = 31;
                }
                if (mouseOver(mx, my, 450, 550, 50, 50)) {
                    levelid = 76;
                    System.out.println("world 76");

                    if (game_.music) audioplayer_.getMusic("holystone").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 186;
                }
                if (mouseOver(mx, my, 550, 550, 50, 50)) {
                    levelid = 77;
                    System.out.println("world 77");

                    if (game_.music) audioplayer_.getMusic("pounce").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 76;
                }
                // seventh row
                if (mouseOver(mx, my, 50, 650, 50, 50)) {
                    levelid = 78;
                    System.out.println("world 78");

                    if (game_.music) audioplayer_.getMusic("dick").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 121;
                    endBar = 59;
                }
                if (mouseOver(mx, my, 150, 650, 50, 50)) {
                    levelid = 79;
                    System.out.println("world 79");

                    if (game_.music) audioplayer_.getMusic("golden_haze").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 90;
                }
                if (mouseOver(mx, my, 250, 650, 50, 50)) {
                    levelid = 80;
                    System.out.println("world 80");

                    if (game_.music) audioplayer_.getMusic("grim_reaper").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 90;
                    endBar = 46;
                }
                if (mouseOver(mx, my, 350, 650, 50, 50)) {
                    levelid = 81;
                    System.out.println("world 81");

                    if (game_.music) audioplayer_.getMusic("highscore").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 118;
                }
                if (mouseOver(mx, my, 450, 650, 50, 50)) {
                    levelid = 82;
                    System.out.println("world 82");

                    if (game_.music) audioplayer_.getMusic("purity").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 91;
                }
                if (mouseOver(mx, my, 550, 650, 50, 50)) {
                    levelid = 83;
                    System.out.println("world 83");

                    if (game_.music) audioplayer_.getMusic("yellow_orange").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 105;
                    endBar = 77;
                }
            }
            if (page == 3) {
                // first row
                if (mouseOver(mx, my, 50, 50, 50, 50)) {
                    levelid = 84;
                    System.out.println("world 84");

                    if (game_.music) audioplayer_.getMusic("surface").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 85;
                    endBar = 91;
                }
                if (mouseOver(mx, my, 150, 50, 50, 50)) {
                    levelid = 85;
                    System.out.println("world 85");

                    if (game_.music) audioplayer_.getMusic("nokia_arabic").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 82;
                    endBar = 38;
                }
                if (mouseOver(mx, my, 250, 50, 50, 50)) {
                    levelid = 86;
                    System.out.println("world 86");

                    if (game_.music) audioplayer_.getMusic("nrg_drink").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 162;
                }
                if (mouseOver(mx, my, 350, 50, 50, 50)) {
                    levelid = 87;
                    System.out.println("world 87");

                    if (game_.music) audioplayer_.getMusic("happy").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 195;
                    endBar = 125;
                }
                if (mouseOver(mx, my, 450, 50, 50, 50)) {
                    levelid = 88;
                    System.out.println("world 88");

                    if (game_.music) audioplayer_.getMusic("moonsugar").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 140;
                }
                if (mouseOver(mx, my, 550, 50, 50, 50)) {
                    levelid = 89;
                    System.out.println("world 89");

                    if (game_.music) audioplayer_.getMusic("rubik").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 109;
                }
                // second row
                if (mouseOver(mx, my, 50, 150, 50, 50)) {
                    levelid = 90;
                    System.out.println("world 90");

                    if (game_.music) audioplayer_.getMusic("ignition").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 104;
                    endBar = 66;
                }
                if (mouseOver(mx, my, 150, 150, 50, 50)) {
                    levelid = 91;
                    System.out.println("world 91");

                    if (game_.music) audioplayer_.getMusic("the_force").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 139;
                }
                if (mouseOver(mx, my, 250, 150, 50, 50)) {
                    levelid = 92;
                    System.out.println("world 92");

                    if (game_.music) audioplayer_.getMusic("candyland").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 107;
                }
                if (mouseOver(mx, my, 350, 150, 50, 50)) {
                    levelid = 93;
                    System.out.println("world 93");

                    if (game_.music) audioplayer_.getMusic("infectious").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 138;
                }
                if (mouseOver(mx, my, 450, 150, 50, 50)) {
                    levelid = 94;
                    System.out.println("world 94");

                    if (game_.music) audioplayer_.getMusic("crazy").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 120;
                    endBar = 110;
                }
                if (mouseOver(mx, my, 550, 150, 50, 50)) {
                    levelid = 95;
                    System.out.println("world 95");

                    if (game_.music) audioplayer_.getMusic("race").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 90;
                    endBar = 65;
                }
                // third row
                if (mouseOver(mx, my, 50, 250, 50, 50)) {
                    levelid = 96;
                    System.out.println("world 96");

                    if (game_.music) audioplayer_.getMusic("ice_flow").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 82;
                }
                if (mouseOver(mx, my, 150, 250, 50, 50)) {
                    levelid = 97;
                    System.out.println("world 97");

                    if (game_.music) audioplayer_.getMusic("kalimba").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 119.7;
                    endBar = 174;
                }
                if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    levelid = 98;
                    System.out.println("world 98");

                    if (game_.music) audioplayer_.getMusic("party").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 117;
                    endBar = 127;
                }
                if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    levelid = 99;
                    System.out.println("world 99");

                    if (game_.music) audioplayer_.getMusic("bass").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 160;
                    endBar = 160;
                }
                if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    levelid = 100;
                    System.out.println("world 100");

                    if (game_.music) audioplayer_.getMusic("hazmat").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 56;
                }
                if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    levelid = 101;
                    System.out.println("world 101");

                    if (game_.music) audioplayer_.getMusic("panda_dance").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 63;
                }
                // fourth row
                if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    levelid = 102;
                    System.out.println("world 102");

                    if (game_.music) audioplayer_.getMusic("get_up").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 84;
                    endBar = 58;
                }
                if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    levelid = 103;
                    System.out.println("world 103");

                    if (game_.music) audioplayer_.getMusic("river").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 82;
                    endBar = 30;
                }
                if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    levelid = 104;
                    System.out.println("world 104");

                    if (game_.music) audioplayer_.getMusic("follow").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 144;
                    endBar = 141;
                }
                if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    levelid = 105;
                    System.out.println("world 105");

                    if (game_.music) audioplayer_.getMusic("slime").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 115;
                    endBar = 107;
                }
                if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    levelid = 106;
                    System.out.println("world 106");

                    if (game_.music) audioplayer_.getMusic("euphoria").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 110;
                    endBar = 84;
                }
                if (mouseOver(mx, my, 550, 350, 50, 50)) {
                    levelid = 107;
                    System.out.println("world 107");

                    if (game_.music) audioplayer_.getMusic("nautilus").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 124;
                    endBar = 167;
                }
                // fifth row
                if (mouseOver(mx, my, 50, 450, 50, 50)) {
                    levelid = 108;
                    System.out.println("world 108");

                    if (game_.music) audioplayer_.getMusic("liaquo").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 183;
                }
                if (mouseOver(mx, my, 150, 450, 50, 50)) {
                    levelid = 109;
                    System.out.println("world 109");

                    if (game_.music) audioplayer_.getMusic("crazy_frog").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 138;
                    endBar = 98;
                }
                if (mouseOver(mx, my, 250, 450, 50, 50)) {
                    levelid = 110;
                    System.out.println("world 110");

                    if (game_.music) audioplayer_.getMusic("never_lose_hope").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 170;
                    endBar = 125;
                }
                if (mouseOver(mx, my, 350, 450, 50, 50)) {
                    levelid = 111;
                    System.out.println("world 111");

                    if (game_.music) audioplayer_.getMusic("skystrike").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 114;
                }
                if (mouseOver(mx, my, 450, 450, 50, 50)) {
                    levelid = 112;
                    System.out.println("world 112");

                    if (game_.music) audioplayer_.getMusic("starchaser").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 168;
                }
                if (mouseOver(mx, my, 550, 450, 50, 50)) {
                    levelid = 113;
                    System.out.println("world 113");

                    if (game_.music) audioplayer_.getMusic("a_newer_dawn").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 105;
                    endBar = 73;
                }
                // sixth row
                if (mouseOver(mx, my, 50, 550, 50, 50)) {
                    levelid = 114;
                    System.out.println("world 114");

                    if (game_.music) audioplayer_.getMusic("monody").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 107;
                    endBar = 128;
                }
                if (mouseOver(mx, my, 150, 550, 50, 50)) {
                    levelid = 115;
                    System.out.println("world 115");

                    if (game_.music) audioplayer_.getMusic("unity").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 105;
                    endBar = 105;
                }
                if (mouseOver(mx, my, 250, 550, 50, 50)) {
                    levelid = 116;
                    System.out.println("world 116");

                    if (game_.music) audioplayer_.getMusic("xenogenesis").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 145;
                    endBar = 140;
                }
                if (mouseOver(mx, my, 350, 550, 50, 50)) {
                    levelid = 117;
                    System.out.println("world 117");

                    if (game_.music) audioplayer_.getMusic("time_stops").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 160;
                    endBar = 177;
                }
                if (mouseOver(mx, my, 450, 550, 50, 50)) {
                    levelid = 118;
                    System.out.println("world 118");

                    if (game_.music) audioplayer_.getMusic("badland").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 154;
                }
                if (mouseOver(mx, my, 550, 550, 50, 50)) {
                    levelid = 119;
                    System.out.println("world 119");

                    if (game_.music) audioplayer_.getMusic("challenger").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 94;
                }
                // seventh row
                if (mouseOver(mx, my, 50, 650, 50, 50)) {
                    levelid = 120;
                    System.out.println("world 120");

                    if (game_.music) audioplayer_.getMusic("bluemoon").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 112.5;
                    endBar = 120;
                }
                if (mouseOver(mx, my, 150, 650, 50, 50)) {
                    levelid = 121;
                    System.out.println("world 121");

                    if (game_.music) audioplayer_.getMusic("cherry_blossoms").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 138;
                    endBar = 141;
                }
                if (mouseOver(mx, my, 250, 650, 50, 50)) {
                    levelid = 122;
                    System.out.println("world 122");

                    if (game_.music) audioplayer_.getMusic("walkman").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 102;
                }
                if (mouseOver(mx, my, 350, 650, 50, 50)) {
                    levelid = 123;
                    System.out.println("world 123");

                    if (game_.music) audioplayer_.getMusic("beyond_the_walls").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 148;
                }
                if (mouseOver(mx, my, 450, 650, 50, 50)) {
                    levelid = 124;
                    System.out.println("world 124");

                    if (game_.music) audioplayer_.getMusic("april").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 118;
                    endBar = 149;
                }
                if (mouseOver(mx, my, 550, 650, 50, 50)) {
                    levelid = 125;
                    System.out.println("world 125");

                    if (game_.music) audioplayer_.getMusic("sunlight").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 106;
                    endBar = 76;
                }
            }
            if (page == 4) {
                // first row
                if (mouseOver(mx, my, 50, 50, 50, 50)) {
                    levelid = 126;
                    System.out.println("world 126");

                    if (game_.music) audioplayer_.getMusic("cyptik_dance").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 120;
                    endBar = 50;
                }
                if (mouseOver(mx, my, 150, 50, 50, 50)) {
                    levelid = 127;
                    System.out.println("world 127");

                    if (game_.music) audioplayer_.getMusic("leaving_leafwood_forest").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 125;
                    endBar = 107;
                }
                if (mouseOver(mx, my, 250, 50, 50, 50)) {
                    levelid = 128;
                    System.out.println("world 128");

                    if (game_.music) audioplayer_.getMusic("troglodyte").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 134;
                    endBar = 150;
                }
                if (mouseOver(mx, my, 350, 50, 50, 50)) {
                    levelid = 129;
                    System.out.println("world 129");

                    if (game_.music) audioplayer_.getMusic("mayo").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 135;
                    endBar = 106;
                }
                if (mouseOver(mx, my, 450, 50, 50, 50)) {
                    levelid = 130;
                    System.out.println("world 130");

                    if (game_.music) audioplayer_.getMusic("starship_showdown").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 147;
                    endBar = 152;
                }
                if (mouseOver(mx, my, 550, 50, 50, 50)) {
                    levelid = 131;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("kumquat").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 100;
                    endBar = 75;
                }
                // second row
                if (mouseOver(mx, my, 50, 150, 50, 50)) {
                    levelid = 132;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("jaclyn").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 130;
                    endBar = 133;
                }
                if (mouseOver(mx, my, 150, 150, 50, 50)) {
                    levelid = 133;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("jacques").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 115;
                    endBar = 69;
                }
                if (mouseOver(mx, my, 250, 150, 50, 50)) {
                    levelid = 134;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("liftoff").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 148;
                }
                if (mouseOver(mx, my, 350, 150, 50, 50)) {
                    levelid = 135;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("never_be_alone").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 132;
                    endBar = 143;
                }
                if (mouseOver(mx, my, 450, 150, 50, 50)) {
                    levelid = 136;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("solitude").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 138;
                    endBar = 120;
                }
                if (mouseOver(mx, my, 550, 150, 50, 50)) {
                    levelid = 137;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("close_to_the_sun").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 89;
                    endBar = 71;
                }
                // third row
                if (mouseOver(mx, my, 50, 250, 50, 50)) {
                    levelid = 138;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("nanamori").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 122;
                }
                if (mouseOver(mx, my, 150, 250, 50, 50)) {
                    levelid = 139;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("fury").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 115;
                }
                if (mouseOver(mx, my, 250, 250, 50, 50)) {
                    levelid = 140;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("desu_ka").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 132;
                }
                if (mouseOver(mx, my, 350, 250, 50, 50)) {
                    levelid = 141;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("voices").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 75;
                    endBar = 85;
                }
                if (mouseOver(mx, my, 450, 250, 50, 50)) {
                    levelid = 142;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("dancing").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 75;
                    endBar = 59;
                }
                if (mouseOver(mx, my, 550, 250, 50, 50)) {
                    levelid = 143;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("shining_space").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 116;
                }
                // fourth row
                if (mouseOver(mx, my, 50, 350, 50, 50)) {
                    levelid = 144;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("space_invaders").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 188;
                }
                if (mouseOver(mx, my, 150, 350, 50, 50)) {
                    levelid = 145;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("drippy_dub").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 160;
                }
                if (mouseOver(mx, my, 250, 350, 50, 50)) {
                    levelid = 146;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("fake_princess").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 88;
                    endBar = 128;
                }
                if (mouseOver(mx, my, 350, 350, 50, 50)) {
                    levelid = 147;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("lazergun").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 116;
                }
                if (mouseOver(mx, my, 450, 350, 50, 50)) {
                    levelid = 148;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("afterimage").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 75;
                    endBar = 42;
                }
                if (mouseOver(mx, my, 550, 350, 50, 50)) {
                    levelid = 149;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("star_wars_remix").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 71.5;
                    endBar = 56;
                }
                // fifth row
                if (mouseOver(mx, my, 50, 450, 50, 50)) {
                    levelid = 150;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("kiss_me_kiss_you").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 98;
                }
                if (mouseOver(mx, my, 150, 450, 50, 50)) {
                    levelid = 151;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("enigma").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 125;
                    endBar = 123;
                }
                if (mouseOver(mx, my, 250, 450, 50, 50)) {
                    levelid = 152;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("never_make_it").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 114;
                    endBar = 111;
                }
                if (mouseOver(mx, my, 350, 450, 50, 50)) {
                    levelid = 153;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("flight").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 180;
                    endBar = 204;
                }
                if (mouseOver(mx, my, 450, 450, 50, 50)) {
                    levelid = 154;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("journey").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 130;
                    endBar = 114;
                }
                if (mouseOver(mx, my, 550, 450, 50, 50)) {
                    levelid = 155;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("lonley_forest").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 125;
                    endBar = 108;
                }
                // sixth row
                if (mouseOver(mx, my, 50, 550, 50, 50)) {
                    levelid = 156;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("pirate").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 130;
                }
                if (mouseOver(mx, my, 150, 550, 50, 50)) {
                    levelid = 157;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("aquamarine").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 128;
                }
                if (mouseOver(mx, my, 250, 550, 50, 50)) {
                    levelid = 158;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("boombox").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 153;
                }
                if (mouseOver(mx, my, 350, 550, 50, 50)) {
                    levelid = 159;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("niconico_dreams").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 75;
                    endBar = 48;
                }
                if (mouseOver(mx, my, 450, 550, 50, 50)) {
                    levelid = 160;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("requiem_dream").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 120;
                    endBar = 88;
                }
                if (mouseOver(mx, my, 550, 550, 50, 50)) {
                    levelid = 161;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("eurodancer").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 80;
                }
                // seventh row
                if (mouseOver(mx, my, 50, 650, 50, 50)) {
                    levelid = 162;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("hello").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 105;
                    endBar = 100;
                }
                if (mouseOver(mx, my, 150, 650, 50, 50)) {
                    levelid = 163;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("mayday").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 150;
                    endBar = 154;
                }
                if (mouseOver(mx, my, 250, 650, 50, 50)) {
                    levelid = 164;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("fireflies_remix").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 87;
                    endBar = 124;
                }
                if (mouseOver(mx, my, 350, 650, 50, 50)) {
                    levelid = 165;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("echolands").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 140;
                    endBar = 112;
                }
                if (mouseOver(mx, my, 450, 650, 50, 50)) {
                    levelid = 166;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("voiceless").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 128;
                    endBar = 139;
                }
                if (mouseOver(mx, my, 550, 650, 50, 50)) {
                    levelid = 167;
                    System.out.println("world " + levelid);

                    if (game_.music) audioplayer_.getMusic("vaporwave_aesthetics").loop();
                    // reset method
                    resetMethod();
                    // world misc
                    circlewithpatterns_.dvd = false;

                    bpm = 160;
                    endBar = 179;
                }
            }
        }
        // template
            /*if (mouseOver(mx, my, 50, 50, 50, 50)) {
                levelid = 0;
                System.out.println("world " + levelid);

                if (game_.music) audioplayer_.getMusic("null").loop();
                // reset method
                resetMethod();
                // world misc
                circlewithpatterns_.dvd = false;

                bpm = 0;
                endBar = 0;
            }*/
    }

    // this shit doesn't work, why? edit: now it works but unexpected happened.
    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (!game.isSelecting) hoverOnLevels(mx, my);
    }

    public void mouseReleased(MouseEvent e) {
        if (lazyDelayFix == 0) {
            if (game.gameState == game_.STATE.LevelSelect) {
                int mx = e.getX();
                int my = e.getY();

                if (page > 1) {
                    if (mouseOver(mx, my, 16, 366, 20, 20)) {
                        page--;
                        if (game_.music) audioplayer_.getSound("click_sound").play();
                    }
                }
                if (page < maxPage) {
                    if (mouseOver(mx, my, 616, 366, 20, 20)) {
                        page++;
                        if (game_.music) audioplayer_.getSound("click_sound").play();
                    }
                }
                for (int x = 50; x <= 550; x += 100) {
                    for (int y = 50; y <= 650 && lazyFixAgain == false; y += 100) {
                        if (x < mx && mx % 100 > 50) {
                            if (y < my && my % 100 > 50) {
                                if (game_.music) audioplayer_.getSound("click_sound").play();
                                lazyFixAgain = true;
                            }
                        }
                    }
                }
                // fix this
//                if (game_.music) audioplayer_.getSound("click_sound").play();
                lazyFixAgain = false;

                levelsList(mx, my);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (game.gameState == game_.STATE.LevelSelect) {
            if (!game.isSelecting) {
                switch (key) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        game.isSelecting = true;
                        handler.addObject(new CURSOR_SELECT(gridSelectX + 10, gridSelectY + 10, ID.CURSORSELECT));
                }
            }
            else {
                if (key == KeyEvent.VK_RIGHT) {
                    // if at prev
                    if (gridSelectX == 0)
                        gridSelectX = 50;
                    else if (gridSelectX < 550)
                        gridSelectX += 100;
                        // if you want to go to next
                    else if (page < maxPage) {
                        gridSelectX = 600;
                        gridSelectY = 350;
                    }
                }
                if (key == KeyEvent.VK_LEFT) {
                    // if at next
                    if (gridSelectX == 600)
                        gridSelectX -= 50;
                    else if (gridSelectX >= 150)
                        gridSelectX -= 100;
                        // if you want to go to prev
                    else if (page > 1) {
                        gridSelectX = 0;
                        gridSelectY = 350;
                    }
                }
                if (key == KeyEvent.VK_UP) {
                    if (!(gridSelectX == 0 && gridSelectY == 350)) {
                        if (!(gridSelectX == 600 && gridSelectY == 350)) {
                            if (gridSelectY >= 150)
                                gridSelectY -= 100;
                        }
                    }
                }
                if (key == KeyEvent.VK_DOWN) {
                    if (!(gridSelectX == 0 && gridSelectY == 350)) {
                        if (!(gridSelectX == 600 && gridSelectY == 350)) {
                            if (gridSelectY < 650)
                                gridSelectY += 100;
                        }
                    }
                }
                handler.removeAllSelectedObjects(ID.CURSORSELECT);
                handler.addObject(new CURSOR_SELECT(gridSelectX + 10, gridSelectY + 10, ID.CURSORSELECT));
                // run level
                if (key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_ENTER) {
                    if (key == KeyEvent.VK_ENTER) {
                        if (game.music) audioplayer_.getSound("click_sound").play();
                        if (gridSelectX == 0 && gridSelectY == 350 && page > 1){
                            page--;
                        } else if (gridSelectX == 600 && gridSelectY == 350 && page < maxPage){
                            page++;
                        } else {
                            gameobject_ tempObject = handler.getObject(ID.CURSORSELECT);
                            for (int x = 60; x <= 560 && tempObject != null; x += 100) {
                                for (int y = 60; y <= 660 && tempObject != null; y += 100) {
                                    game.isSelecting = false;
                                    if (tempObject.getBounds().intersects(x, y, 32, 32)) {
                                        levelsList(x, y);
                                    }
                                }
                            }
                            handler.removeAllSelectedObjects(ID.CURSORSELECT);
                        }
                    }
                    if (key == KeyEvent.VK_ESCAPE) {
                        handler.removeAllSelectedObjects(ID.CURSORSELECT);
                        game.isSelecting = false;
                    }
                }
            }
        }
    }

    // vars for gameloop fix
    public long lastTime = System.nanoTime();
    double amountOfTicks = 100.0;
    double ns = 1000000000 / amountOfTicks;
    public double delta = 0;

    public void tick() {
        if (lazyDelayFix != 0) lazyDelayFix--;

        // hover
        if (game.isSelecting && game.gameState == game_.STATE.LevelSelect)
            hoverOnLevels(gridSelectX + 30, gridSelectY + 30);

        if (game.loadstate == 100) {
            // THE GODDAMN GAMELOOP WORKS! still has issues at starting and pausing the tick
            // edit: starting a level works now so well, see gameloop fix at reset method, but pausing is still an issue
            // edit2: pausing now fixed, see gameloop fix at KeyInput VK_P
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                if (game.gameState == game_.STATE.GameBeta && bpm != 0 && endBar != 0) {
                    // THE LOGIC THAT MADE ME INSANE!, pls fix this if gameloop is noob
                    tpm = (60000 / bpm) / 10;
                    spm = tpm * 4 / 16;

                    if (levelid == 1) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        // beats
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;

                            if (handler.total_bars >= 2 && handler.total_bars != 25 && handler.total_bars != 42 && handler.total_bars != 43) {
                                handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH), 1, ID.Laser, handler, 30, 30, 0));
                            }

                            if (handler.total_bars >= 10 && handler.total_bars != 25 && handler.total_bars != 42 && handler.total_bars != 43) {
                                handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                        ID.HeartFriend, handler, 0, 0));
                                handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                        ID.BaseCircle, handler, 0, 0, 0));
                            }

                            if (handler.total_beats == 69 /*nice*/) {
                                handler.addObject(new ghost_(r.nextInt(game_.WIDTH - 1), r.nextInt(game_.HEIGHT - 1), ID.GHOST, 1, 1));
                                handler.addObject(new starwrathenemy_(0, 0, ID.STARGHOST, handler, 30, 30, 0));
                            }

                            if (handler.total_beats == 97) handler.removeObjectsExceptPlayers();

                            if (handler.total_bars == 25) {
                                crazyboss_.customRotateByTick = false;
                                // animation crazy boss
                                // frame one
                                if (handler.fourbarticks == 1) {
                                    System.out.println("frame one");
                                    handler.addObject(new crazyboss_(-128, 0, ID.CrazyBoss, handler, handler.goRight, handler.stay, 0));
                                }
                                // frame two
                                if (handler.fourbarticks == 2) {
                                    System.out.println("frame two");
                                    handler.removeAllSelectedObjects(ID.CrazyBoss);
                                    handler.addObject(new crazyboss_(game.WIDTH, 0, ID.CrazyBoss, handler, handler.goLeft, handler.stay, 0));
                                }
                                // frame three
                                if (handler.fourbarticks == 3) {
                                    System.out.println("frame three");
                                    handler.removeAllSelectedObjects(ID.CrazyBoss);
                                    handler.addObject(new crazyboss_(game.WIDTH / 2 - 128, -128, ID.CrazyBoss, handler, handler.stay, handler.goDown, 0));
                                }
                                // frame four
                                if (handler.fourbarticks == 4) {
                                    System.out.println("frame four");
                                    handler.removeAllSelectedObjects(ID.CrazyBoss);
                                    handler.addObject(new crazyboss_(game.WIDTH / 2 - 128, game_.HEIGHT, ID.CrazyBoss, handler, handler.stay, handler.goUp, 0));
                                }
                            }

                            if (handler.total_beats == 101) {
                                handler.removeAllSelectedObjects(ID.CrazyBoss);
                                handler.addObject(new crazyboss_(game_.WIDTH / 2 - 128, 0, ID.CrazyBoss, handler, 0, 0, 0));
                            }

                            if (handler.total_beats >= 101) {
                                // run this code once
                                crazyboss_.customRotateByTick = true;
                                crazyboss_.minRotate = -45;
                                crazyboss_.maxRotate = 45;
                                crazyboss_.rotateThisTick = 20;
                                // run this code once the tick was called
                                if (crazyboss_.increment) crazyboss_.increment = false;
                                else crazyboss_.increment = true;
                            }

                            if (handler.total_bars == 42 || handler.total_bars == 43) {
                                // rest
                                handler.removeObjectsExceptPlayers();
                            }
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 84
                    if (levelid == 2) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new laserpointer_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.Laser, handler, 30, 30, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 130
                    if (levelid == 3) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 144
                    if (levelid == 4) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 106
                    if (levelid == 5) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 122
                    if (levelid == 6) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 102
                    if (levelid == 7) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 88
                    if (levelid == 8) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 110
                    if (levelid == 9) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 90
                    if (levelid == 10) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 94
                    if (levelid == 11) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 139
                    if (levelid == 12) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 72
                    if (levelid == 13) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 73
                    if (levelid == 14) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 179
                    if (levelid == 15) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 66
                    if (levelid == 16) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 113
                    if (levelid == 17) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 218
                    if (levelid == 18) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 125
                    if (levelid == 19) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 30
                    if (levelid == 20) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 138
                    if (levelid == 21) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 66
                    if (levelid == 22) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 66
                    if (levelid == 23) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    } // 31
                    // new code
                    if (levelid >= 24) {
                        // spawn code
                        scoreKeep++;
                        scoreKeepStep++;
                        if (scoreKeep >= tpm) {
                            if (metronome) handler.metronomeCode();
                            difference = scoreKeep - tpm;
                            scoreKeep = difference;
                            handler.addObject(new heart_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.HeartFriend, handler, 0, 0));
                            handler.addObject(new basecircle_(r.nextInt(game_.WIDTH - 10), r.nextInt(game_.HEIGHT - 10),
                                    ID.BaseCircle, handler, 0, 0, 0));
                        }
                        // steps
                        if (scoreKeepStep >= spm) {
                            handler.stepsBeta();
                            stepDifference = scoreKeepStep - spm;
                            scoreKeepStep = stepDifference;
                        }
                        // end code
                        endCode();
                    }

                    // duration bar
                    double formulaForDuration = ((double) handler.total_steps / ((double) endBar * 16 - 15)) * 100;
                    durationBar = formulaForDuration;
                    durationValue = (int) durationBar * 2;
                    durationValue = game.clamp(durationValue, 0, 255);
                }
                delta--;
            }
        }
    }

    public void render(Graphics g) {
        if (game.gameState == game_.STATE.LevelSelect) {
            g.setColor(Color.green);
            g.drawString(testString, 0, 40);
            g.drawString("Page: " + page, game.WIDTH - 70, 38);
            // prev and next
            if (page > 1) g.drawRect(16, 366, 20, 20);
            if (page < maxPage) g.drawRect(616, 366, 20, 20);

            g.drawRect(50, 50, 50, 50);
            g.drawRect(150, 50, 50, 50);
            g.drawRect(250, 50, 50, 50);
            g.drawRect(350, 50, 50, 50);
            g.drawRect(450, 50, 50, 50);
            g.drawRect(550, 50, 50, 50);
            // second row
            g.drawRect(50, 150, 50, 50);
            g.drawRect(150, 150, 50, 50);
            g.drawRect(250, 150, 50, 50);
            g.drawRect(350, 150, 50, 50);
            g.drawRect(450, 150, 50, 50);
            g.drawRect(550, 150, 50, 50);
            // third row
            g.drawRect(50, 250, 50, 50);
            g.drawRect(150, 250, 50, 50);
            g.drawRect(250, 250, 50, 50);
            g.drawRect(350, 250, 50, 50);
            g.drawRect(450, 250, 50, 50);
            g.drawRect(550, 250, 50, 50);
            // forth row
            g.drawRect(50, 350, 50, 50);
            g.drawRect(150, 350, 50, 50);
            g.drawRect(250, 350, 50, 50);
            g.drawRect(350, 350, 50, 50);
            g.drawRect(450, 350, 50, 50);
            g.drawRect(550, 350, 50, 50);
            // fifth row
            g.drawRect(50, 450, 50, 50);
            g.drawRect(150, 450, 50, 50);
            g.drawRect(250, 450, 50, 50);
            g.drawRect(350, 450, 50, 50);
            g.drawRect(450, 450, 50, 50);
            g.drawRect(550, 450, 50, 50);
            // sixth row
            g.drawRect(50, 550, 50, 50);
            g.drawRect(150, 550, 50, 50);
            g.drawRect(250, 550, 50, 50);
            g.drawRect(350, 550, 50, 50);
            g.drawRect(450, 550, 50, 50);
            g.drawRect(550, 550, 50, 50);
            // seventh row
            g.drawRect(50, 650, 50, 50);
            g.drawRect(150, 650, 50, 50);
            g.drawRect(250, 650, 50, 50);
            g.drawRect(350, 650, 50, 50);
            g.drawRect(450, 650, 50, 50);
            g.drawRect(550, 650, 50, 50);
        }
        // my monstrosity
        if (game.gameState == game_.STATE.GameBeta && !game.hideHud) {
            g.drawString("Level ID: " + levelid + ", BPm: " + bpm + ", End (Bar): " + endBar, game.WIDTH - 300, 15);
            g.drawString("BPm: " + (float)(60000/(tpm * 10)) + ", Bar: " + handler.total_bars + ", Beats: " + handler.total_beats + ", Beat: " + handler.fourbarticks, game.WIDTH - 300, 64);
            g.drawString("Difference (Beats): " + difference, game.WIDTH - 300, 80);
            g.drawString("SPm: " + (float)(60000/(spm * 10)) + ", Bar: " + handler.total_bars_steps + ", Steps: " + handler.total_steps + ", Step: " + handler.fourbarsteps, game.WIDTH - 300, 96);
            g.drawString("Difference (Steps): " + stepDifference, game.WIDTH - 300, 112);
            // duration bar
            g.setColor(new Color(75, durationValue, 0));
            g.fillRect(game.WIDTH - 300, 18, (int) durationBar * 2, 32);
            g.setColor(Color.green);
            g.drawRect(game.WIDTH - 300, 18, 200, 32);
            g.drawString((int)durationBar + "%", game.WIDTH - 64, 38);
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }
    
    public void resetMethod() {
        // reset
        game.gameState = game_.STATE.GameBeta;
        hud.resetTimer();
        handler.clearEnemies();
        hud.setLevel(1);
        scoreKeep = 0;
        scoreKeepStep = 0;
        // p1 reset
        hud.setScore(0);
        hud.setXp(0);
        hud_.HEALTH = 100;
        handler_.spdp1 = 5;
        hud_.bounds = 0;
        hud.heartsTaken = 0;
        // p2 reset
        hud2.setScore(0);
        hud2.setXp(0);
        hud2_.HEALTH = 100;
        handler_.spdp2 = 5;
        hud2_.bounds = 0;
        hud2.heartsTaken = 0;
        // reset music
        handler.total_bars = 1;
        handler.total_beats = 1;
        handler.fourbarticks = 1;

        handler.total_bars_steps = 1;
        handler.total_steps = 1;
        handler.fourbarsteps = 1;
        // gameloop fix
        lastTime = System.nanoTime();
        delta = 0;
    }

    private void endCode() {
        // end code
        if (handler.total_bars == endBar) {
            if (game_.music) audioplayer_.getSound("win_1").play();
            if (game_.music) audioplayer_.getMusic(audioplayer_.currentMusic).pause();
            game.gameState = game_.STATE.End;
            handler.clearEnemies();
            if (game.customTicksBoolean) game.customTicksMethod();
            else {
                for (int i = 1; i <= 50; i++)
                    handler.addObject(new spicymenu_(r.nextInt(game.WIDTH - 1), r.nextInt(game.HEIGHT - 1), ID.Spicy, handler));
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.gameState == game_.STATE.GameBeta){
            System.out.println("action triggered");
        }
    }
}
