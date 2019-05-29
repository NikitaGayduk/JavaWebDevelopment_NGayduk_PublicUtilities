package by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool;

import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.util.DBPropertyLoader;
import by.epam.javawebtraining.gayduknikita.webproject.exception.InitializationException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.PropertiesLoadingException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author NikitaGayduk
 */
public class BaseDBConnectionPool implements DBConnectionPool {
    private static final Logger LOGGER;
    private static final BaseDBConnectionPool instance;

    private DBPropertyLoader dbPropertyLoader;
    private BlockingQueue<Connection> connectionPool;
    private BlockingQueue<Connection> usedConnections;

    static {
        LOGGER = Logger.getRootLogger();

        instance = new BaseDBConnectionPool();
    }

    private BaseDBConnectionPool(){}

    /**
     * Return link on connection pool singleton object
     *
     * @return BaseDBConnectionPool singleton object
     */
    public static BaseDBConnectionPool getInstance() {
        return instance;
    }

    /**
     * Initialization method: upload connection properties and create connections
     * @throws InitializationException
     */
    public void init() throws InitializationException {
        setDBAccessData();
        createConnections();
    }

    /**
     * Create instance of DBPropertyLoader class, init properties loading and ensure, that JDBC driver class was uploaded
     *
     * @throws InitializationException
     */
    private void setDBAccessData() throws InitializationException {
        dbPropertyLoader = new DBPropertyLoader();

        try {
            dbPropertyLoader.loadProperties();
            Class.forName(dbPropertyLoader.getJdbcDriver());
        } catch (PropertiesLoadingException exc) {
            LOGGER.fatal("Can't load connection pool properties\n" + exc.getMessage());
            throw new InitializationException(exc);
        } catch (ClassNotFoundException exc) {
            LOGGER.fatal("Can't find JDBC driver class\n" + exc.getMessage());
            throw new InitializationException(exc);
        }
    }

    /**
     * Fill connection pool with Connection objects
     *
     * @throws InitializationException if can't create connection
     */
    private void createConnections() throws InitializationException {
        connectionPool = new ArrayBlockingQueue<>(dbPropertyLoader.getInitialPoolSize());
        usedConnections = new ArrayBlockingQueue<>(dbPropertyLoader.getInitialPoolSize());

        try {
            for (int ptr = 0; ptr < dbPropertyLoader.getInitialPoolSize(); ptr++) {
                connectionPool.add(createConnection(dbPropertyLoader.getURL(), dbPropertyLoader.getUser()
                        , dbPropertyLoader.getPassword()));
            }
        } catch (SQLException exc) {
            LOGGER.fatal("Can't create connections in connection pool\n" + exc.getMessage());
            throw new InitializationException(exc);
        }
    }

    private Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = connectionPool.take();
            if (!connection.isValid(Constants.DB_CONNECTION_ISVALID_TIMEOUT)){
                connection = createConnection(dbPropertyLoader.getURL(), dbPropertyLoader.getUser()
                        , dbPropertyLoader.getPassword());
            }
            usedConnections.add(connection);
        } catch (InterruptedException exc) {
            LOGGER.error("Interrupted while trying getByIDTransact connection\n" + exc.getMessage());
        } catch (SQLException exc) {
            LOGGER.error("SQLException while trying to getByIDTransact connection\n" + exc.getMessage());
        }
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException exc){
            LOGGER.warn("Can't set connection auto commit true.",exc);
        }
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }
}
