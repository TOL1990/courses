package com.rxn1d.courses.model;

/**
 * Created by Леонид on 24.02.2016.
 */
public class Player {
    String name;
    int money;

    public void setBetMoney(int betMoney) {
        this.betMoney = betMoney;
    }

    public String getBet() {

        return bet;
    }

    public int getBetMoney() {
        return betMoney;
    }

    //  String[] bet; нужен будет массив ставок вдруг юзер на несколько поставить захочет
    String bet;
    int betMoney;


    public Player(String name , int money) {
        this.name = name;
        this.money = money;
    }

    public Player() {
        this.name = "Вася";
        this.money = 500;
 //       this.bet = new Bet();


        //
    }

    public void setBet(String bet) {
        this.bet = bet;
    }
    public void setBet(String bet,int moneybet) {
        this.bet = bet;
        this.betMoney = moneybet;

        if(moneybet > money) System.out.println("Ты ставишь больше бабла чем у тебя есть");
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
