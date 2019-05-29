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

    public static TenantDAOImpl getInstance() {
        return instance;
    }

    @Override
    public List<Tenant> getAll() throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tenant get(int id) throws DAOException {
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
    public int add(Tenant entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Tenant entity) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tenant getTenantByAccount(Account account) throws DAOException {
        try {

            return getByID(SQLRequestContainer.TENANT_GET_BY_ACCOUNT_ID_QUERY, daoHandler, account.getId());

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }

    @Override
    public Tenant getOrderTenant(Order order) throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int addTenant(Account account, Tenant tenant) throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);

            int accountID = addTransact(SQLRequestContainer.ACCOUNT_ADD_QUERY, connection
                    , DAOHandlerFactory.getDAOAccountHandler(), account);
            tenant.setAccountID(accountID);

            int tenantID = addTransact(SQLRequestContainer.TENANT_ADD_QUERY, connection
                    , DAOHandlerFactory.getDAOTenantHandler(), tenant);

            tenant.setId(tenantID);

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
