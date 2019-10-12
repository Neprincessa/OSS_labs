package com.akhudoyarova.dao;

import com.akhudoyarova.entities.LoginhashEntity;
import com.akhudoyarova.entities.LoginpasswordEntity;
import com.akhudoyarova.server.SessionFactoryManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;

public class LoginPass_dao {

    private SessionFactory factory;

    public LoginPass_dao() {
        this.factory = SessionFactoryManager.getSessionFectory();
    }

    public boolean addLoginPasswd(String username, String password) {
        boolean done = true;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        LoginpasswordEntity loginPassword = new LoginpasswordEntity(username, password);
        try {
            session.save(loginPassword);
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

    public HashSet<String> getAll() {
        HashSet<String> allUsers = new HashSet<>();

        Session session = factory.openSession();
        session.beginTransaction();

        List<LoginpasswordEntity> loginPassList = (List<LoginpasswordEntity>) session.createQuery("FROM LoginpasswordEntity  WHERE login != null").list();
        for (LoginpasswordEntity tmp : loginPassList) {
            allUsers.add(tmp.getLogin());
        }

        session.close();
        return allUsers;
    }

    public boolean checkExistance(String login) {
        Session session = factory.openSession();
        boolean existance = false;
        session.beginTransaction();
        List<LoginpasswordEntity> loginPassList = (List<LoginpasswordEntity>) session.createQuery("FROM LoginpasswordEntity  WHERE login = \'" + login + "\'").list();
        for (LoginpasswordEntity tmp : loginPassList) {
            if (tmp.getLogin().equals(login)) {
                existance = true;
            }
        }
        session.close();
        return existance;
    }

    public boolean existLoginPass(String username, String password) {
        boolean existance = false;
        Session session = factory.openSession();
        session.beginTransaction();
//        LoginhashEntity loginPassword = new LoginhashEntity(username, hash);

//        LoginpasswordEntity tmpLoginPass= session.get(LoginpasswordEntity.class, username);
//        if (tmpLoginPass != null) {
//            if (tmpLoginPass.getPassword().equals(password)) {
//                existance = true;
//            }
//        }
//
        List<LoginpasswordEntity> loginPassList = (List<LoginpasswordEntity>) session.createQuery("FROM LoginpasswordEntity  WHERE login = \'" + username + "\'").list();
        for (LoginpasswordEntity tmp : loginPassList) {
            if (tmp.getPassword().equals(password)) {
                existance = true;
            }
        }
        session.close();
        return existance;
    }

//    public boolean existHashTable(String hash) {
//        boolean existance = false;
//        Session session = factory.openSession();
//        session.getTransaction();
//        List<LoginhashEntity> loginhashList = (List<LoginhashEntity>) session.createQuery("FROM loginhash").list();
//        for (LoginhashEntity tmp : loginhashList) {
//            if (tmp.getHash().equals(hash)) {
//                existance = true;
//            }
//        }
//        return existance;
//    }


}
