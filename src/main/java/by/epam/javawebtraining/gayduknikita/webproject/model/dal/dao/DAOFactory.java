package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AccountDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AddressDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.OrderDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.TenantDAOImpl;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class DAOFactory {
    private static AccountDAO accountDAO = new AccountDAOImpl();
    private static AddressDAO addressDAO = new AddressDAOImpl();
    private static TenantDAO tenantDAO = new TenantDAOImpl();
    private static OrderDAO orderDAO = new OrderDAOImpl();

    private DAOFactory() {
    }

    public static AccountDAO getAccountDao(){
        return accountDAO;
    }

    public static AddressDAO getAddressDAO(){return  addressDAO;}

    public static TenantDAO getTenantDAO(){return  tenantDAO;}

    public static OrderDAO getOrderDAO(){return orderDAO;}
}
