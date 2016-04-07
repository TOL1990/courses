package View;

import Dao.CarDao;
import Dao.CarMarketDao;
import Dao.carMarketDaoVerse1;
import Service.DaoServices;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
