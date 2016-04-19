package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Ball {
    private Color color;
    private int size;
    private int speed;
    private int direction;

    protected void paintComponent(Graphics g)
    {
//        g.clearRect(0, 0, getWidth(), getHeight()); // x , y , координаты появления фигуры
        g.setColor(getColor());
//        g.drawOval(0, 0, getWidth(), getHeight());
        g.drawOval(200, 110, 60, 60);
    }

    public Color getColor() {
        ColorsArr colorsArr = new ColorsArr();
        Color color = Color.GREEN;
        // Реализовать смену цвета
//        Min + (int)(Math.random() * ((Max - Min) + 1))
        return color;
    }
}
