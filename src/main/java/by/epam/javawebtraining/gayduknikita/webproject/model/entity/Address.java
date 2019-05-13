package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author NikitaGayduk
 * @date 21.04.2019
 */
public class Address extends Entity {
    private int house;
    private int apartments;
    private String street;
    private Set<Integer> tenantsID;

    {
        tenantsID = new HashSet<>();
    }

    public Address(){

    }

    public Address(int id, int house, int apartments, String street, Collection<Integer> tenantsID) {
        super(id);
        this.house = house;
        this.apartments = apartments;
        this.street = street;
        this.tenantsID.addAll(tenantsID);
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartments() {
        return apartments;
    }

    public void setApartments(int apartments) {
        this.apartments = apartments;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Collection<Integer> getTenantsID() {
        return tenantsID;
    }

    public boolean setTenants(Collection<Integer> tenants) {
        return this.tenantsID.addAll(tenants);
    }

    public boolean addTenant(int tenantID){
        return tenantsID.add(tenantID);
    }

    public boolean deleteTenant(int tenantID){
        return tenantsID.remove(tenantID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return house == address.house &&
                apartments == address.apartments &&
                Objects.equals(street, address.street) &&
                Objects.equals(tenantsID, address.tenantsID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), house, apartments, street, tenantsID);
    }

    @Override
    public String toString() {
        return "Address{" +
                "house=" + house +
                ", apartments=" + apartments +
                ", street=" + street +
                ", tenantsID=" + tenantsID +
                "} " + super.toString();
    }
}
