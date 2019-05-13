package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;

import java.sql.*;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class AccountDAOImpl extends BaseDAOImpl<Integer,Account> implements AccountDAO {
    {
        getAllSQLQuery = SQLRequestContainer.ACCOUNT_GET_ALL_QUERY;
        getSQLQuery = SQLRequestContainer.ACCOUNT_GET_BY_ID_QUERY;
        deleteSQLQuery = SQLRequestContainer.ACCOUNT_DELETE_BY_ID_QUERY;
        addSQLQuery = SQLRequestContainer.ACCOUNT_ADD_QUERY;
        updateSQLQuery = SQLRequestContainer.ACCOUNT_UPDATE_BY_ID_QUERY;
        daoHandler = DAOHandlerFactory.getDAOAccountHandler();
    }

    @Override
    public Account getAccount(String login, String password) throws DAOSQLException {
        Account result = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(SQLRequestContainer.ACCOUNT_GET_BY_LOGIN_PASSWORD);
            statement.setString(1, login);
            statement.setString(1, password);
            ResultSet rs = statement.executeQuery();
            result = daoHandler.build(rs);
            return result;
        } catch (SQLException exc) {
            throw new DAOSQLException(exc.getMessage());
        } finally {
            releaseConnection(connection, statement);
        }
    }
}
