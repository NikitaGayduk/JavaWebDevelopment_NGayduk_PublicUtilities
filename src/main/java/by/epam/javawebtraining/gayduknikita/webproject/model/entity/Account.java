package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import org.apache.log4j.Logger;

import java.util.Objects;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class Account extends Entity {
    private String login;
    private String password;
    private Role role;

    public Account() {
    }

    public Account(int id, String login, String password, Role role) {
        super(id);
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account account = (Account) o;
        return Objects.equals(login, account.login) &&
                Objects.equals(password, account.password) &&
                Objects.equals(role, account.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, role);
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                "} " + super.toString();
    }
}
