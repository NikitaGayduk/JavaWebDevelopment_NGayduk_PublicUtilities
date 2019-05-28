package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public class TenantDAOImpl extends BaseDAO implements TenantDAO {
    private static final TenantDAOImpl instance = new TenantDAOImpl();
    private AbstractDAOHandler<Tenant> daoHandler;
    private String getSQLQuery;

    {
        getSQLQuery = SQLRequestContainer.TENANT_GET_BY_ID_QUERY;
        daoHandler = DAOHandlerFactory.getDAOTenantHandler();
    }

    private TenantDAOImpl() {
    }

    public static TenantDAOImpl getInstance(){
        return instance;
    }

    @Override
    public List<Tenant> getAll() throws DAOException {
        return null;
    }

    @Override
    public Tenant get(int id) throws DAOException {
        Connection connection = connectionPool.getConnection();

        try {
            return getByID(getSQLQuery, connection, daoHandler, id).get(0);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public boolean delete(int id) throws DAOException {
        return false;
    }

    @Override
    public int add(Tenant entity) throws DAOException {
        LOGGER.warn("Unsupported operation");
        return -1;
    }

    @Override
    public boolean update(Tenant entity) throws DAOException {
        return false;
    }

    @Override
    public Tenant getTenantByAccount(Account account) throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {

            return getByID(SQLRequestContainer.TENANT_GET_BY_ACCOUNT_ID_QUERY, connection, daoHandler, account.getId()).get(0);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Tenant getOrderTenant(Order order) throws DAOException {
        return null;
    }

    @Override
    public int addTenant(Account account, Tenant tenant) throws DAOException {
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
            throw new DAOException(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }

    }
}
