/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.gui;

import gamemakerstudio_.game_;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author ACER
 */
public class loading_ {
    private int loadValue = 255;
    public loading_() {

    }
    public void tick() {
        loadValue = (int)game_.loadstate * 2;
        loadValue = game_.clamp(loadValue, 0, 255);
    }
    public void render(Graphics g) {
        g.setFont(new Font("arial", 0, 15));
        g.setColor(new Color(75, loadValue, 0));
        g.fillRect(game_.WIDTH / 3, 325, (int) (200 * (game_.loadstate / 100)), 50);
        g.setColor(Color.green);
        g.drawString(game_.stringsforloading, game_.WIDTH / 3 + 50, game_.HEIGHT / 2 + 25);
        g.drawRect(game_.WIDTH / 3, 325, 200, 50);

    }
}
