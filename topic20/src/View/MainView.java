package View;

import SorterApp.Controller;
import algorithms.BubleSort;

import javax.swing.*;
import java.util.Random;

/**
 * Created by Leonid on 24.04.2016.
 */
public class MainView {
    public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run () {
            JFrame.setDefaultLookAndFeelDecorated(true);
            MainFrame frame = new MainFrame();
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
    }
}


