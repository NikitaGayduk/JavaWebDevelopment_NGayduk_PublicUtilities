package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.BaseDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EntityDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Entity;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public class BaseTenantDAO extends BaseDAO implements TenantDAO {
    @Override
    public List<Tenant> getAll() throws DAOSQLException {
        return null;
    }

    @Override
    public Tenant get(Integer id) throws DAOSQLException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAOSQLException {
        return false;
    }

    @Override
    public int add(Tenant entity) throws DAOSQLException {
        return 0;
    }

    @Override
    public boolean update(Tenant entity) throws DAOSQLException {
        return false;
    }

    @Override
    public Tenant getTenantByOrder(Order order) throws DAOSQLException {
        // TODO: 09.05.2019 statement close try-catch
        Connection connection = getConnection();
        PreparedStatement statement = null;
        Tenant tenant = null;

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