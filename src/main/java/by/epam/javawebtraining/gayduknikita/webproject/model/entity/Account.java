package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import org.apache.log4j.Logger;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class Account extends Entity {
    private String login;
    private String password;
    private String role;

    public Account() {
    }

    public Account(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
