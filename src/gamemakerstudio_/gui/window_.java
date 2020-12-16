/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.gui;
import gamemakerstudio_.game_;
import gamemakerstudio_.misc.handler_;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author ACER
 */
public class window_ extends WindowAdapter implements KeyListener {
    handler_ handler;
    game_ game;

    static Random r = new Random();
    int randomLimit = 350;
    int randIntFormula = r.nextInt(randomLimit) + 1;
    int randInt = 112 /*randIntFormula*/;
    boolean obfuscated = false;
    int obfuscatedChance = r.nextInt(100) + 1;
    public JFrame frame = new JFrame();

    public window_ (int width, int height, String title, game_ game, handler_ handler) {
        if (obfuscatedChance == 1) obfuscated = true;

        this.handler = handler;
        this.game = game;

        game.addKeyListener(this);

        // window shenanigans
        ImageIcon icon = new ImageIcon("resources_/image_/icon remastered.png");

        frame.addWindowListener(this);
        
        frame.setPreferredSize(new Dimension(width + 16, height + 39));
        frame.setMaximumSize(new Dimension(width + 16, height + 39));
        frame.setMinimumSize(new Dimension(width + 16, height + 39));
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());

        game.start();
    }
    public void windowClosing(WindowEvent e) {
        if (game_.JOptionPaneOption) {
            int a = JOptionPane.showConfirmDialog(frame, "Are you sure?", "Quit", JOptionPane.INFORMATION_MESSAGE);
            if (a == JOptionPane.YES_OPTION) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void tick() {
        randIntFormula = r.nextInt(randomLimit) + 1;
        frame.setTitle("CUBESHOTS: " + randomSplash());
    }

    public String randomSplash() {
        if (obfuscated) randInt = randIntFormula;
        switch (randInt) {
            case 1:
                return "That's a lot of DAMAGE!";
            case 2:
                return "Squirrels in my Pants";
            case 3:
                return "Dumb Kids Edition";
            case 4:
                return "Say the magic word";
            case 5:
                return "Do you even lift, bro?";
            case 6:
                return "Shotgun King 2077";
            case 7:
                return "Cool Stuff";
            case 8:
                return "NullPointerException";
            case 9:
                return "Controller not included";
            case 10:
                return "Ok boomer";
            case 11:
                return "Sup guys, we did it!";
            case 12:
                return "Getting shot at the back";
            case 13:
                return "Big Bear Theory";
            case 14:
                return "Powered by Java";
            case 15:
                return "<PewDiePie's Minecraft Seed>"; // 609567216262790763
            case 16:
                return "<Minecraft's Title Screen Seed>"; // 2151901553968352745 OR 8091867987493326313
            case 17:
                return "<pack.png Minecraft Seed>";
            case 18:
                return "<minecraft seed 0>"; // jump to line 302 for more
            case 19:
                return "wubba lubba dub dub";
            case 20:
                return "Not to be confused with \"Just Shapes and Beats\"";
            case 21:
                return "Not to be confused with \"Touhou Project\"";
            case 22:
                return "Not to be confused with \"GALAGA\"";
            case 23:
                return "matpat's holy number";
            case 24:
                return "Not to be confused with \"Space Invaders\"";
            case 25:
                return "gg terraria";
            case 26:
                return "let's port pac-man multiplayer";
            case 27:
                return "copyright public domain";
            case 28:
                return "polar coordinate system";
            case 29:
                return "tu tu tu turn it up!";
            case 30:
                return "sine, cosine, and tangent";
            case 31:
                return "pi, radius, and theta";
            case 32:
                return "rectangular vs. polar";
            case 33:
                return "v in -v- is mouth?";
            case 34:
                return "you have been distracted";
            case 35:
                return "pickle rick!";
            case 36:
                return "Why Is EVERYONE Singing Baka Mitai?";
            case 37:
                return "the cake is a lie";
            case 38:
                return "Understandable, Have A Nice Day";
            case 39:
                return "yo, it's him!";
            case 40:
                return "are you winning, son?";
            case 41:
                return "coffin dance";
            case 42:
                return "this game has " + handler.object.size() + " objects!";
            case 43:
                return "a man has fallen into the river in lego city";
            case 44:
                return "[removed]";
            case 45:
                return "joe mama";
            case 46:
                return "stonks";
            case 47:
                return "FBI OPEN UP!";
            case 48:
                return "doge and cheems and walter";
            case 49:
                return "i like fire trucks and moster trucks";
            case 50:
                return "kenos npestaposting";
            case 51:
                return "A E S T H E T I C";
            case 52:
                return "have you send it to robtop yet?";
            case 53:
                return "E";
            case 54:
                return "can i get uhhhh, lamp";
            case 55:
                return "sj8Sg8qnjOg";
            case 56:
                return "dQw4w9WgXcQ";
            case 57:
                return "UCrHkYaEEXKoK57GAwyC5JTg";
            case 58:
                return "The Mandelbrot Set";
            case 59:
                return "fibonacci sequence";
            case 60:
                return "did it work?";
            case 61:
                return "never tell the odds!";
            case 62:
                return "r/gamephysics";
            case 63:
                return "V A P O R W A V E";
            case 64:
                return "this game is running at " + game_.throwframes + " fps!";
            case 65:
                return "click the ghost and see the magic";
            case 66:
                return "r/woosh";
            case 67:
                return "p2 is green, p1 is blue";
            case 68:
                return "up up down down left right left right b a start";
            case 69:
                return "nice";
            case 70:
                return "espionage";
            case 71:
                return "i built a level";
            case 72:
                return "stinky brainer";
            case 73:
                return "rip windows 7";
            case 74:
                return "rip adobe flash";
            case 75:
                return "also try geometry dash";
            case 76:
                return "also try minecraft";
            case 77:
                return "also try terraria";
            case 78:
                return "also try super meat boy";
            case 79:
                return "also try electronic super joy";
            case 80:
                return "also try among us";
            case 81:
                return "also try bombsquad";
            case 82:
                return "also try cuphead";
            case 83:
                return "also try cave story";
            case 84:
                return "also try stick fight: the game";
            case 85:
                return "what, you never played tuber simulator?";
            case 86:
                return "hey, that's pretty good";
            case 87:
                return "when there's smoke, there's fire";
            case 88:
                return "the golden ratio";
            case 89:
                return "the pentomino puzzle";
            case 90:
                return "the silver ratio, and how to cut your nails";
            case 91:
                return "Turn Your Face Into a Troll Face!";
            case 92:
                return "deepfaked";
            case 93:
                return "the power";
            case 94:
                return "DO NOT OPEN!";
            case 95:
                return "damn son, where'd you find this?";
            case 96:
                return "java -jar Geyser.jar";
            case 97:
                return "Random r = new Random();";
            case 98:
                return "Telltale Games is Back!";
            case 99:
                return "rip digital chocolate";
            case 100:
                return "making you insane since 2020";
            case 101:
                return "unintelligible";
            case 102:
                return "also try the henry stickmin collection";
            case 103:
                return "there are 4 impostors among us";
            case 104:
                return "rip unnamed rpg game";
            case 105:
                return "poorgrammer for $25";
            case 106:
                return "what the hell was a git/vcs?";
            case 107:
                return "github.com/GDjkhp/CUBESHOTS";
            case 108:
                return "terraria otherworld confirmed?";
            case 109:
                return "thanks for a free copy of minecraft windows 10 edition!";
            case 110:
                return "UwU";
            case 111:
                return "wanted: PROgrammer";
            case 112:
                return String.valueOf(game.gameState);
            case 113:
                return "[YTP]";
            case 114:
                return "opie, boogie, kaki, edgar, maya";
            case 115:
                return String.valueOf(randIntFormula);
            case 116:
                return "Dank Room Soup.avi";
            case 117:
                return "includes anti-piracy measures, although it's free";
            case 118:
                return "-_-";
            case 119:
                return "VR Edition";
            case 120:
                return "morty manipulator chip included";
            case 121:
                return "¯\\_(ツ)_/¯";
            case 122:
                return "( ͡° ͜ʖ ͡°)";
            case 123:
                return "are dragons reptiles?";
            case 124:
                return "loops vs. recursion";
            case 125:
                return "he was like a father to me";
            case 126:
                return "pufferfish eating carrot";
            case 127:
                return "i like turtles";
            case 128:
                return "can't believe you done this";
            case 129:
                return "don't kill monsters, you dolphin!";
            case 130:
                return "place a block above the turtle eggs to prevent it from stepping by someone. pls help me";
            case 131:
                return "newton's 4th law";
            case 132:
                return "when will the bass drop";
            case 133:
                return "segmentation fault";
            case 134:
                return "???";
            case 135:
                return "i'll have two number nines";
            case 136:
                return "the waiting game";
            case 137:
                return "police line do not cross";
            case 138:
                return "pulp fiction burger reference #1";
            case 139:
                return "pulp fiction burger reference #2";
            case 140:
                return "searching for digital chocolate's forgotten pc games";
            case 141:
                return "there are 3 impostors among us";
            case 142:
                return "perfectly unbalanced game";
            case 143:
                return "why do you still play these, ily";
            case 144:
                return "i ate everyone";
            case 145:
                return "the blues";
            case 146:
                return "this is not a minecraft skin, silly";
            case 147:
                return "are you still there?";
            case 148:
                return "there you are";
            case 149:
                return "lol is lol backwards, alright i'mma stop now";
            case 150:
                return "i did not hit her";
            case 151:
                return "music used was copyright by it's owners, i think";
            case 152:
                return "robtop, pls send me newgrounds api for music";
            case 153:
                return "GOTY Edition";
            case 154:
                return "made by everyone just for you";
            case 155:
                return "there is a game which doesn't exist";
            case 156:
                return "this game suck";
            case 157:
                return "creating music was harder than i thought";
            case 158:
                return "i hate this place";
            case 159:
                return "i hate everything";
            case 160:
                return "raster vs. vector";
            case 162:
                return "can't install unity due to storage capacity problems";
            case 163:
                return "@Override is optional, i think";
            case 164:
                return "press f4 to go to setup";
            case 165:
                return "press f13 to reveal a secret";
            case 166:
                return "Face Reveal at 100 mil subs";
            case 167:
                return "imagine scrolling this far just to find this";
            case 168:
                return "google collab helped me out";
            case 169:
                return "0w0";
            case 170:
                return "how's it going bros";
            case 171:
                return "top of the morning";
            case 172:
                return "android version soon";
            case 173:
                return "marquee tag";
            case 174:
                return "tinnitus";
            case 175:
                return "nocebo effect";
            case 176:
                return "nothing, and me, nothing, nothing, no more";
            case 177:
                return "libgdx ported this game to android";
            case 178:
                return "send conway's game of life patterns";
            case 179:
                return "2.2 when";
            case 180:
                return "impossible";
            case 181:
                return "stop it, get some help";
            case 182:
                return "there is no splash";
            case 183:
                return "solves the halting problem using the famous turing machine";
            case 184:
                return "I've gotta take a little time";
            case 185:
                return "pet the crewmate";
            case 186:
                return "missingno included";
            case 187:
                return "vs. the world";
            case 188:
                return "vs. the forces of evil";
            case 189:
                return "too many damn chores";
            case 190:
                return "use cotton as clouds";
            case 191:
                return "so it's about this scientist named rick";
            case 192:
                return "the kee games quiz show font released!";
            case 193:
                return "you had a goal, but not that many";
            case 194:
                return "load multiplier included";
            case 195:
                return "transparency destroyed my pc";
            case 196:
                return "a hungry programmer takes mega bytes";
            case 197:
                return "circle of fifths";
            case 198:
                return "storming area 51 since 2019";
            case 199:
                return "coincidence? i think not";
            case 200:
                return "baby fights";
            case 201:
                return "you're a good kid franklin";
            case 202:
                return "felix, the meme lord behind youtube";
            case 203:
                return "i can't be touched";
            case 204:
                return "don't blame me, blame your side";
            case 205:
                return "ninja cops";
            case 206:
                return "what just happened?";
            case 207:
                return "just as planned";
            case 208:
                return "thread ripper";
            case 209:
                return "render (Graphics g)";
            case 210:
                return "render (SpriteBatch sb)";
            case 211:
                return "better than reality";
            case 212:
                return "future funk";
            case 213:
                return "don't vote on seven";
            case 214:
                return "define angles first";
            case 215:
                return "follow the angle's pattern";
            case 216:
                return "inducegamecrashforrealz";
            case 217:
                return "hacking the game since 2015";
            case 218:
                return "titanium hwhite";
            case 219:
                return "son of a gun";
            case 220:
                return "sign that rascal";
            case 221:
                return "keep yourself distracted";
            case 222:
                return "cute aggression";
            case 223:
                return "please don't sue";
            case 224:
                return "thank you";
            case 225:
                return "auto tune and it's finest";
            case 226:
                return "also try carrion";
            case 227:
                return "also try kindergarten";
            case 228:
                return "under pressure";
            case 229:
                return "now you can eat sunlight";
            case 230:
                return ":/";
            case 231:
                return "UwU";
            case 232:
                return "31337 H4X0R";
            case 233:
                return "string encryption";
            case 234:
                return "laser polygon";
            case 235:
                return "upload barah bonaks";
            case 236:
                return "secret tunnel";
            case 237:
                return "for dummies";
            case 238:
                return "pop the cherry"; // illegal
            case 239:
                return "hail santa";
            case 240:
                return "fruit snake";
            case 241:
                return "I.T. hertz WAN I.P.";
            case 242:
                return "Pong Lenis";
            case 243:
                return "why did the chicken cross the road?";
            case 244:
                return "PC Master Race";
            case 245:
                return "you've watched too much TV";
            case 246:
                return "enlarge your... MEMORY!";
            case 247:
                return "digital works has no value";
            case 248:
                return "pass out the sauce";
            case 249:
                return "aye";
            case 250:
                return "i got a laptop in my backpack";
            case 251:
                return "when the moon shines";
            case 252:
                return "if (playing && thenLooped) {go back to start}";
            case 253:
                return "quality of life";
            case 254:
                return "I'M BACK AT MP3 WORLD!";
            case 255:
                return "WhHAt'S YoOuUurR FfaAvVoOrRiItTeE bBlLoOcCKk IinN mMiInNeEcCrRaAfFtT?¿";
            case 256:
                return "Don’t = do not, Won’t = wo not ";
            case 257:
                return "lord gaben take my money";
            case 258:
                return "im'ma end this man's whole career";
            case 259:
                return "glasses, jacket, shirt";
            case 260:
                return "always has been";
            case 261:
                return "sike that's the wrong number";
            case 262:
                return "save all unsaved posts";
            case 263:
                return "force multiplier";
            case 264:
                return "ma boi";
            case 265:
                return "excuse me, princess";
            case 266:
                return "hit 'em in the pancreas";
            case 267:
                return "check out the closed instruction book";
            case 268:
                return "the koopalings and i have taken over the mushroom kingdom";
            case 269:
                return "too many toasters";
            case 270:
                return "i hope she made lotta spaghetti";
            case 271:
                return "all toasters toast toast";
            case 272:
                return "you bring a light?";
            case 273:
                return "i'm your biggest fan";
            case 274:
                return "hey you, get out of my cloud";
            case 275:
                return "it's been one of those days";
            case 276:
                return "you're the best player, ever";
            case 277:
                return "random boss battles"; // pewds video
            case 278:
                return "that's enough for me";
            case 279:
                return "this is a placeholder text";
            case 280:
                return "this is a placeholder option";
            case 281:
                return "roshambo edition";
            case 282:
                return "what happened to Unus Annus?";
            case 283:
                return "momento mori";
            case 284:
                return "includes navier stokes equations";
            case 285:
                return "perlin noise";
            case 286:
                return "sorting algorithm";
            case 287:
                return "greedy algorithm";
            case 288:
                return "arithmetic algorithm";
            case 289:
                return "shift+click selects an interval";
            case 290:
                return "electric boogaloo";
            case 291:
                return "OH SHUT UP!"; // ksi among us random wheel video
            case 292:
                return "moist";
            case 293:
                return "dundundududundudundudun";
            case 294:
                return "for lease navidad";
            case 295:
                return "kids see ghosts";
            case 296:
                return "God wants 20%";
            case 297:
                return "God helped me";
            case 298:
                return "you are an idiot :)";
            case 299:
                return "after egypt";
            case 300:
                return "sorry quillton :(";
            case 301:
                return "really punish";
            case 302:
                return "<herobrine minecraft seed>";
            case 303:
                return "<skull painting seed>";
            case 304:
                return "HELL NO! HELL NO!";
            case 305:
                return "haters are my motivators";
            case 306:
                return "objects in the window are closer than they appear";
            case 307:
                return "keeping it cool";
            case 308:
                return "another fender bender";
            case 309:
                return "the quick brown fox jumps over the lazy dog";
            case 310:
                return "F";
            case 311:
                return "60, 75, 80, 100, 120, 125, 150, 200"; // limited bpm
            case 312:
                return "player then range";
            case 313:
                return "next time on the house of cosbys";
            case 314:
                return "NaN (Not a Number) makes the player go outside the box or pops out of existence";
            case 315:
                return "the future so bright, we gonna wear shades";
            case 316:
                return "i don't wanna ruin the surprise";
            case 317:
                return "9999 ties in a row";
            case 318:
                return "zombie sized chickens";
            case 319:
                return "chicken sized zombies";
            case 320:
                return "lag spike of death";
            case 321:
                return "fool me once, shame on you, fool me twice, i punch your face";
            case 322:
                return "jinx";
            case 323:
                return "#POTATO451";
            case 324:
                return "127142";
            case 325:
                return "acoustic fingerprinting and query by humming";
            case 326:
                return "if not ok then return end";
            case 327:
                return "B R E A T H T A K I N G";
            case 328:
                return "";
            case 329:
                return "";
            case 330:
                return "";
            case 331:
                return "";
            case 332:
                return "";
            case 333:
                return "";
            case 334:
                return "";
            case 335:
                return "";
            case 336:
                return "";
            case 337:
                return "";
            case 338:
                return "";
            case 339:
                return "";
            case 340:
                return "";
            case 341:
                return "";
            case 342:
                return "";
            case 343:
                return "";
            case 344:
                return "";
            case 345:
                return "";
            case 346:
                return "";
            case 347:
                return "";
            case 348:
                return "";
            case 349:
                return "";
            case 350:
                return "";
            case 351:
                return "";
            case 352:
                return "";
            case 353:
                return "";
            case 354:
                return "";
            case 355:
                return "";
            case 356:
                return "";
            case 357:
                return "";
            case 358:
                return "";
            case 359:
                return "";

            default:
                return "";
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_F4) randInt = randIntFormula;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}
}
