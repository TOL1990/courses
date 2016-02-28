package com.rxn1d.courses.model;

import java.util.ArrayList;

/**
 * Created by Леонид on 24.02.2016.
 */
public class Stata {
    String players;
    int Betscount=0;
    int odd;
    int even;
    int big;
    int small;
    int black;
    int red;
    int straight_up;
    int casinoMoney;
    int frequent; // самое часто встречаемое;
    Stata(){}

    public Stata(String players) {
        this.players = players;
    }

    public Stata(String players, int betscount, int odd, int even, int big, int small, int black, int red, int straight_up, int casinoMoney, int frequent) {
        this.players = players;
        Betscount = betscount;
        this.odd = odd;
        this.even = even;
        this.big = big;
        this.small = small;
        this.black = black;
        this.red = red;
        this.straight_up = straight_up;
        this.casinoMoney = casinoMoney;
        this.frequent = frequent;
    }

    //    > Total bets count = 21
//    -> Total bets by type [RED = 1, BLACK = 3, ODD = 10, EVEN = 1, SMALL = 1, BIG = 1, STRAIGHT_UP = 4]
//    -> Balance = +1500$
//    -> Most frequent number = 0-GREEN
//    -> Players [Ievgen = 500$, Alex = 1203$]
    @Override
    public String toString() {
        return "Total bets count = " + Betscount + '\n' +
                "Total bets by type [" +
                "RED = " + red +
                ", BLACK = " + black +
                ", ODD = " + odd +
                ", EVEN = " + even +
                ", SMALL = " + small +
                ", BIG = " + big +
                ", STRAIGHT_UP = " + straight_up + "]\n" +
                "Balance = " + casinoMoney +"$\n" +
                "Most frequent number = " + mostfrequentNumb() + "\n" +

                "Players = [" + players + "]";
    }

    private String mostfrequentNumb() {
        return new String();
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> pls) {
       String playersString = "";
        for (int i = 0; i < pls.size(); i++)
        {
            if(i!=0)  playersString +=","; //чтобы не ставить , перед первым Игроком
            playersString += pls.get(i).getName() + " = " + pls.get(i).getMoney() + "$";
        }
      //  System.out.println("playersString =" + playersString);
        this.players = playersString;
    }

    public int getBetscount() {
        return Betscount;
    }

    public void setBetscount(int betscount) {
        Betscount = betscount;
    }

    public int getOdd() {
        return odd;
    }

    public void setOdd(int odd) {
        this.odd = odd;
    }

    public int getEven() {
        return even;
    }

    public void setEven(int even) {
        this.even = even;
    }

    public int getBig() {
        return big;
    }

    public void setBig(int big) {
        this.big = big;
    }

    public int getSmall() {
        return small;
    }

    public void setSmall(int small) {
        this.small = small;
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = black;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getStraight_up() {
        return straight_up;
    }

    public void setStraight_up(int straight_up) {
        this.straight_up = straight_up;
    }

    public int getCasinoMoney() {
        return casinoMoney;
    }

    public void setCasinoMoney(int casinoMoney) {
        this.casinoMoney = casinoMoney;
    }

    public int getFrequent() {
        return frequent;
    }

    public void setFrequent(int frequent) {
        this.frequent = frequent;
    }
}
