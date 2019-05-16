package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.OrderState;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NikitaGayduk
 * @date 12.05.2019
 */
class DAOTenantHandler extends AbstractDAOHandler<Tenant> {
    @Override
    public Tenant build(ResultSet resultSet) throws SQLException {
        Tenant tenant = new Tenant();
        tenant.setId(resultSet.getInt(Constants.ORDER_ID));
        tenant.setSurname(resultSet.getString(Constants.TENANT_SURNAME));
        tenant.setName(resultSet.getString(Constants.TENANT_NAME));
        tenant.setPatronymic(resultSet.getString(Constants.TENANT_PATRONYMIC));
        tenant.setAccountID(resultSet.getInt(Constants.ACCOUNT_ID));
        tenant.setAddressID(resultSet.getInt(Constants.ADDRESS_ID));

        return tenant;
    }

    @Override
    public void parse(Tenant entity, PreparedStatement statement, boolean useID) throws SQLException {
        if (entity != null) {
            statement.setString(1,entity.getSurname());
            statement.setString(2,entity.getName());
            statement.setString(3,entity.getPatronymic());
            statement.setInt(4,entity.getAccountID());
            statement.setInt(5,entity.getAddressID());

            if (useID) {
                statement.setInt(6, entity.getId());
            }
        }
    }
}
