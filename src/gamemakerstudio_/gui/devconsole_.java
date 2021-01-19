package gamemakerstudio_.gui;

import gamemakerstudio_.entities.*;
import gamemakerstudio_.entities.experimental.*;
import gamemakerstudio_.game_;
import gamemakerstudio_.misc.FACE;
import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.audioplayer_;
import gamemakerstudio_.misc.handler_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.*;

public class devconsole_ extends JFrame implements ActionListener, KeyListener {
    // random
    Random r = new Random();
    // classes
    game_ game;
    handler_ handler;
    hud_ hud;
    hud2_ hud2;
    // temp text
    String latest;
    String old;
    String oldest;
    // Js used
    JPanel panel;
    JLabel history_text1, history_text2, history_text3;
    JTextField console_text = new JTextField();
    JButton submit = new JButton("SUBMIT");
//        JScrollPane scrollPane = new JScrollPane();
    public devconsole_ (game_ game, handler_ handler, hud_ hud, hud2_ hud2) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        this.hud2 = hud2;

        // history (disposes after 3, might fix later)
        history_text1 = new JLabel();
        history_text2 = new JLabel();
        history_text3 = new JLabel();

        // set panels
        panel = new JPanel(new GridLayout(5, 0));
        panel.add(history_text3);
        panel.add(history_text2);
        panel.add(history_text1);
        panel.add(console_text);
        panel.add(submit);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
        console_text.addKeyListener(this);
        add(panel);
        setTitle("Developer Console");
        setSize(500,200);
    }
    // important stuff
    public void performCommands() {
        // time
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        // try to parse
        String keyBuffer = console_text.getText();
        String[] list = keyBuffer.split("\\s+");
        ArrayList<String> tokens = new ArrayList<String>();
        for (int i = 0; i < list.length; i++){
            tokens.add(list[i]);
        }
        try {
            // your custom codes here
            // token 0 == command
            // token 1, 2, 3, ... == arg (start at 1)
            switch (tokens.get(0)) {
                case "spawn":
                    if (tokens.size() == 2){
                        tokens.add(String.valueOf(r.nextInt(game.WIDTH)));
                        tokens.add(String.valueOf(r.nextInt(game.HEIGHT)));
                        tokens.add(String.valueOf(r.nextInt(50)));
                        tokens.add(String.valueOf(r.nextInt(50)));
                        tokens.add(String.valueOf(r.nextInt(10)));
                    }
                    if(summonEntity(tokens.get(1), Float.parseFloat(tokens.get(2)), Float.parseFloat(tokens.get(3)),
                            Float.parseFloat(tokens.get(4)), Float.parseFloat(tokens.get(5)), Float.parseFloat(tokens.get(6))))
                        updateConsole(now + ": Spawned " + tokens.get(1) + " at " + tokens.get(2) + ", " + tokens.get(3));
                    else
                        updateConsole("Syntax error: " + tokens.get(1) + " is not a valid entity!");
                    break;
                case "kill":
                    if(removeEntities(tokens.get(1)))
                        updateConsole(now + ": Killed " + tokens.get(1));
                    else
                        updateConsole("Syntax error: " + tokens.get(1) + " is not a valid entity!");
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "ldm":
                    if (game.ldm) game.ldm = false;
                    else game.ldm = true;
                    updateConsole(now + ": LDM " + game.ldm);
                    break;
                case "god":
                    if (game.isInvincible) game.isInvincible = false;
                    else game.isInvincible = true;
                    updateConsole(now + ": GOD " + game.isInvincible);
                    break;
                case "sound":
                    if (game_.music) {
                        game_.music = false;
                        audioplayer_.getSound("null").play();
                        audioplayer_.getMusic("null").play(); // library change error
                    }
                    else {
                        game_.music = true;
                        audioplayer_.getMusic("music").loop(); // library change error
                    }
                    updateConsole(now + ": Sound " + game.music);
                    break;
                case "ai":
                    if (tokens.get(1).equals("p1")) {
                        if (game.computerP1) game.computerP1 = false;
                        else game.computerP1 = true;
                        updateConsole(now + ": P1 AI " + game.computerP1);
                    } else if (tokens.get(1).equals("p2")) {
                        if (game.computerP2) game.computerP2 = false;
                        else game.computerP2 = true;
                        updateConsole(now + ": P2 AI " + game.computerP2);
                    } else {
                        updateConsole("Syntax error: " + tokens.get(1) + " is not a valid player!");
                        updateConsole("Usage: ai [p1 | p2]");
                    }
                    break;
                default:
                    updateConsole("Syntax error: " + tokens.get(0) + " is not a valid command!");
                    break;
            }
        } catch (Exception exception) {
            updateConsole("Syntax error: " + exception);
            exception.printStackTrace();
        }
    }
    public boolean summonEntity (String tempObject, float x, float y, float velX, float velY, float spawnTimer) {
        switch (tempObject) {
            // entity classes
            case "basicenemy_":
                handler.addObject(new basicenemy_((int)x, (int)y, ID.BasicEnemy, handler));
                return true;
            case "fastenemy_":
                handler.addObject(new fastenemy_((int)x, (int)y, ID.FastEnemy, handler));
                return true;
            case "hardenemy_":
                handler.addObject(new hardenemy_((int)x, (int)y, ID.HardEnemy, handler));
                return true;
            case "smartenemy_":
                handler.addObject(new smartenemy_((int)x, (int)y, ID.SmartEnemy, handler, 3, 3));
                return true;
            case "basecircle_":
                handler.addObject(new basecircle_((int)x, (int)y, ID.BaseCircle, handler, velX, velY, (int)spawnTimer));
                return true;
            case "bullethellgenerator_":
                // spawn bullethellgenerator_ 300 300 0 0 0
                handler.addObject(new bullethellgenerator_(x, y, ID.BULLETHELLGHOST, handler, game, (int)spawnTimer,
                        1, 1, 0, 0, 0, false,
                        false));
                return true;
            case "triangleshooter_":
                // spawn triangleshooter_ 300 300 0 0 50
                handler.addObject(new triangleshooter_(x, y, ID.TriangleShooter, handler, velX, velY, (int)spawnTimer, FACE.EAST));
                return true;
                // misc
            // spawn water_ 0 0 0 0 0
            case "water_":
                handler.addObject(new water_(x, y, ID.NULL));
                return true;
            case "tictactoe_":
                handler.addObject(new tictactoe_(x, y, ID.NULL, game));
                return true;
            // spawn pathfinder_ 0 0 0 0 0
            case "pathfinder_":
                handler.addObject(new pathfinder_(x, y, ID.NULL, game));
                return true;
                // spawn conwaysgameoflife_ 0 0 0 0 0
            case "conwaysgameoflife_":
                handler.addObject(new conwaysgameoflife_(x, y, ID.NULL, game));
                return true;
            // spawn moresmarterenemy_ 0 0 0 0 0
            case "moresmarterenemy_":
                handler.addObject(new moresmarterenemy_(x, y, ID.MoreSmarter, handler, 20, 20));
                return true;
            case "osc_":
                handler.addObject(new osc_(x, y, ID.NULL));
                return true;
            default:
                return false;
        }
    }
    public boolean removeEntities (String tempObjectID) {
        switch (tempObjectID) {
            // kill code that suck, and more detailed
            case "basicenemy_":
                handler.removeAllSelectedObjects(ID.BasicEnemy);
                return true;
            case "fastenemy_":
                handler.removeAllSelectedObjects(ID.FastEnemy);
                return true;
            case "hardenemy_":
                handler.removeAllSelectedObjects(ID.HardEnemy);
                return true;
                // kill all
            case "all":
                handler.clearEnemies();
                // to kill players, use this instead
                hud.HEALTH = 0;
                hud2.HEALTH = 0;
                return true;
            case "player_":
                hud.HEALTH = 0;
                return true;
            case "player2_":
                hud2.HEALTH = 0;
                return true;
            case "enemies_":
                handler.removeObjectsExceptPlayers();
                return true;
            default:
                return false;
        }
    }
    // info and fixes, quality of life
    public void keyReleased (KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            performCommands();
        }
        if (key == KeyEvent.VK_ESCAPE || key == 192) {
            this.dispose();
        }
    }
    public void actionPerformed(ActionEvent e) {
        performCommands();
    }
    public void swapHistory(){
        oldest = old;
        old = latest;
    }
    public void setText() {
        history_text3.setText(oldest);
        history_text2.setText(old);
        history_text1.setText(latest);
    }
    public void updateConsole(String latest) {
        swapHistory();
        this.latest = latest;
        setText();
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
}
