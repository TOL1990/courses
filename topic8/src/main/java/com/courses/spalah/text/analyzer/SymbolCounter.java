package com.courses.spalah.text.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Тарас on 10.03.2016.
 */
public class SymbolCounter {

    public static String readFromFile() {
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

        resultStr = resultStr.replaceAll("\\s+", "");
        return resultStr;
    }
}
