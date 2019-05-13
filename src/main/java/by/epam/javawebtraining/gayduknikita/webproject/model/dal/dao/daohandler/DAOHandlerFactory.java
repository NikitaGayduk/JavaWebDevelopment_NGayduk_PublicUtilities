package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class DAOHandlerFactory {
    private static DAOAccountHandler accountHandler;
    private static DAOAddressHandler addressHandler;
    private static DAOEmployeeHandler employeeHandler;
    private static DAOOrderHandler orderHandler;
    private static DAOTenantHandler tenantHandler;

    static {
        accountHandler = new DAOAccountHandler();
        addressHandler = new DAOAddressHandler();
        employeeHandler = new DAOEmployeeHandler();
        orderHandler = new DAOOrderHandler();
        tenantHandler = new DAOTenantHandler();

    }

    public static DAOAccountHandler getDAOAccountHandler() {
        return accountHandler;
    }

    public static DAOAddressHandler getDAOAddressHandler() {
        return addressHandler;
    }

    public static DAOEmployeeHandler getDAOEmployeeHandler() {
        return employeeHandler;
    }

    public static DAOOrderHandler getDAOOrderHandler() {
        return orderHandler;
    }

    public static DAOTenantHandler getDAOTenantHandler() {
        return tenantHandler;
    }
}
