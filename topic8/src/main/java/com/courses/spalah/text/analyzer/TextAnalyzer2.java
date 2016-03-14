package com.courses.spalah.text.analyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Тарас on 13.03.2016.
 */
public class TextAnalyzer2 {
    private File file;
    private String fileString;

    public TextAnalyzer2() {
        fileString = readFromFile("topic8\\src\\main\\resources\\text_sample.txt");
        System.out.println(getAllStatistic());
//        writeStatsToFile("topic8\\src\\main\\resources\\output.txt");
    }

    public TextAnalyzer2(String part) {
//        this.file = file;
    }

    public String readFromFile(String fileName) {

        if(fileName == null || fileName == "") fileName = "topic8\\src\\main\\resources\\text_sample.txt"; //Ставим файл по умолчанию

        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);
        file.exists();

        try {
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
       return sb.toString();
    }

    public void writeStatsToFile(String fileName) {
        if(fileName == null || fileName == "") fileName = "topic8\\src\\main\\resources\\output.txt"; //Ставим файл по умолчанию
        File file = new File(fileName);

        try {

            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(fileString);

            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String FileToStrAll(File file)
    {
return null;
    }
    private String toStrAll(String fileText)
    {
        return null;
    }

    private String FileToStrWords(File file)
    {
        return null;
    }
    private String toStrWords(String fileText)
    {

        return null;
    }

    private String FileToStrNoSpaces(File file)
    {
        return null;
    }
    private String toStrNoSpaces(String fileText)
    {

        return null;
    }

    private String getAllStatistic()
    {
        String statistic;

        //Вызов методов по получению статы

        statistic = (
        "Общее количество символов: " +                           getOverSymbolsCount(fileString) +
   "\n"+ "Количество слов: " +                                     getOverWordsCount(fileString) +
   "\n"+ "Количество предложений: "     +                          getSentencesCount(fileString)+
   "\n"+ "Количество уникальных слов: "  +                         getUniqueWordsCount(fileString)+
   "\n"+ "Самое часто встречающееся слово: " +                     getMostPopularWord(fileString)
//        "\n"+ "Длинa самого короткого слова: " +                        getLengthOfShortestWord(fileString) +
//        "\n"+ "Длинa самого длинного слова: " +                         getLengthOfLongestWord(fileString) +
//        "\n"+ "Сколько раз каждое слово было встреченно в тексте: " +   getCountForEachWordMeetInText(fileString) +
//        "\n"+ "Сколько раз каждая буква была встреченна в в тексте: " + getCountForEachSymbolMeetInText(fileString)
                     );


        return statistic;
    }

    private String getMostPopularWord(String text) {
        ArrayList<String> mostPopularWords = new ArrayList<>();
        int meetTimes = 0;

        Map<String, Integer> wordsMap = new HashMap <String, Integer>();

        String [] textArr = text.split("\\s*[,|.|!|?|-|:|;|\\s]+\\s*");
        for(int i = 0; i < textArr.length; i++)
        {
            if(!wordsMap.containsKey(textArr[i])) wordsMap.put(textArr[i], 1);
            else
            {
                int count = (int) wordsMap.get(textArr[i]);
                count ++;
                wordsMap.put(textArr[i], count);
            }
        }
        for (Map.Entry<String, Integer> pair : wordsMap.entrySet())
                if(pair.getValue() > meetTimes) meetTimes = pair.getValue();


        for (Map.Entry<String, Integer> pair : wordsMap.entrySet())
        {
            if(pair.getValue() == meetTimes) mostPopularWords.add(pair.getKey());
        }
        System.out.println(meetTimes + " times");
        return mostPopularWords.toString();
    }

    private int getUniqueWordsCount(String text) {

        int uniqueWordsCount = 0;

        Map<String, Integer> wordsMap = new HashMap <String, Integer>();
        String [] textArr = text.split("\\s*[,|.|!|?|-|:|;|\\s]+\\s*");
        for(int i = 0; i < textArr.length; i++)
        {
            if(!wordsMap.containsKey(textArr[i])) wordsMap.put(textArr[i], 1);
            else
            {
                int count = (int) wordsMap.get(textArr[i]);
                count ++;
                wordsMap.put(textArr[i], count);
            }
        }

        for (Map.Entry<String, Integer> pair : wordsMap.entrySet())
        {
            if(pair.getValue() == 1)uniqueWordsCount++;
        }

        return uniqueWordsCount;
    }

    private int getSentencesCount(String text) {
       int sentencesCount = 0;
        char[] charArr = text.toCharArray();

        for( int i = 0; i < charArr.length; i++)
        {
            if(charArr[i] == '.')sentencesCount++;
        }

        return sentencesCount;
    }

    private int getOverWordsCount(String text) {
//        int wordsCount = 0;
        String [] textArr = text.split("\\s*[,|.|!|?|-|:|;|\\s]+\\s*");
        return textArr.length;
    }

    public int getOverSymbolsCount(String text) {
        int symbolsCount = 0;
        text = text.replaceAll("\\s","");
        char[] charArr = text.toCharArray();
        for( int i = 0; i < charArr.length; i++)
        {
             symbolsCount++;
        }
        return symbolsCount ;
    }
}
