package by.epam.javawebtraining.gayduknikita.webproject.model.entity;

import java.util.Objects;

/**
 * @author NikitaGayduk
 * @date 25.04.2019
 */
public class Street extends Entity {
    private String streetName;

    public Street() {
    }

    public Street(int id, String streetName) {
        super(id);
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Street street = (Street) o;
        return Objects.equals(streetName, street.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), streetName);
    }

    @Override
    public String toString() {
        return "Street{" +
                "streetName='" + streetName + '\'' +
                "} " + super.toString();
    }
}
