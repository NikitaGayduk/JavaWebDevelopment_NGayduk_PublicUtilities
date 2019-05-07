package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.BaseDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EntityDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;

import java.sql.*;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class BaseAccountDAO extends BaseDAO implements AccountDAO {
    @Override
    public Account getAccount(String account_name, String password) {
        return null;
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
    public int add(Account entity) throws DAOSQLException{
        int accountID = -1;
        Connection connection = null;

        try{
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLRequestContainer.CREATE_ACCOUNT
                    ,Statement.RETURN_GENERATED_KEYS);
            System.out.println(entity.getLogin());
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRole());
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
