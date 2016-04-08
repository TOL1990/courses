package com.rxn1d.courses.service;

import com.rxn1d.courses.Car;
import com.rxn1d.courses.CarParking;

/**
 * Created by Леонид on 22.02.2016.
 */
public class CarParkingDeserializerImpl implements CarParkingDeserializer {

    @Override
    public CarParking deserialize(String jsonStr) {
        CarParking cp = new CarParking();
        cp.setAddress(getAddres(jsonStr));
        cp.setParkingName(getParkingName(jsonStr));
        System.out.println("cp adr = " + cp.getAddress());
        System.out.println("cp adr = " + cp.getParkingName());
        System.out.println("Cars there - " + countCars(jsonStr));

        Car[] cars = new Car[countCars(jsonStr)];
        for(int i = 0; i < cars.length; i++)//забиваем машины
        {
            cars[i] = getCarWithNumber(i,jsonStr);
//            System.out.println("cp Manufacturer = " + cars[i].getManufacturer());
//            System.out.println("cp ModelName = " + cars[i].getModelName());
//            System.out.println("cp Vin = " + cars[i].getVin());
//            System.out.println("cp HeightMillimeters = " + cars[i].getHeightMillimeters());
//            System.out.println("cp LengthMillimeters = " + cars[i].getLengthMillimeters());
        }

        return cp;
    }

    public static String getAddres (String incomStr) {
//        StringBuilder addresStr = new StringBuilder(incomStr.trim()); // переливаем строку и на всякий убиваем пробельчики
//        addresStr.indexOf("\"address\": ");
//        System.out.println(addresStr.toString());
        // System.out.println("getAddres . start!");
        char[] str = incomStr.toCharArray();
        String addresStr = "";

        int count = 0;

        for (int i = 0; i < str.length; i++)
        {
            if(str[i]== '"')
            {
                ++count;
                // System.out.println("count = " + count);

            }// вбиваем счетчик кавычек до 3-х потом записываем последовательность что есть адрес
            //System.out.println("str [i] = " + str[i]);
            if(count == 3)    addresStr += str[i];

        }
        addresStr = removeChar(addresStr, '"');
        //   System.out.println("искомая строка - " + addresStr);
        return addresStr;
    }
    public static String getParkingName (String incomStr) {
//
        char[] str = incomStr.toCharArray();
        String addresStr = "";

        int count = 0;

        for (int i = 0; i < str.length; i++)
        {
            if(str[i]== '"')
            {
                ++count;
                // System.out.println("count = " + count);

            }
            if(count == 7)    addresStr += str[i];

        }
        addresStr = removeChar(addresStr, '"');
        //   System.out.println("искомая строка - " + addresStr);
        return addresStr;
    }

    public static int countCars(String incomStr)
    //Считаем { . кол-во машин это кол-во {  минус один. на открыв клас CarParking
    {
        int countFigureScoupes =0;
        char[] str = incomStr.toCharArray();
        for (int i = 0; i < str.length; i++) {

            if (str[i] == '{') countFigureScoupes++ ;
        }

        return --countFigureScoupes;
    }
    public static Car[] getCars (Car[] cars, String incomStr)
    {
        for(int i = 1; i <= cars.length; i++ )
        {
            cars[i] = getCarWithNumber(i, incomStr);
        }
        return cars;
    }
    public static Car getCarWithNumber (int carNumber,String incomStr)
    {
        Car car = new Car();
//
//        char[] str = incomStr.toCharArray();
//        String [] curCar = new String[countF];
//        String addresStr = "";
//
//        int count = 0;
//        for(int j =0 ; j <countF; j++)//j для перебора и вычленения машины
//        {
//            for (int i = 0; i < str.length; i++)
//            {
//                if (str[i] == '{') count++;
//                if (count == 2) curCar[j] += str[i];
//                if (str[i] == '}') ;
//            }
//        }
//        for (int i = 0; i < str.length; i++)
//        {
//
//            if(countF == )
//            if(str[i]== '"')
//            {
//                ++count;
//                // System.out.println("count = " + count);
//
//            }
//            if(count == 7)    addresStr += str[i];
//
//        }
//        addresStr = removeChar(addresStr, '"');
//        //   System.out.println("искомая строка - " + addresStr);
//        return addresStr;
        incomStr = makeCorrectStrForCar(carNumber, incomStr);
       //  System.out.println("////////////////////////// \n incom str changed =" + incomStr);
        int countKav = 0;
        car.setManufacturer(getManufacturer(incomStr));
        car.setModelName(getModelName(incomStr));
        car.setVin(getVin(incomStr));
        car.setLengthMillimeters(getLengthMillimeters(incomStr));
        car.setHeightMillimeters(getHeightMillimeters(incomStr));
        return car;
    }

    private static int getLengthMillimeters(String incomStr) {
        return 0;
    }
    private static int getHeightMillimeters(String incomStr) {
//        char[] str = incomStr.toCharArray();
//        String addresStr = "";
//
//        int count = 0; // колво : для обрезки строки
//        int countZap = 0;
//        System.out.println("Obrab stroka" + incomStr);
//
//        for (int i = 0; i < str.length; i++)
//        {
//            if(str[i] == ':') count++;
//
//            if(str[i] == ',') countZap++;
//
//            if(count == 4) addresStr += str[i];
//
//            if(countZap == 4) count++; // Переподляем условие для записи
//
//        }
//
//        addresStr = removeChar(addresStr, ':');
//        addresStr = removeChar(addresStr, ',');
//        addresStr = addresStr.trim();
//        System.out.println("искомая длинна -" + addresStr + "-");
////        int i = Integer.parseInt(addresStr);
//        String string = new String(new StringBuilder(addresStr));
//
//        for(int s = 0; s<addresStr.length(); s++)
//        {
//            System.out.println("addresStr[i] = " + addresStr.charAt(s));
//            string +=addresStr.charAt(s);
//        }
//        // string.equals(addresStr);
//     //   int i = Integer.parseInt(string);
//        //  System.out.println("i =" + i);
//        System.out.println("-" + addresStr + "-");
        return 0;

    }

    private static String getVin(String incomStr) {
        char[] str = incomStr.toCharArray();
        String addresStr = "";

        int count = 0; // колво " для обрезки строки

        for (int i = 0; i < str.length; i++)
        {
            if(str[i]== '"')
            {
                ++count;
                // System.out.println("count = " + count);

            }
            if(count == 9)    addresStr += str[i];

        }
        addresStr = removeChar(addresStr, '"');
        //   System.out.println("искомая строка - " + addresStr);
        return addresStr;

    }

    private static String getModelName(String incomStr)
    {
        char[] str = incomStr.toCharArray();
        String addresStr = "";

        int count = 0; // колво " для обрезки строки

        for (int i = 0; i < str.length; i++)
        {
            if(str[i]== '"')
            {
                ++count;
                // System.out.println("count = " + count);

            }
            if(count == 6)    addresStr += str[i];

        }
        addresStr = removeChar(addresStr, '"');
        //   System.out.println("искомая строка - " + addresStr);
        return addresStr;

    }

    private static String makeCorrectStrForCar(int carNumber, String incomStr) {
        String corect= "";
        char[] str = incomStr.toCharArray();
        int countScopeStart = carNumber;//{
        int countScopeEnd= carNumber;

//        System.out.println("makeCorrectStrForCar");
//        System.out.println("makeCorrectStrForCar(int carNumber, String incomStr) incomStr =  " + incomStr);
        for(int  i = 0; i<str.length; i++)
        {
            if(str[i] =='{') countScopeStart++;

            if(countScopeStart - carNumber == 1) corect +=str[i];

            if(str[i] == '}') countScopeEnd ++;

            if(carNumber - countScopeEnd == 0) countScopeStart++; //как тольлко дойдем до конца текущей машины
            // увеличем условие записи в нее countScopeStart++
        }
        System.out.println("makeCorrectStrForCar");
        System.out.println("correctStr =  " + corect);
        return corect;
    }

    public static String removeChar(String s, char c) {
        String r = "";
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != c) r += s.charAt(i);
        }
        return r;
    }

    public static String getManufacturer (String incomStr)
    {
        char[] str = incomStr.toCharArray();
        String addresStr = "";

        int count = 0;

        for (int i = 0; i < str.length; i++)
        {
            if(str[i]== '"')
            {
                ++count;
                // System.out.println("count = " + count);

            }
            if(count == 3)    addresStr += str[i];

        }
        addresStr = removeChar(addresStr, '"');
        //   System.out.println("искомая строка - " + addresStr);
        return addresStr;

    }


}
