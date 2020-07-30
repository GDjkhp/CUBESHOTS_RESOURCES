/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemakerstudio_.gui;
import gamemakerstudio_.game_;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author ACER
 */
public class window_ extends Canvas{
    public window_ (int width, int height, String title, game_ game) {
        
        ImageIcon icon = new ImageIcon("resources_/image_/icon remastered.png");
        
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        frame.setIconImage(icon.getImage());
        
        game.start();
    }
}
