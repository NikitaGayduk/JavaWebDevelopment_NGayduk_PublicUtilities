package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public interface OrderDAO extends DAO<Order> {

    List<Order> getOrdersByTenant(Tenant entity) throws DAOException;

    List<Order> getOrdersByWorker(Employee entity) throws DAOException;

}
