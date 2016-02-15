package com.rxn1d.courses;

/**
 * @author Ievgen Tararaka
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println("---> START Calculator application <---");

        // для того, чтобы читать данные из консоли спользуйте данную конструкцию
        String[] in = ConsoleReader.readFromConsole();
        //System.out.println("---> EXIT Calculator application <---");

        double result=0;
        double first = Double.parseDouble(in[0]);
        double second = Double.parseDouble(in[2]);
        boolean isExit = true;

        result = calc(first,second,in[1]);
        System.out.println("Result = " + result);

        while (isExit) //проверяем пока не exit
        {
            in = ConsoleReader.readFromConsole();
            if (in[0].equals("exit")) {
                //   System.out.println("If s exit");
                isExit = false;
            }
            else {
                //System.out.println("While start");
                first = result;
                second = Double.parseDouble(in[1]);
//                System.out.println("first = " + first);
//                System.out.println("Second = " + second);
//                System.out.println("Znak = " + in[0]);
                result = calc(first, second, in[0]);

                System.out.println("Result = " + result);
            }

        }
        System.out.println("---> EXIT Calculator application <---");
    }
    public static double calc(double fst, double scnd, String zn)
    {

        if(zn.equals("+"))
            return fst + scnd;
        if(zn.equals("-"))
            return fst - scnd;
        if(zn.equals("/"))
            return fst / scnd;
        if(zn.equals("*"))
            return fst * scnd;
        else {
            System.out.println("Вы ввели Дибильный знак. Возвращаю 0   = " + zn);
            return 0;
        }
    }
}
