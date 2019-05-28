package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
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
    private static final AccountDAOImpl instance = new AccountDAOImpl();
    private AbstractDAOHandler<Account> daoHandler;
    private String getAllSQLQuery;
    private String getSQLQuery;
    private String deleteSQLQuery;
    private String addSQLQuery;
    private String updateSQLQuery;

    {
        getAllSQLQuery = SQLRequestContainer.ACCOUNT_GET_ALL_QUERY;
        getSQLQuery = SQLRequestContainer.ACCOUNT_GET_BY_ID_QUERY;
        deleteSQLQuery = SQLRequestContainer.ACCOUNT_DELETE_BY_ID_QUERY;
        addSQLQuery = SQLRequestContainer.ACCOUNT_ADD_QUERY;
        updateSQLQuery = SQLRequestContainer.ACCOUNT_UPDATE_BY_ID_QUERY;
        daoHandler = DAOHandlerFactory.getDAOAccountHandler();
    }

    private AccountDAOImpl() {
    }

    public static AccountDAOImpl getInstance(){
        return instance;
    }

    @Override
    public List<Account> getAll() throws DAOException {
        return null;
    }

    @Override
    public Account get(int id) throws DAOException {
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
    public int add(Account entity) throws DAOException {
        return 0;
    }

    @Override
    public boolean update(Account entity) throws DAOException {
        return false;
    }

    @Override
    public Account getAccount(String login, String password) throws DAOException {
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
            throw new DAOException(exc.getMessage());
        } finally {
            closeStatement(statement);
            connectionPool.releaseConnection(connection);
        }
    }
}
