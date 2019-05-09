package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AddressDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.BaseDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Address;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class BaseAddressDAO extends BaseDAO implements AddressDAO {

    @Override
    public List<Address> getAll() throws DAOSQLException {
        return null;
    }

    @Override
    public Address get(Integer id) throws DAOSQLException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAOSQLException {
        return false;
    }

    @Override
    public int add(Address entity) throws DAOSQLException {
        return 0;
    }

    @Override
    public boolean update(Address entity) throws DAOSQLException {
        return false;
    }

    @Override
    public Address getAddressByTenant(Tenant tenant) throws DAOSQLException {
        // TODO: 09.05.2019 statement close try-catch
        Connection connection = getConnection();
        PreparedStatement statement = null;
        Address address = null;

        try{
            connection = getConnection();
            statement = connection.prepareStatement(SQLRequestContainer.GET_TENANT_ADDRESS);

            statement.setInt(1, tenant.getId());
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();

            if(resultSet.next()){
                address = new Address();
                address.setId(resultSet.getInt(1));
                address.setHouse(resultSet.getInt(2));
                address.setApartments(resultSet.getInt(3));
                address.setStreet(resultSet.getString(4));
            }

            resultSet.close();
            statement.close();

            return address;

        } catch (SQLException exc){
            throw new DAOSQLException(exc);
        } finally {
            if(connection != null) {
                releaseConnection(connection);
            }
        }
    }
}
