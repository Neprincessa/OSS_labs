package com.akhudoyarova.entities;

import javax.persistence.*;

@Entity
@Table(name = "loginpassword", schema = "public", catalog = "postgres")
public class LoginpasswordEntity {
    private String password;
    private int id;
    private String login;

    public LoginpasswordEntity(String username, String password) {
        this.login = username;
        this.password = password;
        this.id = this.hashCode();
    }

    public LoginpasswordEntity() {

    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        LoginpasswordEntity that = (LoginpasswordEntity) o;

        if (id != that.id) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }
}
