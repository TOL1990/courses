package com.rxn1d.courses;

/**
 * Created by Леонид on 24.02.2016.
 */
public class Player {
    String name;
    int money;


    public Player(String name , int money) {
        this.name = name;
        this.money = money;
    }

    public Player() {
        name = "Вася";
        money = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
