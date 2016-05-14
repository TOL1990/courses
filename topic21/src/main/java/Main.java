import dao.Factory;
import entity.Car;
import entity.Owner;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Leonid on 05.05.2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Owner master = null;
        Collection owners = Factory.getInstance().getOwnerDAO().getAllOwners();
        Iterator iterator = owners.iterator();
        System.out.println("========Все Владельцы=========");
        while (iterator.hasNext()) {
            Owner owner = (Owner) iterator.next();
            if (owner.getFirstName().equals("Barak")) {
//                System.out.println("Нашелся дурачек");
                master = owner;
//                System.out.println("Владелец : " + master.getFirstName() + " " + master.getLastName() + "  Номер mobile : " + master.getTel());

            }
            System.out.println("Владелец : " + owner.getFirstName() + " " + owner.getLastName() + "  Номер mobile : " + owner.getTel());
        }
//        Owner barak = Factory.getInstance().getOwnerDAO().findOwnerByFirstName("Barak");
//        System.out.println("durachek"+" " + barak.getLastName());


        Collection cars = Factory.getInstance().getCarDAO().getCarsByOwner(master);
        Iterator iterator1 = cars.iterator();
        System.out.println("========Все машинки владельцев=========");
        while (iterator1.hasNext()) {
            Car car = (Car) iterator1.next();
            System.out.println(car.getDeveloper());
        }


    }


}

