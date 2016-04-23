package model;

import java.awt.*;
import java.util.Random;


public class Ball implements Movable {
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
        speed = new Random().nextInt(BallConstants.MAX_SPEED) + BallConstants.MIN_SPEED;

        xDirection = new Random().nextInt(BallConstants.MAX_DIRECTION_SPEED_X) + BallConstants.MIN_DIRECTION_SPEED_X;
        yDirection = new Random().nextInt(BallConstants.MAX_DIRECTION_SPEED_Y) + BallConstants.MIN_DIRECTION_SPEED_Y;

        size = initSize();

    }


    /**
     * @return рандомный цвет из листа ColorsArr
     * в стоковом состоянии возвр Green
     */
    public Color getColor() {
        Color color;

                ColorsArr colorsArr = new ColorsArr();
                int randomColor = (int) (Math.random() * ((colorsArr.getColorList().size()) ));
                System.out.println(randomColor);
                color = colorsArr.getColorList().get(randomColor);


        return  color;
    }

    @Override
    public void move(int width, int height) {
        //далее перемещение с исспользованием вектора направления х и у и скорости в одном параметре
Thread thread = new Thread(){
    public void run()
    {
        x += xDirection;
        y += yDirection;
        if(x >= width - size || x <=0)
        {
            xDirection = xDirection * (-1); //инвертировать движение по х
        }
        if(y >= height - size || y <=0)
        {
            yDirection = yDirection * (-1); //инвертировать движение по х
        }

    }
};
        thread.start();

        //  далее версия перемещения шара по направлению где скорость отдельный параметр
        //...
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
