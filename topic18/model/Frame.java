package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Leonid on 18.04.2016.
 */
public class Frame extends JFrame{
   public Frame()
    {
        super("Crazzy Balls!!!!");
    }
    public void init() {
        Panel panel= new Panel();
        try {
            panel.moveBalls();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setContentPane(panel);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(600, 400);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);



    }
}
