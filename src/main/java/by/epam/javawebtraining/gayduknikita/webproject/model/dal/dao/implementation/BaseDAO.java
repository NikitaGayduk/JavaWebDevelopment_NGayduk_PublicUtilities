package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.BaseDBConnectionPool;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.DBConnectionPool;
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
public class BaseDAO {
    protected static final Logger LOGGER = Logger.getRootLogger();
    protected static final DBConnectionPool connectionPool = BaseDBConnectionPool.getInstance();

    protected <T extends Entity> List<T> getAllTransact(String getAllSQLQuery, Connection connection
            , AbstractDAOHandler<T> daoHandler) throws SQLException {

        PreparedStatement statement = null;

        try {
            List<T> list = new ArrayList<>();
            statement = connection.prepareStatement(getAllSQLQuery);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(daoHandler.build(rs));
            }

            return list;
        } finally {
            closeStatement(statement);
        }
    }

    protected <T extends Entity> List<T> getAll(String getAllSQLQuery
            , AbstractDAOHandler<T> daoHandler) throws SQLException {

        Connection connection = connectionPool.getConnection();

        try {
            return getAllTransact(getAllSQLQuery, connection, daoHandler);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    protected <T extends Entity> T getByIDTransact(String getSQLQuery, Connection connection
            , AbstractDAOHandler<T> daoHandler, int id) throws SQLException {

        PreparedStatement statement = null;

        try {
            T result = null;
            statement = connection.prepareStatement(getSQLQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result = daoHandler.build(rs);
            }

            return result;

        } finally {
            closeStatement(statement);
        }
    }

    protected <T extends Entity> T getByID(String getSQLQuery
            , AbstractDAOHandler<T> daoHandler, int id) throws SQLException {

        Connection connection = connectionPool.getConnection();

        try {
            return getByIDTransact(getSQLQuery, connection, daoHandler, id);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    protected <T extends Entity> List<T> getListByIDTransact(String getSQLQuery, Connection connection
            , AbstractDAOHandler<T> daoHandler, int id) throws SQLException {

        PreparedStatement statement = null;

        try {
            List<T> result = new ArrayList<>();
            statement = connection.prepareStatement(getSQLQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.add(daoHandler.build(rs));
            }

            return result;

        } finally {
            closeStatement(statement);
        }
    }

    protected <T extends Entity> List<T> getListByID(String getSQLQuery
            , AbstractDAOHandler<T> daoHandler, int id) throws SQLException {

        Connection connection = connectionPool.getConnection();

        try {
            return getListByIDTransact(getSQLQuery, connection, daoHandler, id);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }


    protected boolean deleteTransact(String deleteSQLQuery, Connection connection
            , int id) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(deleteSQLQuery);
            statement.setInt(1, id);
            return  statement.execute();

        } finally {
            closeStatement(statement);
        }
    }

    protected boolean delete(String deleteSQLQuery
            , int id) throws SQLException {

        Connection connection = connectionPool.getConnection();

        try {
            return deleteTransact(deleteSQLQuery, connection, id);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }


    protected <T extends Entity> int addTransact(String addSQLQuery, Connection connection
            , AbstractDAOHandler<T> daoHandler, T entity) throws SQLException {

        int entityID = -1;
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(addSQLQuery, Statement.RETURN_GENERATED_KEYS);
            daoHandler.parse(entity, statement, false);
            statement.executeUpdate();
            ResultSet gk = statement.getGeneratedKeys();

            if (gk.next()) {
                entityID = gk.getInt(1);
            }

            return entityID;
        } finally {
            closeStatement(statement);
        }

    }

    protected <T extends Entity> int add(String addSQLQuery
            , AbstractDAOHandler<T> daoHandler, T entity) throws SQLException {

        Connection connection = connectionPool.getConnection();

        try {
            return addTransact(addSQLQuery, connection, daoHandler, entity);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    protected <T extends Entity> boolean updateTransact(String updateSQLQuery, Connection connection
            , AbstractDAOHandler<T> daoHandler, T entity) throws SQLException {

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(updateSQLQuery);
            daoHandler.parse(entity, statement, true);

            return statement.execute();

        } finally {
            closeStatement(statement);
        }
    }

    protected <T extends Entity> boolean update(String updateSQLQuery
            , AbstractDAOHandler<T> daoHandler, T entity) throws SQLException {

        Connection connection = connectionPool.getConnection();

        try {
            return updateTransact(updateSQLQuery, connection, daoHandler, entity);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    protected void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException exc) {
            LOGGER.warn("Can't close statement", exc);
        }
    }
}
