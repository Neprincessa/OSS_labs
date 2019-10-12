package com.akhudoyarova.dao;

import com.akhudoyarova.entities.LoginhashEntity;
import com.akhudoyarova.server.SessionFactoryManager;
import org.hibernate.*;

import java.util.List;

public class LoginHash_dao {

    private SessionFactory factory;

    public LoginHash_dao() {
        this.factory = SessionFactoryManager.getSessionFectory();
    }

    public boolean addLoginHash(String username, String hash) {
        boolean done = true;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        LoginhashEntity loginHash = new LoginhashEntity(username, hash);
        try {
            session.save(loginHash);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            done = false;
        }
        finally {
            session.close();
        }
        return done;
    }

    public boolean existLoginHash(String username, String hash) {
        boolean existance = false;
        Session session = factory.openSession();
        session.beginTransaction();

        List<LoginhashEntity> loginhashList = (List<LoginhashEntity>) session.createQuery("FROM LoginhashEntity  WHERE login = \'" + username + "\'").list();
        for (LoginhashEntity tmp : loginhashList) {
            if (tmp.getHash().equals(hash)) {
                existance = true;
            }
        }
        session.close();
        return existance;
    }

    public boolean existHashTable(String hash) {
        boolean existance = false;
        Session session = factory.openSession();
        session.getTransaction();
        List<LoginhashEntity> loginhashList = (List<LoginhashEntity>) session.createQuery("FROM LoginhashEntity  WHERE hash = \'" + hash + "\'").list();
        for (LoginhashEntity tmp : loginhashList) {
            if (tmp.getHash().equals(hash)) {
                existance = true;
            }
        }
        return existance;
    }
}
