package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public class TenantDAOImpl extends BaseDAOImpl<Integer,Tenant> implements TenantDAO {

    @Override
    public Tenant getOrderTenant(Order order) throws DAOSQLException {
        return null;
    }
}
