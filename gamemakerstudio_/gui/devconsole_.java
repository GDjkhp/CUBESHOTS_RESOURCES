package gamemakerstudio_.gui;

import gamemakerstudio_.*;
import gamemakerstudio_.entities.*;
import gamemakerstudio_.misc.FACE;
import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.handler_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

public class devconsole_ extends JFrame implements ActionListener, KeyListener {
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed (KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            performCommands();
        }
        if (key == KeyEvent.VK_ESCAPE || key == 192) {
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
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

    public void performCommands() {
        // time
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        // try to parse
        String keyBuffer = console_text.getText();
        String[] tokens = keyBuffer.split("\\s+");
        try {
            // your custom codes here
            // token 0 == command
            // token 1, 2, 3, ... == arg (start at 1)
            switch (tokens[0]) {
                case "spawn":
                    summonEntity(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                            Float.parseFloat(tokens[4]), Float.parseFloat(tokens[5]), Integer.parseInt(tokens[6]));
                    updateConsole(now + ": Spawned " + tokens[1] + " at " + tokens[2] + ", " + tokens[3]);
                    break;
                case "kill":
                    removeEntities(tokens[1]);
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
                    if (game.music) game.music = false;
                    else game.music = true;
                    updateConsole(now + ": Sound " + game.music);
                    break;
                default:
                    updateConsole("Syntax error: " + tokens[0] + " is not a valid command!");
                    break;
            }
        } catch (Exception exception) {
            updateConsole("Syntax error: " + exception);
            exception.printStackTrace();
        }
    }

    public void summonEntity (String tempObject, int x, int y, float velX, float velY, int spawnTimer) {
        // entity classes
        switch (tempObject) {
            case "basicenemy_":
                handler.addObject(new basicenemy_(x, y, ID.BasicEnemy, handler, spawnTimer));
                break;
            case "fastenemy_":
                handler.addObject(new fastenemy_(x, y, ID.FastEnemy, handler, spawnTimer));
                break;
            case "hardenemy_":
                handler.addObject(new hardenemy_(x, y, ID.HardEnemy, handler, spawnTimer));
                break;
            case "smartenemy_":
                handler.addObject(new smartenemy_(x, y, ID.SmartEnemy, handler, 3, 3, spawnTimer));
                break;
            case "basecircle_":
                handler.addObject(new basecircle_(x, y, ID.BaseCircle, handler, velX, velY, spawnTimer));
                break;
            case "bullethellgenerator_":
                // spawn bullethellgenerator_ 300 300 0 0 0
                handler.addObject(new bullethellgenerator_(x, y, ID.BULLETHELLGHOST, handler, game, spawnTimer,
                        1, 1, 0, 0, 0, false,
                        false));
                break;
            case "triangleshooter_":
                // spawn triangleshooter_ 300 300 0 0 50
                handler.addObject(new triangleshooter_(x, y, ID.TriangleShooter, handler, velX, velY, spawnTimer, FACE.EAST));
                break;
            default:
                updateConsole("Syntax error: " + tempObject + " is not a valid entity!");
                break;
        }
    }
    public void removeEntities (String tempObjectID) {
        switch (tempObjectID) {
            case "basicenemy_":
                handler.removeAllSelectedObjectsExceptPlayers(ID.BasicEnemy);
                updateConsole("Killed " + tempObjectID);
                break;
            case "fastenemy_":
                handler.removeAllSelectedObjectsExceptPlayers(ID.FastEnemy);
                updateConsole("Killed " + tempObjectID);
                break;
            case "hardenemy_":
                handler.removeAllSelectedObjectsExceptPlayers(ID.HardEnemy);
                updateConsole("Killed " + tempObjectID);
                break;
            default:
                updateConsole("Syntax error: " + tempObjectID + " is not a valid entity!");
                break;
        }
    }
}
