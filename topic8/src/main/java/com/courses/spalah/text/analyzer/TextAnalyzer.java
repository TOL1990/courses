package com.courses.spalah.text.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ievgen Tararaka
 *
 */
    public class TextAnalyzer {
    private static int symbolCounts;
    private static int wordsCount;
    private static int sentencesCount;
    private static ArrayList<String> uniqWords;

    public static void main(String[] args) {
        String[] str = readFromFile();
        String[] strznak = readFromFileZnak();

//        for (int i = 0; i < str.length; i++ )     // для выводна на экран массива
//       System.out.println( str[i]);

       symbolCounts = SymbolCounter.readFromFile().length();
        getWordsCount(strznak);
        getSentences(str);
        uniqWords = getUniqueWords(str);
        System.out.println("uniqWords: " + uniqWords);
        System.out.println("uniqWordsCount =  " + uniqWords.size());
        printStatistic();
    }

    private static void getSentences(String[] sArr) {

        for(int i=0; i < sArr.length; i++)
        {
            char[] tempArrChar = sArr[i].toCharArray();
            for(int j=0; j < tempArrChar.length;j++)
               if( tempArrChar[j] == '.') sentencesCount++;

        }

    }

    private static void getWordsCount(String[] str) {
            wordsCount = str.length;
    }

    public static String[] readFromFile() {
        try {
            BufferedReader bufferRead = new BufferedReader((new FileReader("topic8\\src\\main\\resources\\text_sample.txt")));

            String input = bufferRead.readLine();
            return input.split("\\s*[,|.|!|?|-|:|;|\\s]+\\s*");
        } catch (IOException e) {
            return new String[]{""};
        }
    }
    public static String[] readFromFileZnak() {
        String input = "";
        String resultStr = "";
        try {
            BufferedReader bufferRead = new BufferedReader((new FileReader("topic8\\src\\main\\resources\\text_sample.txt")));

            while (input != null) {
                resultStr += input;
                input = bufferRead.readLine();
            }
            bufferRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultStr.split("\\s");
    }

    public static ArrayList<String> getUniqueWords (String[] sArr) {
        ArrayList<String> tempList = new ArrayList<>();
        ArrayList<String> uniqList = new ArrayList<>();

        for (int i = 0; i < sArr.length; i++)
        {
            tempList.add(sArr[i]);
        }
        for(int i = 0; i < tempList.size(); i++)
        {
            int frequencyCount = Collections.frequency(tempList, tempList.get(i)); // получим результат 2
            if(frequencyCount == 1)
                uniqList.add(tempList.get(i));
        }
       return uniqList;
    }
    public static void printStatistic()
    {
        System.out.println("symbolCounts = " + symbolCounts + "\n"+
                "wordsCount = "+ wordsCount+"\n" +
        "sentencesCount = " + sentencesCount);
    }

}
