package com.akhudoyarova.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryManager {

    private static SessionFactory factory;

    private SessionFactoryManager() {
    }

    public static synchronized SessionFactory getSessionFectory() {
        if (factory == null) {
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory;
    }

}
