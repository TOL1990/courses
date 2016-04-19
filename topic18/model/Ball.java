package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Ball {
    private Color color;
    private int x; // начальное состояние
    private int y;
    private int size; // радиус
    private int speed;
    private int xDirection; // направление
    private int yDirection; // направление

    public Ball(int xCreate, int yCreate)
    {
        this.x = xCreate;
        this.y = yCreate;
        color = getColor();
        size = initSize();
        move();
    }

    protected void paintComponent(Graphics g)
    {
//        g.clearRect(0, 0, getWidth(), getHeight()); // x , y , координаты появления фигуры
        g.setColor(getColor());
//        g.drawOval(0, 0, getWidth(), getHeight());
        g.drawOval(200, 110, 60, 60);
    }

    /**
     * @return рандомный цвет из листа ColorsArr
     * в стоковом состоянии возвр Green
     */
    public Color getColor() {
//        ColorsArr colorsArr = new ColorsArr();
//        Color color = Color.GREEN;
        // Реализовать смену цвета
//        Min + (int)(Math.random() * ((Max - Min) + 1))
        return Color.GREEN;
    }

    /**
     * реализовыввает перемещение
     */
    public void move() {
        speed = 2; //тестовая версия, пишу руками
        x = x + speed;
        y = y + speed;
    }

    /**
     * @return размер мячика
     * max - максимальный размер шарика,
     * min - минимальный размер шарика
     */
    private int initSize() {
        Random random = new Random();
        return random.nextInt(BallConstants.MAX_RADIUS) + BallConstants.MIN_RADIUS;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
