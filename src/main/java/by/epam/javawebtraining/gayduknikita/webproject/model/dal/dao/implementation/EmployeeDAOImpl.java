package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EmployeeDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {
    private AbstractDAOHandler<Employee> daoHandler;
    private String getAllSQLQuery;
    private String getSQLQuery;
    private String updateSQLQuery;
    private String getAllWorkingSQLQuery;
    private String getByOrderIdSQLQuery;
    private String getFreeDuringTimeSQLQuery;
    private String addOrderWorkerSQLQuery;

    {
        getAllSQLQuery = SQLRequestContainer.EMPLOYEE_GET_ALL_QUERY;
        getSQLQuery = SQLRequestContainer.EMPLOYEE_GET_BY_ID_QUERY;
        updateSQLQuery = SQLRequestContainer.EMPLOYEE_UPDATE_BY_ID_QUERY;
        getAllWorkingSQLQuery = SQLRequestContainer.EMPLOYEE_GET_ALL_WORKS_QUERY;
        getByOrderIdSQLQuery = SQLRequestContainer.EMPLOYEE_GET_BY_ORDER_ID_QUERY;
        getFreeDuringTimeSQLQuery = SQLRequestContainer.EMPLOYEE_GET_FREE_DURING_TIME_QUERY;
        addOrderWorkerSQLQuery = SQLRequestContainer.EMPLOYEE_ORDER_ADD_QUERY;
        daoHandler = DAOHandlerFactory.getDAOEmployeeHandler();
    }

    @Override
    public List<Employee> getAll() throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {

            return getAll(getAllSQLQuery, connection, daoHandler);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public Employee get(int id) throws DAOException {
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
    public int add(Employee entity) throws DAOException {
        return 0;
    }

    @Override
    public boolean update(Employee entity) throws DAOException {
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
    public Employee getEmployeeByAccount(Account account) throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {

            return getByID(SQLRequestContainer.EMPLOYEE_GET_BY_ACCOUNT_ID_QUERY, connection, daoHandler, account.getId()).get(0);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Employee> getEmployeeByOrderId(int id) throws DAOException {
        Connection connection = connectionPool.getConnection();

        try {

            return getByID(SQLRequestContainer.EMPLOYEE_GET_BY_ORDER_ID_QUERY, connection, daoHandler, id);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Employee> getAllWorkingEmployee() throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {

            return getAll(getAllWorkingSQLQuery, connection, daoHandler);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public int addEmployee(Account account, Employee employee) throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {
            connection.setAutoCommit(false);

            int accountID = add(SQLRequestContainer.ACCOUNT_ADD_QUERY, connection
                    , DAOHandlerFactory.getDAOAccountHandler(), account);
            employee.setAccountID(accountID);
            add(SQLRequestContainer.EMPLOYEE_ADD_QUERY, connection, DAOHandlerFactory.getDAOEmployeeHandler(), employee);

            connection.commit();
            return accountID;
        } catch (SQLException e) {
            LOGGER.error("Adding employee failed", e);
            try {
                connection.rollback();
            } catch (SQLException exc) {
                LOGGER.error("Adding employee rollback failed", e);
            }
            throw new DAOException(e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Employee> getAllFreeEmployee(Timestamp begin, Timestamp end) throws DAOException {
        Connection connection = connectionPool.getConnection();
        PreparedStatement statement = null;

        try {
            List<Employee> result = new ArrayList<>();
            statement = connection.prepareStatement(getFreeDuringTimeSQLQuery);
            statement.setTimestamp(1, begin);
            statement.setTimestamp(2, end);
            statement.setTimestamp(3, begin);
            statement.setTimestamp(4, end);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.add(daoHandler.build(rs));
            }

            return result;

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            closeStatement(statement);
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void setOrderWorker(int workerId, int orderId) throws DAOException {
        Connection connection = connectionPool.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(addOrderWorkerSQLQuery);
            statement.setInt(1, orderId);
            statement.setInt(2, workerId);
            statement.executeUpdate();

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            closeStatement(statement);
            connectionPool.releaseConnection(connection);
        }
    }
}
