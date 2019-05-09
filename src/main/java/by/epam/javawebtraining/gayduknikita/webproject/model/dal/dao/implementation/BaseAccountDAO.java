package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.BaseDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EntityDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;

import java.sql.*;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class BaseAccountDAO extends BaseDAO implements AccountDAO {
    @Override
    public Account getAccount(Account acc) throws DAOSQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        Account account = acc;

        try{
            connection = getConnection();
            statement = connection.prepareStatement(SQLRequestContainer.GET_ACCOUNT);

            statement.setString(1, account.getLogin());
            statement.setString(2, account.getPassword());
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();

            if(resultSet.next()){
                account.setId(resultSet.getInt(1));
                account.setRole(Role.valueOf(resultSet.getString(2)));
            } else {
                account = null;
            }

            resultSet.close();
            statement.close();

            return account;

        } catch (SQLException exc){
            throw new DAOSQLException(exc);
        } finally {
            if(connection != null) {
                releaseConnection(connection);
            }
        }
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Account get(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public int add(Account account) throws DAOSQLException{
        int accountID = -1;
        Connection connection = null;

        try{
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLRequestContainer.CREATE_ACCOUNT
                    ,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, account.getLogin());
            statement.setString(2, account.getPassword());
            statement.setString(3, account.getRole().name());
            statement.executeUpdate();

            ResultSet gk = statement.getGeneratedKeys();

            if(gk.next()) {
                accountID = gk.getInt(1);
            }

            gk.close();
            statement.close();

            return accountID;

        } catch (SQLException exc){
            throw new DAOSQLException(exc);
        } finally {
            if(connection != null) {
                releaseConnection(connection);
            }
        }
    }

    @Override
    public boolean update(Account entity) {
        return false;
    }
}
