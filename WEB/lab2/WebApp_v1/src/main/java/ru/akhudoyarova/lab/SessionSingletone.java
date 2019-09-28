package ru.akhudoyarova.lab;

import java.util.HashSet;
import java.util.Set;

public class SessionSingletone {

    private Set<String> sessionId;

    private static SessionSingletone instance;

    private SessionSingletone () {
        sessionId = new HashSet<String>();
    }

    public static synchronized SessionSingletone getInstance() { //может вызываться без создания оъекта класса
        if (instance == null) {
            instance = new SessionSingletone();
        }
        return  instance;
    }

    public boolean checkId(String id) { //no static because can't work without object of class
        return sessionId.contains(id);
    }

    public void addId(String id) {
        sessionId.add(id);
    }
}