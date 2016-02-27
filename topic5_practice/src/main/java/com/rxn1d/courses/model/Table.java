package com.rxn1d.courses.model;

import java.util.ArrayList;

/**
 * Created by Леонид on 24.02.2016.
 */
public class Table {
    RouleteRing ring;
    Player player; // расширить до многих игроков ввести места сидячие
    int [] betTable;

    int winIndex;



    public Table() {
        ring = new RouleteRing();
        player = new Player();
    }
    public void run() //Генерит случ число. присваивает стату
    {

       // while (checkReady())
        //{
            setBet();
            spinAndStat();//Крутнуть и записать стату
            checkResult(player, winIndex);
            printResult();
//            break;
//        }
    }

    private void printResult() {
        System.out.println("Round result");
        System.out.println("Win number " + ring.getWinNumber(winIndex) + "-" + ring.getWinColor(winIndex) );
        System.out.println("Player " + player.getName() + " have " + player.getMoney());
    }

    private void checkResult(Player pl, int winIndex) {
        int wNumb = ring.getWinNumber(winIndex);
        String wColor = ring.getWinColor(winIndex);
        String playerBet = pl.getBet();

        if(playerBet == wColor ) {
            pl.setMoney(pl.getMoney() + pl.getBetMoney()); //добавить к баблу сумму выиграша
            System.out.println("Player " + pl.getName() + " +" + pl.getBetMoney() + ". He bet to RED!!!!");
        }
       // if(Integer.parseInt(playerBet) == wNumb) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 35);
        else if(playerBet == "ODD" && wNumb % 2 == 1) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //если нечетное
        else if( playerBet == "EVEN" && wNumb % 2 == 0) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //если четное
        else if( playerBet == "BIG" && wNumb >= 19 && wNumb <= 36)pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //Если большие числа
        else if( playerBet == "EVEN" && wNumb <= 18 && wNumb >0) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //Если малые числа
        else
        {
            pl.setMoney(pl.getMoney() - pl.getBetMoney());
            System.out.println("Player loose his bet!");
        }



    }

    private void setBet() {
       player.setBet("RED", 20);
    }

    private boolean checkReady() { //проверяет можно ли запускать игру
        return true;
    }

    private void spinAndStat() {

        winIndex = (int)(Math.random() * ((37) + 1));
        ring.setWinNumber(winIndex);
        ring.setWinColor(winIndex);
       // System.out.println("Win number " + ring.getWinNumber(winIndex) + "-" + ring.getWinColor(winIndex) );


    }
    private void bet()
    {

    }

}
