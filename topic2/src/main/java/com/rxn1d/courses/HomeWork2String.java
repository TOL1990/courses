package com.rxn1d.courses;

import sun.swing.BakedArrayList;

import java.util.ArrayList;

/**
 * Модифицируйте этот класс(файл)
 *
 * @author Ievgen Tararaka
 */
public class HomeWork2String {
      /**
     * Метод должен вернуть количество четных чисел в строке.
     * <p>Например:
     * дана строка - 1_4_8_11_22, ответ - 3
     *
     * @param s строка типа число1_число2_число3_число4
     * @return количество четных числе в строке
     */
    public static int countEvenInString(String s) {
        String[] pars = s.split("_");
        int count = 0;
        for(int i = 0; i <pars.length;i++)
        {
            if(Integer.parseInt(pars[i]) % 2 == 0)
            {
                count++;
            }
        }

        return count;
    }

    /**
     * Метод должен удалить указанный символ из строки (кроме случая, если
     * символ находится на первой, последней или срединной позиции)
     * <p>Например:
     * данна строка - xabxxxx, символ - x, ответ - xabx
     *
     * @param symbol символ который необходимо удалить
     * @param s      исходная строка
     * @return результирующая строка
     */
    public static String removeSymbolFromString(String symbol, String s) {
        String sec = s;
        String first = String.valueOf(s.charAt(0));
        String last = String.valueOf(s.charAt(s.length()-1));
        String midle = String.valueOf(s.charAt(s.length()/2));
        for (int i =1; i < s.length(); i++)
        {
           // if(symbol == first)
             //   sec.charAt(0) = s.charAt(0);
        }
        return sec;
    }
}
