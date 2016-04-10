package home12.View;

import home12.Service.DaoServices;

import java.util.ArrayList;

/**
 * Created by Leonid on 31.03.2016.
 */
public class MainWindow {
    public static void main(String[] args) throws Exception {

        DaoServices cm = new DaoServices();
//                cm.addOwner("Denny","Devito","3-12-745-335");
//

//        cm.addCar("Nisan", "Quashcai", "142-66 AE", 2002, "", 11);
        ArrayList arrayList = (ArrayList) cm.getAllCars();
        System.out.println(arrayList);
    }

}
