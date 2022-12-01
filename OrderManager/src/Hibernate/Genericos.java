package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Genericos {

    public static Configuration getConfig() {
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration;
    }

    public static void save(Object object) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Save object
        session.save(object);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


}
