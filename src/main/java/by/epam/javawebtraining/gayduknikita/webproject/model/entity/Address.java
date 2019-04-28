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
    private Street street;
    private Set<Tenant> tenants;

    {
        tenants = new HashSet<>();
    }

    public Address(){

    }

    public Address(int id, int house, int apartments, Street street, Collection<Tenant> tenants) {
        super(id);
        this.house = house;
        this.apartments = apartments;
        this.street = street;
        this.tenants.addAll(tenants);
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

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Collection<Tenant> getTenants() {
        return tenants;
    }

    public boolean setTenants(Collection<Tenant> tenants) {
        return this.tenants.addAll(tenants);
    }

    public boolean addTenant(Tenant tenant){
        return tenants.add(tenant);
    }

    public boolean deleteTenant(Tenant tenant){
        return tenants.remove(tenant);
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
                Objects.equals(tenants, address.tenants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), house, apartments, street, tenants);
    }

    @Override
    public String toString() {
        return "Address{" +
                "house=" + house +
                ", apartments=" + apartments +
                ", street=" + street +
                ", tenants=" + tenants +
                "} " + super.toString();
    }
}
