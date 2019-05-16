package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.OrderState;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NikitaGayduk
 * @date 12.05.2019
 */
class DAOOrderHandler extends AbstractDAOHandler<Order> {
    @Override
    public Order build(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt(Constants.ORDER_ID));
        order.setDesiredTime(resultSet.getTimestamp(Constants.ORDER_DESIRED_TIME));
        order.setTenantID(resultSet.getInt(Constants.TENANT_ID));
        order.setState(OrderState.valueOf(resultSet.getString(Constants.ORDER_STATE_NAME)));
        order.setWorksBegin(resultSet.getTimestamp(Constants.ORDER_WORKS_BEGIN));
        order.setWorksEnd(resultSet.getTimestamp(Constants.ORDER_WORKS_END));
        order.setOrderDiscription(resultSet.getString(Constants.ORDER_DESCRIPTION));

        return order;
    }

    @Override
    public void parse(Order entity, PreparedStatement statement, boolean useID) throws SQLException {
        if (entity != null) {
            statement.setTimestamp(1, entity.getDesiredTime());
            statement.setInt(2, entity.getTenantID());
            statement.setInt(3,entity.getState().ordinal()+1);
            statement.setTimestamp(4,entity.getWorksBegin());
            statement.setTimestamp(5,entity.getWorksEnd());
            statement.setString(6,entity.getOrderDiscription());

            if (useID) {
                statement.setInt(7, entity.getId());
            }
        }
    }
}
