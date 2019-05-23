package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public interface TenantDAO extends DAO<Tenant> {

    Tenant getTenantByAccount(Account account) throws DAOException;

    Tenant getOrderTenant(Order order) throws DAOException;

    int addTenant(Account account, Tenant tenant) throws DAOException;

}
