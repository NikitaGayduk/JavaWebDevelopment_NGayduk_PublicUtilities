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

    public static OrderDAOImpl getInstance() {
        return instance;
    }

    @Override
    public List<Order> getAll() throws DAOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Order get(int id) throws DAOException {
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
    public int add(Order entity) throws DAOException {
        try {
            return add(addSQLQuery, daoHandler, entity);
        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }

    @Override
    public boolean update(Order entity) throws DAOException {
        try {
            return update(updateSQLQuery, daoHandler, entity);
        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }

    @Override
    public List<Order> getOrdersByTenant(Tenant entity) throws DAOException {
        try {
            return getListByID(getByTenantIDSQLQuery, daoHandler, entity.getId());

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }

    @Override
    public List<Order> getOrdersByWorker(Employee entity) throws DAOException {
        try {
            return getListByID(getByWorkerIDSQLQuery, daoHandler, entity.getId());

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }

    @Override
    public List<Order> getAwaiting() throws DAOException {
        try {
            return getAll(getAllAwaitingSQLQuery, daoHandler);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        }
    }
}
