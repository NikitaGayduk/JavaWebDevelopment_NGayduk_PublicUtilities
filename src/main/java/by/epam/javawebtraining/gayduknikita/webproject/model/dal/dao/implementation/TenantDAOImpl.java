package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public class TenantDAOImpl extends BaseDAO implements TenantDAO {
    private AbstractDAOHandler<Tenant> daoHandler;

    {

        daoHandler = DAOHandlerFactory.getDAOTenantHandler();
    }

    @Override
    public List<Tenant> getAll() throws DAOSQLException {
        return null;
    }

    @Override
    public Tenant get(int id) throws DAOSQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws DAOSQLException {
        return false;
    }

    @Override
    public int add(Tenant entity) throws DAOSQLException {
        LOGGER.warn("Unsupported operation");
        return -1;
    }

    @Override
    public boolean update(Tenant entity) throws DAOSQLException {
        return false;
    }

    @Override
    public Tenant getTenantByAccount(Account account) throws DAOSQLException {
        Connection connection = connectionPool.getConnection();
        try {
            return get(SQLRequestContainer.TENANT_GET_BY_ACCOUNT_ID_QUERY, connection, daoHandler, account.getId());
        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOSQLException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Tenant getOrderTenant(Order order) throws DAOSQLException {
        return null;
    }

    @Override
    public int addTenant(Account account, Tenant tenant) throws DAOSQLException {
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);

            int accountID = add(SQLRequestContainer.ACCOUNT_ADD_QUERY, connection
                    , DAOHandlerFactory.getDAOAccountHandler(), account);
            tenant.setAccountID(accountID);
            add(SQLRequestContainer.TENANT_ADD_QUERY, connection, DAOHandlerFactory.getDAOTenantHandler(), tenant);

            connection.commit();
            return accountID;
        } catch (SQLException e) {
            LOGGER.error("Adding tenant failed", e);
            try {
                connection.rollback();
            } catch (SQLException exc) {
                LOGGER.error("Adding tenant rollback failed", e);
            }
            throw new DAOSQLException(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
