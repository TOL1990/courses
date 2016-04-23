package model;

/**
 * Created by Leonid on 21.04.2016.
 */
public interface Movable {

    /**
     * Описывает движение обьекта
     * @param width границы окна по ширине
     * @param height границы окна по высоте
     */
    public void move(int width, int height);
}
