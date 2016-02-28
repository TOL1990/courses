package com.rxn1d.courses.model;

import com.rxn1d.courses.common.ConsoleReader;

import java.util.ArrayList;

/**
 * Created by Леонид on 24.02.2016.
 */
public class Table {
    RouleteRing ring;
    ArrayList <Player> players; // расширить до многих игроков ввести места сидячие
    Player plCasino;
    Player player; // to test
    Stata stata;
    int [] betTable;

    int winIndex;

    boolean IsContinuing= true;



    public Table() {
        ring = new RouleteRing();
        plCasino = new Player("Casino",0); // дописать сколько бабла получит казино
        players = new ArrayList<>(5);
        player = new Player();
        stata = new Stata();
    }
    public void run() //Генерит случ число. присваивает стату
    {
        String[] in;

        while (IsContinuing)
        {
            in = ConsoleReader.readFromConsole(); // для чтения из консоли
            analizeInput(in);

//            setBet();
//            spinAndStat();//Крутнуть и записать стату
//            checkResult(player, winIndex);
//            printResult();
            //break;
        }
        System.out.println("ADIOS AMIGOS!");
    }

    private void analizeInput(String [] in) {
        if (in[0].equals("NEW_USER"))
        {
           // System.out.println("Adding new user");
            players.add(new Player(in[1], Integer.parseInt(in[2])));
        }

        if(in[0].equals("EXIT")){
           // System.out.println("Exit adios");
            IsContinuing = false;
        }
        if(in[0].equals("STATS"))
        {
           // System.out.println("Choose stat");
            stata.setPlayers(players);
            System.out.println(stata.toString());
        }
        if(in[0].equals("BET"))
        {
            Player curentPlayer;

            curentPlayer = players.get(0); //затестим с первым добавленнім плеером
            String[] betStr;
            System.out.println("Setting bets: ");
            while(true)
            {
             betStr = ConsoleReader.readFromConsole();
                if(betStr[0].equals("BET"));
                {
                 //   int index = players.get(0);
                }
            curentPlayer.setBet("RED",20);
                break;

            //curentPlayer.setBet(betStr[3], Integer.parseInt(betStr[2]));
            }

        }
        if(in[0].equals("PLAY_GAME"))
        {
           spin();
            for(int i = 0; i <players.size();i++) {
                checkResult(players.get(i), winIndex);
                System.out.println(" -> Player: " + players.get(i).getName() + " +" + players.get(i).getMoney()); // Поменять на віиграшь и проиграшь в єтом раунде
            }
            printResult();
        }
//          проверить содержимое вхоодящего массива
//        for (int i = 0; i <in.length; i ++)
//        {
//            System.out.println("in[" + i + "] = " + in[i]);
//        }
    }

    private void printResult() {
        System.out.println("Round result");
        System.out.print("Winning number = " + ring.getWinNumber(winIndex) + "-" + ring.getWinColor(winIndex));
        for(int i = 0; i <players.size();i++) {

            System.out.print(" -> Player: " + players.get(i).getName() + " have " + players.get(i).getMoney() + "$"); // Поменять на віиграшь и проиграшь в єтом раунде
        }
        System.out.println();
        //-> Player: Ievgen +50$ -> Player: Alex -110$
    }

    private void checkResult(Player pl, int winIndex) {
        int wNumb = ring.getWinNumber(winIndex);
        String wColor = ring.getWinColor(winIndex);
        String playerBet = pl.getBet();

        if(playerBet == wColor ) {
            pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //добавить к баблу сумму выиграша
            System.out.println("Player " + pl.getName() + " +" + pl.getBetMoney() + ". He bet to RED!!!!");
        }
       // if(Integer.parseInt(playerBet) == wNumb) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 35);
        else if(playerBet == "ODD" && wNumb % 2 == 1) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //если нечетное
        else if( playerBet == "EVEN" && wNumb % 2 == 0) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //если четное
        else if( playerBet == "BIG" && wNumb >= 19 && wNumb <= 36)pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //Если большие числа
        else if( playerBet == "EVEN" && wNumb <= 18 && wNumb >0) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //Если малые числа
        else
        {
          //  pl.setMoney(pl.getMoney() - pl.getBetMoney());
            System.out.println("Player loose his bet!");
        }



    }

    private void setBet() {

        player.setBet("RED", 20);
    }

    private boolean checkReady(boolean s ) { //проверяет можно ли запускать игру
        return s;
    }

    private void spin() {

        winIndex = (int)(Math.random() * ((37) + 1));
        ring.setWinNumber(winIndex);
        ring.setWinColor(winIndex);
       // System.out.println("Win number " + ring.getWinNumber(winIndex) + "-" + ring.getWinColor(winIndex) );


    }
    private void bet()
    {

    }

}
