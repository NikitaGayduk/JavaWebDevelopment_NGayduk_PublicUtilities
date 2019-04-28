package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author NikitaGayduk
 * @date 21.04.2019
 */
public class Tenant extends Entity {
    private String surname;
    private String name;
    private String patronymic;
    private Set<Address> addresses;

    {
        addresses = new HashSet<>();
    }

    public Tenant() {

    }

    public Tenant(int id, String surname, String name, String patronymic, Collection<Address> addresses) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.addresses.addAll(addresses);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses.addAll(addresses);
    }

    public boolean addAddress(Address address){
        return addresses.add(address);
    }

    public boolean delete(Address address){
        return addresses.remove(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(surname, tenant.surname) &&
                Objects.equals(name, tenant.name) &&
                Objects.equals(patronymic, tenant.patronymic) &&
                Objects.equals(addresses, tenant.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), surname, name, patronymic, addresses);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", addresses=" + addresses +
                "} " + super.toString();
    }
}
