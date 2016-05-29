package com.courses.spalah.models;

/**
 * Created by Тарас on 29.05.2016.
 */
public class Game {
    String name;

    public Game(){}
    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
