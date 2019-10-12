package com.akhudoyarova.entities;

import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name = "loginhash", schema = "public", catalog = "postgres")
public class LoginhashEntity {
    private String hash;
    private int id;
    private String login;

    public LoginhashEntity(String username, String hash) {
        this.login = username;
        this.hash = hash;
        this.id = this.hashCode();
    }

    public LoginhashEntity() {

    }

    @Basic
    @Column(name = "hash", nullable = true, length = 255)
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = true, length = -1)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginhashEntity that = (LoginhashEntity) o;

        if (id != that.id) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hash != null ? hash.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }
}
