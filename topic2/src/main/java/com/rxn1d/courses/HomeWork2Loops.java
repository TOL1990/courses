package com.rxn1d.courses;

/**
 * Модифицируйте этот класс(файл)
 *
 * @author Ievgen Tararaka
 */
public class HomeWork2Loops {
    /**
     * Метод должен вернуть минимальное число
     * из заданного массива.
     * <p>Например:
     * вернуть число=3 при заданном массиве=[5, 4, 3, 4, 5]
     *
     * @param integers заданный массив типа int[]
     * @return минимальное число из массива
     */
    public static int min(int[] integers)
    {
        int numb = integers[0];
        for(int i = 0; i < integers.length; i++)
        {
            if(numb > integers[i])
                numb = integers[i];
        }
        return numb;
    }

    /**
     * Метод должен вернуть максимальное число
     * из заданного массива.
     * <p>Например:
     * вернуть число=6.0 при заданном массиве=[5.1, 4.33, 3.0, 6.0, 5.999]
     *
     * @param doubles заданный массив типа double[]
     * @return максимальное число из массива
     */
    public static double max(double[] doubles) {

        double numb = doubles[0];
        for(int i = 0; i < doubles.length; i++)
        {
            if(numb < doubles[i])
                numb = doubles[i];
        }
        return numb;
    }

    /**
     * Метод должен вернуть среднее арифмитическое число
     * из заданного массива.
     * <p>Например:
     * вернуть число=8 при заданном массиве=[1, 3, 8, 10, 25, 1]
     *
     * @param shorts заданный массив типа short[]
     * @return среднее арифмитическое число из массива
     */
    public static short average(short[] shorts) {
        short numb = shorts[0];
        for(int i = 1; i < shorts.length; i++)
        {
            numb += shorts[i];
        }
        return (short) (numb/shorts.length);
    }

    /**
     * Метод должен перевернуть массив.
     * <p>Например:
     * вернуть массив=[f, e, d, c, b, a] из заданного массива=[a, b, c, d, e, f]
     *
     * @param chars заданный массив типа char[]
     * @return перевернутый массив
     */
    public static char[] reverse(char[] chars) {
        char [] big = new char[chars.length];

        for(int i = 0; i<chars.length;i++)
        {
            big[chars.length - i - 1] = chars[i];
        }
        return big;
    }
}
