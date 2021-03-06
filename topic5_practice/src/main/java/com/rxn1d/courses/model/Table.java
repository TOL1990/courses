package com.rxn1d.courses.model;

import com.rxn1d.courses.common.ConsoleReader;
import jdk.nashorn.internal.objects.annotations.Function;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Леонид on 24.02.2016.
 */
public class Table {
    RouleteRing ring;
    ArrayList<Player> players; // расширить до многих игроков ввести места сидячие
    Player plCasino;
    Player player; // to test
    Stata stata;
    int[] betTable;

    int winIndex;

    boolean IsContinuing = true;


    public Table() {
        ring = new RouleteRing();
        plCasino = new Player("Casino", 0); // дописать сколько бабла получит казино
        players = new ArrayList<>(5); //ограничиваем стол до 5 игроков
        player = new Player();
        stata = new Stata();
    }

    public void run() //Генерит случ число. присваивает стату
    {
        String[] in;
        String[] fileComands = ConsoleReader.readLineFromFile();

        runFileCommands(fileComands);//читаем из файла

        while (IsContinuing) {
            in = ConsoleReader.readFromConsole(); // для чтения из консоли
            analizeInput(in);
        }
        System.out.println("ADIOS AMIGOS!");
    }
    /**
     * читает строку и анализирует ее
     * @param comands єто массив комманд из консоли
     */
    private void runFileCommands(String[] comands) {
        String[] in;
        for (int i = 0; i < comands.length; i++) {
//            System.out.println("fileComands [" + i + "] = -" + comands[i] + "-");

            in = ConsoleReader.readLineFromString(comands[i]);
            analizeInput(in);
        }
    }

    private void analizeInput(String[] in) {
        if (in[0].equals("NEW_USER")) {
            players.add(new Player(in[1], Integer.parseInt(in[2])));
            System.out.println("New user with name = " +
                    players.get(players.size() - 1).getName() +
                    " and balance = " + players.get(players.size() - 1).getMoney() +
                    "$ is added to table");
        } else if (in[0].equals("EXIT")) {
            // System.out.println("Exit adios");
            IsContinuing = false;
        } else if (in[0].equals("STATS")) {
            // System.out.println("Choose stat");
            stata.setPlayers(players);
            System.out.println(stata.toString());
        } else if (in[0].equals("BET")) {
            Player curentPlayer;
            curentPlayer = getPlayerWithName(players, in[1]); //затестим с первым добавленнім плеером
            String[] betStr;
            //  System.out.println("Setting bets: ");
//            while(true)
//            {
//             betStr = ConsoleReader.readFromConsole();
//                if(betStr[0].equals("BET"));
//                {
//                 //   int index = players.get(0);
//                }
            // curentPlayer.setBet("RED",20);
            curentPlayer.setBet(in[3], Integer.parseInt(in[2]));
            // break;

            //   }

        } else if (in[0].equals("PLAY_GAME")) {
            spin();
            for (int i = 0; i < players.size(); i++) {
                checkResult(players.get(i), winIndex);
                }
            // printResult();
        } else if (in[0].equals("")) ;

        else
            System.out.println("THERE IS NO COMMAND: " + in[0]);
//          проверить содержимое вхоодящего массива
//        for (int i = 0; i <in.length; i ++)
//        {
//            System.out.println("in[" + i + "] = " + in[i]);
//        }
    }

    private Player getPlayerWithName(ArrayList<Player> playersList, String s) {
        Player concrete = null;
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).getName().equals(s)) concrete = playersList.get(i);
        }
        return concrete;
    }

    private void printResult() {
        System.out.println("Round result");
        System.out.print("Winning number = " + ring.getWinNumber(winIndex) + "-" + ring.getWinColor(winIndex));
        for (int i = 0; i < players.size(); i++) {

            System.out.print(" -> Player: " + players.get(i).getName() + " have " + players.get(i).getMoney() + "$"); // Поменять на віиграшь и проиграшь в єтом раунде
        }
        System.out.println();
        //-> Player: Ievgen +50$ -> Player: Alex -110$
    }

    private void checkResult(Player pl, int winIndex) {
        int wNumb = ring.getWinNumber(winIndex);
        String wColor = ring.getWinColor(winIndex);
        String playerBet = pl.getBet();

        if (playerBet == wColor) {
            pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2); //добавить к баблу сумму выиграша
            System.out.println("Player " + pl.getName() + " +" + pl.getBetMoney() + ". He bet to RED!!!!");
        } else if (playerBet == "RED" && wNumb % 2 == 1) {
            System.out.println("Player " + pl.getName() + " +" + pl.getBetMoney());
            pl.setMoney(pl.getMoney() + pl.getBetMoney() * 2);
        } //
        // if(Integer.parseInt(playerBet) == wNumb) pl.setMoney(pl.getMoney() + pl.getBetMoney() * 35);
        else if (playerBet == "ODD" && wNumb % 2 == 1) {
            pl.setWinBet(true, 2);//2 = win couficient
        } //если нечетное
        else if (playerBet == "EVEN" && wNumb % 2 == 0) {
            pl.setWinBet(true, 2);//2 = win couficient

        } else if (playerBet == "BIG" && wNumb >= 19 && wNumb <= 36) {
            pl.setWinBet(true, 2);//2 = win couficient //Если большие числа

        } else if (playerBet == "EVEN" && wNumb <= 18 && wNumb > 0) {
            pl.setWinBet(true, 2);//2 = win couficient //Если малые числа

        } else {
            //  pl.setMoney(pl.getMoney() - pl.getBetMoney());
            pl.setWinBet(false, 2);
        }
    }

    private void setBet() {

        player.setBet("RED", 20);
    }

    private boolean checkReady(boolean s) { //проверяет можно ли запускать игру
        return s;
    }

    private void spin() {

        winIndex = (int) (Math.random() * ((37) + 1));
        ring.setWinNumber(winIndex);
        ring.setWinColor(winIndex);
        System.out.println("Win number " + ring.getWinNumber(winIndex) + "-" + ring.getWinColor(winIndex));

    }

}
