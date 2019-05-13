package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.BaseDBConnectionPool;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.DBConnectionPool;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.BaseDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Entity;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 11.05.2019
 */
public class BaseDAOImpl<K extends Integer,T extends Entity> implements BaseDAO<K,T> {
    protected static final Logger LOGGER = Logger.getRootLogger();
    protected static final DBConnectionPool connectionPool = BaseDBConnectionPool.getInstance();

    protected String getAllSQLQuery;
    protected String getSQLQuery;
    protected String deleteSQLQuery;
    protected String addSQLQuery;
    protected String updateSQLQuery;
    protected AbstractDAOHandler<T> daoHandler;

    @Override
    public List<T> getAll() throws DAOSQLException {
        List<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(getAllSQLQuery);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                list.add(daoHandler.build(rs));
            }

            return list;
        } catch (SQLException exc) {
            throw new DAOSQLException(exc.getMessage());
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public T get(K id) throws DAOSQLException {
        T result = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(getSQLQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            result = daoHandler.build(rs);
            return result;
        } catch (SQLException exc) {
            throw new DAOSQLException(exc.getMessage());
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public boolean delete(K id) throws DAOSQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(deleteSQLQuery);
            statement.setInt(1,id);
            return statement.execute();

        } catch (SQLException exc) {
            throw new DAOSQLException(exc.getMessage());
        } finally {
            releaseConnection(connection, statement);
        }

    }

    @Override
    public int add(T entity) throws DAOSQLException {
        int accountID = -1;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(addSQLQuery, Statement.RETURN_GENERATED_KEYS);
            daoHandler.parse(entity,statement,false);
            statement.executeUpdate();
            ResultSet gk = statement.getGeneratedKeys();

            if(gk.next()) {
                accountID = gk.getInt(1);
            }

            return accountID;

        } catch (SQLException exc) {
            throw new DAOSQLException(exc.getMessage());
        } finally {
            releaseConnection(connection, statement);
        }
    }

    @Override
    public boolean update(T entity) throws DAOSQLException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(updateSQLQuery);
            daoHandler.parse(entity,statement,true);
            return statement.execute();

        } catch (SQLException exc) {
            throw new DAOSQLException(exc.getMessage());
        } finally {
            releaseConnection(connection, statement);
        }
    }

    protected void releaseConnection(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException exc) {
            LOGGER.warn(exc.getMessage(), exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
