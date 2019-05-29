package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AddressDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Address;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class AddressDAOImpl extends BaseDAO implements AddressDAO {
    private static final AddressDAOImpl instance = new AddressDAOImpl();
    private AbstractDAOHandler<Address> daoHandler;
    private String getAllSQLQuery;
    private String getSQLQuery;
    private String deleteSQLQuery;
    private String addSQLQuery;
    private String updateSQLQuery;

    {
        getAllSQLQuery = SQLRequestContainer.ADDRESS_GET_ALL_QUERY;
        getSQLQuery = SQLRequestContainer.ADDRESS_GET_BY_ID_QUERY;
        deleteSQLQuery = SQLRequestContainer.ADDRESS_DELETE_BY_ID_QUERY;
        addSQLQuery = SQLRequestContainer.ADDRESS_ADD_QUERY;
        updateSQLQuery = SQLRequestContainer.ADDRESS_UPDATE_BY_ID_QUERY;
        daoHandler = DAOHandlerFactory.getDAOAddressHandler();
    }

    private AddressDAOImpl() {
    }

    public static AddressDAOImpl getInstance() {
        return instance;
    }

    @Override
    public List<Address> getAll() throws DAOException {
        try {
            return getAll(getAllSQLQuery, daoHandler);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }

    @Override
    public Address get(int id) throws DAOException {
        try {
            return getByID(getSQLQuery, daoHandler, id);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }

    @Override
    public boolean delete(int id) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int add(Address entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Address entity) throws DAOException {
        throw new UnsupportedOperationException();
    }
}
