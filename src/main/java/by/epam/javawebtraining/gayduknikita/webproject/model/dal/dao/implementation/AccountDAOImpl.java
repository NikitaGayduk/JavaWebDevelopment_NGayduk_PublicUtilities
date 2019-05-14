package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;

import java.sql.*;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class AccountDAOImpl extends BaseDAO implements AccountDAO {
    private AbstractDAOHandler<Account> daoHandler;
    private String getAllSQLQuery;
    private String getSQLQuery;
    private String deleteSQLQuery;
    private String addSQLQuery;
    private String updateSQLQuery;

    {
        String getAllSQLQuery = SQLRequestContainer.ACCOUNT_GET_ALL_QUERY;
        String getSQLQuery = SQLRequestContainer.ACCOUNT_GET_BY_ID_QUERY;
        String deleteSQLQuery = SQLRequestContainer.ACCOUNT_DELETE_BY_ID_QUERY;
        String addSQLQuery = SQLRequestContainer.ACCOUNT_ADD_QUERY;
        String updateSQLQuery = SQLRequestContainer.ACCOUNT_UPDATE_BY_ID_QUERY;
        daoHandler = DAOHandlerFactory.getDAOAccountHandler();
    }

    @Override
    public List<Account> getAll() throws DAOSQLException {
        return null;
    }

    @Override
    public Account get(int id) throws DAOSQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws DAOSQLException {
        return false;
    }

    @Override
    public int add(Account entity) throws DAOSQLException {
        return 0;
    }

    @Override
    public boolean update(Account entity) throws DAOSQLException {
        return false;
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
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = daoHandler.build(rs);
            }
            return result;
        } catch (SQLException exc) {
            throw new DAOSQLException(exc.getMessage());
        } finally {
            closeStatement(statement);
            connectionPool.releaseConnection(connection);
        }
    }
}
