package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.OrderDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO {
    private static final OrderDAOImpl instance = new OrderDAOImpl();
    private AbstractDAOHandler<Order> daoHandler;
    private String getAllSQLQuery;
    private String getSQLQuery;
    private String deleteSQLQuery;
    private String addSQLQuery;
    private String updateSQLQuery;
    private String getByTenantIDSQLQuery;
    private String getByWorkerIDSQLQuery;
    private String getAllAwaitingSQLQuery;

    {
        daoHandler = DAOHandlerFactory.getDAOOrderHandler();
        getAllSQLQuery = SQLRequestContainer.ORDER_GET_ALL_QUERY;
        getSQLQuery = SQLRequestContainer.ORDER_GET_BY_ID_QUERY;
        deleteSQLQuery = SQLRequestContainer.ORDER_DELETE_BY_ID_QUERY;
        addSQLQuery = SQLRequestContainer.ORDER_ADD_QUERY;
        updateSQLQuery = SQLRequestContainer.ORDER_UPDATE_BY_ID_QUERY;
        getByTenantIDSQLQuery = SQLRequestContainer.ORDER_GET_BY_TENANT_ID_QUERY;
        getByWorkerIDSQLQuery = SQLRequestContainer.ORDER_GET_BY_WORKER_ID_QUERY;
        getAllAwaitingSQLQuery = SQLRequestContainer.ORDER_GET_ALL_AWAITING_QUERY;
    }

    private OrderDAOImpl() {
    }

    public static OrderDAOImpl getInstance(){
        return instance;
    }

    @Override
    public List<Order> getAll() throws DAOException {
        return null;
    }

    @Override
    public Order get(int id) throws DAOException {
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
    public int add(Order entity) throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {
            return add(addSQLQuery, connection, daoHandler, entity);
        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public boolean update(Order entity) throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {
            return update(updateSQLQuery, connection, daoHandler, entity);
        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Order> getOrdersByTenant(Tenant entity) throws DAOException {
        Connection connection = connectionPool.getConnection();

        try {
            return getByID(getByTenantIDSQLQuery, connection, daoHandler, entity.getId());

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Order> getOrdersByWorker(Employee entity) throws DAOException {
        Connection connection = connectionPool.getConnection();

        try {
            return getByID(getByWorkerIDSQLQuery, connection, daoHandler, entity.getId());

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Order> getAwaiting() throws DAOException {
        Connection connection = connectionPool.getConnection();

        try {
            return getAll(getAllAwaitingSQLQuery, connection, daoHandler);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
