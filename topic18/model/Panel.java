package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Leonid on 18.04.2016.
 */
public class Panel extends JPanel{
    private List<Ball> ballsList = new ArrayList<>();
    //рисую балсі
//    на онклик
//переопред paint()
    Panel()
    {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ballsList.add(new Ball( e.getX(), e.getY() ));
                System.out.println("Clicked x="  + e.getX()+ " y = " + e.getY());
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(Ball b : ballsList) {

            g.setColor(b.getColor());
            g.fillOval(b.getX(), b.getY(), b.getSize(), b.getSize());
              b.move(getWidth(),getHeight());

        }
    }

    public void moveBalls() throws InterruptedException {
        new Timer(15, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }).start();

    }
}
