package se.is.agriculturalequipment.model;

import java.io.Serializable;

/**
 * Created by BlackClover on 11/2/2017.
 */

public class User implements Serializable {
    private int id;
    private String nameUser, username, password, userRole;

    public User() {
    }

    public User(int id, String nameUser, String username, String password, String userRole) {
        this.id = id;
        this.nameUser = nameUser;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
