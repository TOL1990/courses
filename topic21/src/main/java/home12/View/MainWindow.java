package main.java.home12.View;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import home12.Service.DaoServices;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;

/**
 * Created by Leonid on 31.03.2016.
 */
public class MainWindow {
    public static void main(String[] args) throws Exception {

        DaoServices cm = new DaoServices();
//                cm.addOwner("Denny","Devito","3-12-745-335");
//                cm.getAllOwners();
//

//        cm.addCar("Nisan", "Quashcai", "142-66 AE", 2002, "", 11);
        ArrayList arrayList = (ArrayList) cm.getAllOwners();
        System.out.println(arrayList);
//        jsonfunc();
    }
/*
    private static void jsonfunc() {
        String json = "{paramsArray: [\"first\", 100],"
                + "paramsObj: {one: \"two\", three: \"four\"},"
                + "paramsStr: \"some string\"}";

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println(jsonObj.get("paramsStr"));
// some string

        JsonObject jo = jsonObj.get("paramsObj");
        System.out.println(jo.get("three"));
// four

        JsonArray ja = jsonObj.get("paramsArray");
        System.out.println(ja.get(1));
    }
*/
}
