package com.proyecto.utils;

import com.proyecto.PiezasEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {

    public static List<Object> leerTodos(Class clase) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        //Get object
        List<Object> objects = sesion.createQuery("from " + clase.getName()).list();

        trans.commit();
        sesion.close();
        sf.close();

        return objects;
    }

    public static Object leerObjeto(Class clase, int id) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        //Get object
        Object object = sesion.get(clase, id);

        trans.commit();
        sesion.close();
        sf.close();

        return object;
    }

    public static Boolean guardar(Object object) {
        try {
            Configuration config = new Configuration();
            config.configure();
            SessionFactory sf = config.buildSessionFactory();
            Session sesion = sf.openSession();
            Transaction trans = sesion.beginTransaction();

            sesion.save(object);

            trans.commit();
            sesion.close();
            sf.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }


    public static Boolean actualizar(Object object) {
        try {
            Configuration config = new Configuration();
            config.configure();
            SessionFactory sf = config.buildSessionFactory();
            Session sesion = sf.openSession();
            Transaction trans = sesion.beginTransaction();

            sesion.update(object);

            trans.commit();
            sesion.close();
            sf.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }


    public static List<Object> filtrar(Class clase, String sentencia) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        //Get object
        List<Object> objects = sesion.createQuery("from " + clase.getName() + " " + sentencia).list();

        trans.commit();
        sesion.close();
        sf.close();

        return objects;
    }


    public static List<Integer> sentenciaEspecial(String sentencia) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        List<Integer> objects = sesion.createNativeQuery(sentencia).list();

        trans.commit();
        sesion.close();
        sf.close();

        return objects;
    }

    public static List<Object> sentenciaTop5(String sentencia) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session sesion = sf.openSession();
        Transaction trans = sesion.beginTransaction();

        List<Object> objects = sesion.createNativeQuery(sentencia).list();

        trans.commit();
        sesion.close();
        sf.close();

        return objects;
    }


}
