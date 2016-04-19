package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Created by Leonid on 18.04.2016.
 */
public class Panel extends JPanel{
    //рисую балсі
//    на онклик
//переопред paint()


    @Override
    protected void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight()); // x , y , координаты появления фигуры
        g.setColor(getColor());
//        g.drawOval(0, 0, getWidth(), getHeight());
        g.drawOval(200, 110, 60, 60);
    }

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
    }
}
