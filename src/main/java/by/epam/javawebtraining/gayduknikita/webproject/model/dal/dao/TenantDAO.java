package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public interface TenantDAO extends EntityDAO<Integer, Tenant> {

    Tenant getTenantByOrder(Order order) throws DAOSQLException;

}