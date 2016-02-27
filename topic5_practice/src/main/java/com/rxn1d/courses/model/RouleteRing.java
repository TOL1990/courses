package com.rxn1d.courses.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Леонид on 24.02.2016.
 */
public class RouleteRing {

    int countBox = 37; // кол-во ячеек
    int [] baketNumbers =  new int[countBox]; // задаем бокс размером кол-во ячеею + второй ряд под цвет
    String [] baketColors = new String[countBox];

    public void setWinNumber(int winIndex) {
        this.winNumber =  baketNumbers[winIndex];

    }

    public void setWinColor(int winIndex) {
        this.winColor = baketColors[winIndex];
    }

    int winNumber;
    String winColor;

    public RouleteRing() {
        createBaketStock();
    }

    private void createBaketStock() { //стол без перемешивания
        baketNumbers[0]= 0;
        baketColors[0] = "GREEN";
        for (int i = 1; i <= 36; i++)//Заполним массив числами от 1 до 36
        {
            baketNumbers[i] = i;
        }

        for (int i = 1; i <= 36; i+= 2)//Заполним переливочнчый массив числами  1
        {
            baketColors[i] = "RED";
        }
        for (int i = 2; i <= 36; i+= 2)//Заполним переливочнчій массив числами  0
        {
            baketColors[i] = "BLACK";
        }
       // printBaket();
    }

    private void createBaket() {

        // System.out.println(solutionArray[i][0]);
        baketNumbers[0]= 0;
        baketColors[0] = "GREEN";
        for (int i = 1; i <= 36; i++)//Заполним массив числами от 1 до 36
        {
            baketNumbers[i] = i;
        }

        shuffleArray(baketNumbers); // Перемешаем числа

      //  Получили перемешанный ряд чисел


        for (int i = 1; i <= 36; i+= 2)//Заполним переливочнчый массив числами  1
        {
            baketColors[i] = "RED";
        }
        for (int i = 2; i <= 36; i+= 2)//Заполним переливочнчій массив числами  0
        {
            baketColors[i] = "BLACK";

        }
        shuffleArray(baketColors);

        printBaket();


        System.out.println();

        for (int i = 1; i <= 37; i++) {
//            baket[i][0] = solutionArray[i-1];
//            baket[i][1] = solutionArrayColor[i-1];
        }

        for (int i = 0; i <= 37; i++) {
//            baket[i][0] = solutionArray[i-1];
//            baket[i][1] = solutionArrayColor[i-1];
//            System.out.print(baket[i][0] + " ");
//            System.out.println(baket[i][1] + "; ");
        }

    }


    static void shuffleArray(int[] ar) {

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    static void shuffleArray(String[] ar) {

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public int getWinNumber(int winIndex)    {         return baketNumbers[winIndex];
   }
    public String getWinColor(int winIndex)
    {
        return baketColors[winIndex];
    }
//    public void setBaket(int[][] baket) {
//        this.baket = baket;
//    }
    private void printBaket()
    {
        System.out.println("Our Bucket:");
        for (int i = 0; i < baketColors.length; i++)
        {
            System.out.print(baketNumbers[i] + " - ");
            System.out.println(baketColors[i] + " ");
        }
        System.out.println();
    }
}
//    static int [] createArrayNumb() // метод создает массив одномерный
//    {
//        return int [];}
//    }



