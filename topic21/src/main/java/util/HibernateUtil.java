package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Leonid on 05.05.2016.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
//    }    private static SessionFactory sessionFactory = null;
//
//    static {
//        Configuration cfg = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(cfg.getProperties());
////                .applySetting(cfg.getProperty());
//
//        sessionFactory = cfg.buildSessionFactory(builder.build());
//    }
//
//    public static SessionFactory getSessionFactory()
//    {
//        return sessionFactory;
//    }
}
