package com.courses.spalah.text.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Тарас on 10.03.2016.
 */
public class SymbolCounter {
    public static String[] readFromFile1() {
        try {
            BufferedReader bufferRead = new BufferedReader((new FileReader("topic8\\src\\main\\resources\\text_sample.txt")));

            String input = bufferRead.readLine();

            return input.split("\\s");
        } catch (IOException e) {
            return new String[]{""};
        }
    }
    public static String readFromFile() {
        String input = "";
        String result = "";
        try {
            BufferedReader bufferRead = new BufferedReader((new FileReader("topic8\\src\\main\\resources\\text_sample.txt")));

            while (input != null) {
                result += input;
                input = bufferRead.readLine();
            }
            bufferRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = result.replaceAll("\\s+", "");
        System.out.println("result.length(); -" + result.length());
//        return result.length();
        return result;

    }
    public static int getSymbolCounts(String[] sArr) {
        int symbolCounts=0;
        for(int i=0; i < sArr.length; i++)
        {
            char[] tempArrChar = sArr[i].toCharArray();
            symbolCounts += tempArrChar.length;
        }
        return symbolCounts;
    }
    public static int getSymbolCounts(String sArr) {
        int symbolCounts = 0;
//        char[] tempArrChar = sArr.toCharArray();
//        for(int i=0; i < tempArrChar.length; i++)
//        {
//            if(tempArrChar[i] != ' ') symbolCounts ++;
//        }
        return symbolCounts;
    }
}
