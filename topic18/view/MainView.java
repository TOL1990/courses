package view;

import model.Ball;

import javax.swing.*;

/**
 * Created by Leonid on 17.04.2016.
 */
public class MainView {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Crazzy balls");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600,400);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Ball ball = new Ball();
        JPanel panel = new JPanel();
        frame.add();

        frame.setVisible(true);
    }
}
