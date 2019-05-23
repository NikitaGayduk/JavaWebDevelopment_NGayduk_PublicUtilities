package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.*;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class DAOFactory {
    private static AccountDAO accountDAO = new AccountDAOImpl();
    private static AddressDAO addressDAO = new AddressDAOImpl();
    private static TenantDAO tenantDAO = new TenantDAOImpl();
    private static OrderDAO orderDAO = new OrderDAOImpl();
    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    private DAOFactory() {
    }

    public static AccountDAO getAccountDao(){
        return accountDAO;
    }

    public static AddressDAO getAddressDAO(){return  addressDAO;}

    public static TenantDAO getTenantDAO(){return  tenantDAO;}

    public static OrderDAO getOrderDAO(){return orderDAO;}

    public static EmployeeDAO getEmployeeDAO(){return employeeDAO;}
}
