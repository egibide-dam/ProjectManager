package com.proyecto.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {



    public static void guardar(Object object) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        sesion.save(object);

        trans.commit();
        sesion.close();
        sf.close();
    }


    public static void editar(Object object) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        sesion.update(object);

        trans.commit();
        sesion.close();
        sf.close();
    }

    public static void eliminar(Object object) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        sesion.delete(object);

        trans.commit();
        sesion.close();
        sf.close();
    }



}
