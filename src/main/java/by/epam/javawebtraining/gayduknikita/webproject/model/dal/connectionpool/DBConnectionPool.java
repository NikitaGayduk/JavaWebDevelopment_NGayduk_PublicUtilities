package by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool;

import java.sql.Connection;

/**
 * This interface provides basic methods for work with connection pool
 * @author NikitaGayduk
 * @date 19.04.2019
 */
public interface DBConnectionPool {

    /**
     * Get Connection from connection pool
     * @return Connection object from connection pool
     */
    Connection getConnection();

    /**
     * Return connection to connection pool
     * @param connection Connection object, taken from connection pool
     * @return true if connection successfully released
     */
    boolean releaseConnection(Connection connection);
}
