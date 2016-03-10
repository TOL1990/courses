package com.rxn1d.courses.model;

/**
 * Created by Леонид on 27.02.2016.
 */
public class Bet {
    boolean red_black;// false - blak
    boolean oven_odd; // false - odd
    boolean small_big;// false - big
    int number;
    int sum; //сколько денег ставит

    public Bet(){
        this.red_black = true;
        this.oven_odd  = true;
        this.small_big = true;
        this.number = 0;
    }
    public Bet(boolean red_black, boolean oven_odd, boolean small_big, int number) {
        this.red_black = red_black;
        this.oven_odd = oven_odd;
        this.small_big = small_big;
        this.number = number;
    }

    public boolean isRed_black() {
        return red_black;
    }

    public void setRed_black(boolean red_black) {
        this.red_black = red_black;
    }

    public boolean isOven_odd() {
        return oven_odd;
    }

    public void setOven_odd(boolean oven_odd) {
        this.oven_odd = oven_odd;
    }

    public boolean isSmall_big() {
        return small_big;
    }

    public void setSmall_big(boolean small_big) {
        this.small_big = small_big;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
