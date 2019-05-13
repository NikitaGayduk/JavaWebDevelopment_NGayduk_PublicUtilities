package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NikitaGayduk
 * @date 12.05.2019
 */
class DAOAccountHandler extends AbstractDAOHandler<Account> {

    @Override
    public Account build(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt(Constants.ColumnName.ACCOUNT_ID));
        account.setLogin(resultSet.getString(Constants.ColumnName.ACCOUNT_LOGIN));
        account.setPassword(resultSet.getString(Constants.ColumnName.ACCOUNT_PASSWORD));
        account.setRole(Role.valueOf(resultSet.getString(Constants.ColumnName.ROLE_NAME)));

        return account;
    }

    @Override
    public void parse(Account entity, PreparedStatement statement, boolean useID) throws SQLException {
        if (entity != null) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setInt(3,entity.getRole().ordinal()+1);

            if (useID) {
                statement.setInt(4, entity.getId());
            }
        }
    }
}
