package com.rxn1d.courses.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ievgen Tararaka
 */
public class ConsoleReader {
    public static String[] readFromConsole() {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String input = bufferRead.readLine();
            return input.split("\\s");
        } catch (IOException e) {
            return new String[]{""};
        }
    }
    public static String[] readLineFromFile() {
        try {

        BufferedReader reader = new BufferedReader(new FileReader("topic5_practice\\src\\main\\resources\\comand.txt"));

            String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        String[] linesAsArray = lines.toArray(new String[lines.size()]);
            return linesAsArray;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CAN NOT READ FILE:");
            return new String[]{""};
        }
    }

    public static String[] readLineFromString(String string)
    {
        String input = string.trim();
        return input.split("\\s");
    }
}
