package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Address;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
class DAOAddressHandler extends AbstractDAOHandler<Address> {

    @Override
    public Address build(ResultSet resultSet) throws SQLException {
        Address address = new Address();
        address.setId(resultSet.getInt(Constants.ADDRESS_ID));
        address.setHouse(resultSet.getInt(Constants.ADDRESS_HOUSE));
        address.setApartments(resultSet.getInt(Constants.ADDRESS_APARTMENTS));
        address.setStreet(resultSet.getString(Constants.STREET_NAME));

        return address;
    }

    @Override
    public void parse(Address entity, PreparedStatement statement, boolean useID) throws SQLException {
        if (entity != null) {
            statement.setInt(1, entity.getHouse());
            statement.setInt(2, entity.getApartments());
            statement.setString(3, entity.getStreet());

            if (useID) {
                statement.setInt(4, entity.getId());
            }
        }
    }
}
