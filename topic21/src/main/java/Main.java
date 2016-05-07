import dao.Factory;
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


        Collection owners = Factory.getInstance().getOwnerDAO().getAllOwners();
        Iterator iterator = owners.iterator();
        System.out.println("========Все Владельцы=========");
        while (iterator.hasNext())
        {
            Owner owner = (Owner) iterator.next();
            System.out.println("Владелец : " + owner.getFirstName() + " " + owner.getLastName() + "  Номер mobile : " + owner.getTel());
        }
    }


}

