package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.BaseDBConnectionPool;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.DBConnectionPool;

import java.sql.Connection;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public class BaseDAO {
    private DBConnectionPool connectionPool = BaseDBConnectionPool.getInstance();

    protected Connection getConnection(){
        return connectionPool.getConnection();
    }

    protected void releaseConnection(Connection connection){
        connectionPool.releaseConnection(connection);
    }
}
