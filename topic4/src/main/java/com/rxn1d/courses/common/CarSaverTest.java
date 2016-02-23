package com.rxn1d.courses.common;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

import java.io.*;

/**
 * Created by Леонид on 18.02.2016.
 */
public class CarSaverTest {
    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "  \"address\": \"Gagarina avenue 1\",\n" +
                "  \"parkingName\": \"Parking #1\",\n" +
                "  \"cars\": [\n" +
                "    {\n" +
                "      \"manufacturer\": \"Mazda\",\n" +
                "      \"modelName\": \"Mazda3\",\n" +
                "      \"vin\": \"ABC123456\",\n" +
                "      \"lengthMillimeters\": 4555,\n" +
                "      \"heightMillimeters\": 3000\n" +
                "    },\n" +
                "    {\n" +
                "      \"manufacturer\": \"Volvo\",\n" +
                "      \"modelName\": \"V40\",\n" +
                "      \"vin\": \"CBE99999\",\n" +
                "      \"lengthMillimeters\": 5300,\n" +
                "      \"heightMillimeters\": 3155\n" +
                "    }\n" +
                "  ]\n" +
                "}";
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
       }
        }
    public void myTetstSerializationAndDeserialization() {
        Car one = new Car("Ferarri", "458", "F458-111", 4800, 2800);
        Car two = new Car("Ваз", "2106", "АЕ149-16АА", 3700, 2500);

        //Пихаем сериализованные обьекты в файл Car.ser
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Car.ser"));
            os.writeObject(one);
            os.writeObject(two);

        } catch (IOException e) {
            e.printStackTrace();
        }

        one = null;
        two = null;


        //вынимаем обьекты из Car.ser

        try {
            ObjectInputStream fs = new ObjectInputStream(new FileInputStream("Car.ser"));

            Car oneRestore = (Car) fs.readObject();
            Car twoRestore = (Car) fs.readObject();

            System.out.println("Тип первого - " + oneRestore.getManufacturer());
            System.out.println("Тип второго - " + twoRestore.getManufacturer());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
      //  Считаем что в инком стринге порезанная до нужно нам
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
      //  System.out.println("incom str changed" + incomStr);
        int countKav = 0;
        car.setManufacturer(getManufacturer(incomStr));
        car.setModelName(getModelName(incomStr));
        car.setVin(getVin(incomStr));
        car.setLengthMillimeters(getLengthMillimeters(incomStr));
        System.out.println("Car letn = " + car.getLengthMillimeters());
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
//       addresStr = addresStr.trim();
//        System.out.println("искомая длинна -" + addresStr + "-");
//       int i = Integer.parseInt(addresStr);
//        String string = new String();
//
//        for(int s = 0; s<addresStr.length(); s++)
//                {
//                    System.out.println("addresStr[i] = " + addresStr.charAt(s));
//                    string +=addresStr.charAt(s);
//                }
//       // string.equals(addresStr);
//        // i = Integer.parseInt(string);
//      //  System.out.println("i =" + i);
//        System.out.println("-" + addresStr + "-");

        char[] str = incomStr.toCharArray();
       String addresStr = "";
        int count = 0; // колво : для обрезки строки
        int countZap = 0;

        int begin=0, end=0;


        for (int i = 0; i < str.length; i++)
        {
            if(str[i] == ':') count++;

            if(str[i] == ',') countZap++;

            if(count == 4) addresStr += str[i];

            if(countZap == 4) count++; // Переподляем условие для записи

        }
        addresStr = addresStr.replaceAll("\\s+", "");
        addresStr = removeChar(addresStr, ':');
        addresStr = removeChar(addresStr, ',');
        addresStr = removeChar(addresStr, '"');
        System.out.println("adr str =" + addresStr + "=");

        int cd = Integer.parseInt(addresStr);
       System.out.println("Integer = " + cd);

        return cd;

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
        int countScopeStart = 0;//{
        int countScopeEnd= 0;
        for(int  i = 0; i<str.length; i++)
        {
            if(str[i] =='{') countScopeStart++;

            if(countScopeStart - carNumber == 1) corect +=str[i];

            if(str[i] == '}') countScopeEnd ++;

            if(carNumber - countScopeEnd == 0) countScopeStart++; //как тольлко дойдем до конца текущей машины
                                                                    // увеличем условие записи в нее countScopeStart++
        }
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
