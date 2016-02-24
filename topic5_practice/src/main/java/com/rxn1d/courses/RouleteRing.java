package com.rxn1d.courses;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Леонид on 24.02.2016.
 */
public class RouleteRing {

    int countBox = 37; // кол-во ячеек
    int [][] baket =  new int[countBox][1]; // задаем бокс размером кол-во ячеею + второй ряд под цвет

    public RouleteRing() {

        createBaket();

    }

    private void createBaket() {
        baket[0][0] = 0; // нулевой елемент  всегда 0 зеленый

        int[] solutionArray = new int[37];
        int[] solutionArrayColor = new int[37];
        for (int i = 1; i <= 36; i++)//Заполним переливочнчій массив числами от 1 до 36
        {
            solutionArray[i] = i;
           // System.out.println(solutionArray[i][0]);
        }
        shuffleArray(solutionArray);
        for (int i = 0; i < solutionArray.length; i++)
        {
            System.out.print(solutionArray[i] + " ");
        }
        System.out.println();
      //  Получили перемешанный ряд чисел

        for (int i = 1; i <= 18; i++)//Заполним переливочнчій массив числами от 1 и 0
        {
            solutionArrayColor[i] = 1;
            // System.out.println(solutionArray[i][0]);
        }
        for (int i = 18; i <= 36; i++)//Заполним переливочнчій массив числами от 1 и 0
        {
            solutionArrayColor[i] = 0;
            // System.out.println(solutionArray[i][0]);
        }
        shuffleArray(solutionArray);
        for (int i = 0; i < solutionArrayColor.length; i++)
        {
            System.out.print(solutionArrayColor[i] + " ");
        }
        System.out.println();



    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }}
//    static int [] createArrayNumb() // метод создает массив одномерный
//    {
//        return int [];}
//    }



