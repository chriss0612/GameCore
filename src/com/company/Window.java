package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Christian on 02.12.2016.
 */
public class Window /*extends Canvas*/{
    private static final long serialVersionUID = -7812912346723576496L;
    public JFrame frame;
    public Window(int width, int height, String title, Game game)
    {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
