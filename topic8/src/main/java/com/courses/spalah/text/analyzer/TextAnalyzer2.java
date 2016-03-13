package com.courses.spalah.text.analyzer;

import java.io.*;

/**
 * Created by Тарас on 13.03.2016.
 */
public class TextAnalyzer2 {
    private File file;
    private String fileString;

    public TextAnalyzer2() {
        fileString = readFromFile("topic8\\src\\main\\resources\\text_sample.txt");
        writeStatsToFile("topic8\\src\\main\\resources\\output.txt");
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
    private String FileToStrWords(File file)
    {
        return null;
    }
    private String FileToStrNoSpaces(File file)
    {
        return null;
    }

    private String getAllStatistic()
    {
        String statistic;

        //Вызов методов по получению статы

        statistic = (
        "Общее количество символов: " +                           getOverSymbolsCount() +
        "Количество слов: " +                                     getOverWordsCount()+
        "Количество предложений: "     +                          getSentencesCount()+
        "Количество уникальных слов: "  +                         getUniqueWordsCount() +
        "Самое часто встречающееся слово: " +                     getMostPopularWord()+
        "Длинa самого короткого слова: " +                        getLengthOfShortestWord() +
        "Длинa самого длинного слова: " +                         getLengthOfLongestWord() +
        "Сколько раз каждое слово было встреченно в тексте: " +   getCountForEachWordMeetInText() +
        "Сколько раз каждая буква была встреченна в в тексте: " + getCountForEachSymbolMeetInText() );


        return statistic;
    }

}
