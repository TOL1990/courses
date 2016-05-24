package com.courses.spalah.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonid on 21.05.2016.
 */
public class MainFrame {

    public static void start() {
        JFrame frame = new JFrame("Bank Application");

       frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new GridBagLayout());

        MainPanel panel = new MainPanel();
        frame.add(panel);

        frame.setVisible(true);

    }
}
