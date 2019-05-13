package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.util.Objects;

/**
 * @author NikitaGayduk
 * @date 21.04.2019
 */
public class Tenant extends Entity {
    private String surname;
    private String name;
    private String patronymic;
    private int accountID;
    private int addressID;

    public Tenant() {

    }

    public Tenant(int id, String surname, String name, String patronymic, int accountID, int addressID) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.accountID = accountID;
        this.addressID = addressID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tenant tenant = (Tenant) o;
        return accountID == tenant.accountID &&
                addressID == tenant.addressID &&
                Objects.equals(surname, tenant.surname) &&
                Objects.equals(name, tenant.name) &&
                Objects.equals(patronymic, tenant.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), surname, name, patronymic, accountID, addressID);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", accountID=" + accountID +
                ", addressID=" + addressID +
                "} " + super.toString();
    }
}
