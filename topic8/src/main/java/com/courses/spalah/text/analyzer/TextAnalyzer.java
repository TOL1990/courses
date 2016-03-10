package com.courses.spalah.text.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        for (int i = 0; i < str.length; i++ )
          
//        System.out.println( str[i]);

       symbolCounts = SymbolCounter.getSymbolCounts(SymbolCounter.readFromFile());
        getWordsCount(str);
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
        for (int i = 0; i < str.length; i++ )
            wordsCount++;
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

    public static ArrayList<String> getUniqueWords (String[] sArr) {
        ArrayList<String> uniqList = new ArrayList<>();

        for (int i = 0; i < sArr.length; i++)
        {
            if(!uniqList.contains(sArr[i])) uniqList.add(sArr[i]);
            else
            {
//                System.out.println("Else getUniqueWords.");
                uniqList.remove(sArr[i]);
            }
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
