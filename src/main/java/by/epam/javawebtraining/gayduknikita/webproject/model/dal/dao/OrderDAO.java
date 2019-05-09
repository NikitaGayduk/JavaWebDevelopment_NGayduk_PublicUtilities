package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public interface OrderDAO extends EntityDAO<Integer, Order> {

    Order getOrdersByTenant(Tenant entity) throws DAOSQLException;

    Order getOrdersByWorker(Employee entity) throws DAOSQLException;

}
