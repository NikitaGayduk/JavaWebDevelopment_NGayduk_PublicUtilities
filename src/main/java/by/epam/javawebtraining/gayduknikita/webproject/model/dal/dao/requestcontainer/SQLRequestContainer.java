package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer;

/**
 * @author NikitaGayduk
 * @date 06.05.2019
 */
public class SQLRequestContainer {
    public static final String CREATE_ACCOUNT =
            "INSERT INTO publicutilities.accounts (account_login, account_password, role_id) " +
                    "VALUES (?, ?, (SELECT role_id FROM publicutilities.roles WHERE role_name=?))";


    public static final String GET_TENANT_ADDRESS =
            "SELECT address_id, house, apartments, street_name FROM publicutilities.addresses " +
                    "INNER JOIN publicutilities.streets USING (street_id)" +
                    "WHERE address_id = (SELECT address_id FROM publicutilities.tenants WHERE tenant_id = ?)";

    public static final String GET_ORDER_TENANT =
            "SELECT tenant_id, tenant_surname, tenant_name, tenant_patronymic FROM publicutilities.tenants " +
                    "WHERE tenant_id = (SELECT tenant_id FROM publicutilities.orders WHERE order_id = ?)";


    //account
    public static final String ACCOUNT_GET_ALL_QUERY =
            "SELECT account_id, account_login, account_password, role_name FROM publicutilities.accounts " +
                    "INNER JOIN publicutilities.roles USING (role_id)";

    public static final String ACCOUNT_GET_BY_ID_QUERY =
            "SELECT account_id, account_login, account_password, role_name FROM publicutilities.accounts " +
                    "INNER JOIN publicutilities.roles USING (role_id) WHERE account_id = ?";

    public static final String ACCOUNT_GET_BY_LOGIN_PASSWORD =
            "SELECT account_id, account_login, account_password, role_name FROM publicutilities.accounts " +
                    "INNER JOIN publicutilities.roles USING (role_id) " +
                    "WHERE account_login = ? AND account_password = ?";

    public static final String ACCOUNT_DELETE_BY_ID_QUERY =
            "DELETE FROME publicutilities.accounts " +
                    "WHERE account_id = ?";

    public static final String ACCOUNT_ADD_QUERY =
            "INSERT INTO publicutilities.accounts (account_login, account_password, role_id) " +
                    "VALUES (?, ?, (SELECT role_id FROM publicutilities.roles WHERE role_name=?))";

    public static final String ACCOUNT_UPDATE_BY_ID_QUERY =
            "UPDATE publicutilities.accounts SET account_login = ?, account_password = ?, role_id = ? " +
                    "WHERE account_id = ?";


    //address
    public static final String ADDRESS_GET_ALL_QUERY =
            "SELECT address_id, house, apartments, street_name FROM publicutilities.addresses " +
                    "INNER JOIN publicutilities.streets USING (street_id)";

    public static final String ADDRESS_GET_BY_ID_QUERY =
            "SELECT address_id, house, apartments, street_name FROM publicutilities.addresses " +
                    "INNER JOIN publicutilities.streets USING (street_id) " +
                    "WHERE address_id = ?";

    public static final String ADDRESS_DELETE_BY_ID_QUERY =
            "DELETE FROM publicutilities.addresses " +
                    "WHERE address_id = ?";

    public static final String ADDRESS_ADD_QUERY =
            "INSERT INTO publicutilities.addresses (house, apartments, street_id) " +
                    "VALUES (?, ?, (SELECT street_id FROM publicutilities.streets WHERE street_name = ?))";

    public static final String ADDRESS_UPDATE_BY_ID_QUERY =
            "UPDATE publicutilities.addresses SET house = ?, apartments = ?, street_id = " +
                    "(SELECT street_id FROM publicutilities.streets WHERE street_name = ?) " +
                    "WHERE address_id = ?";


    //tenant
    public static final String TENANT_GET_ALL_QUERY =
            "SELECT tenant_id, tenant_surname, tenant_name, tenant_patronymic, account_id, address_id " +
                    "FROM publicutilities.tenants";

    public static final String TENANT_GET_BY_ID_QUERY =
            "SELECT tenant_id, tenant_surname, tenant_name, tenant_patronymic, account_id, address_id " +
                    "FROM publicutilities.tenants" +
                    "WHERE tenant_id = ?";

    public static final String TENANT_DELETE_BY_ID_QUERY =
            "DELETE FROM publicutilities.tenants " +
                    "WHERE tenant_id = ?";

    public static final String TENANT_ADD_QUERY =
            "INSERT INTO publicutilities.tenants " +
                    "(tenant_surname, tenant_name, tenant_patronymic, account_id, address_id) " +
                    "VALUES (?, ?, ?, ?, ?)";

    public static final String TENANT_UPDATE_BY_ID_QUERY =
            "UPDATE publicutilities.tenants " +
                    "SET tenant_surname = ?, tenant_name = ?, tenant_patronymic = ?, account_id = ?, address_id = ? " +
                    "WHERE tenant_id = ?";


    //order
    public static final String ORDER_GET_ALL_QUERY =
            "SELECT order_id, desired_time, tenant_id, order_state_id, works_begin, works_end, order_description " +
                    "FROM publicutilities.orders";

    public static final String ORDER_GET_BY_ID_QUERY =
            "SELECT order_id, desired_time, tenant_id, order_state_id, works_begin, works_end, order_description " +
                    "FROM publicutilities.orders " +
                    "WHERE order_id = ?";

    public static final String ORDER_DELETE_BY_ID_QUERY =
            "DELETE FROM publicutilities.orders " +
                    "WHERE order_id = ?";

    public static final String ORDER_ADD_QUERY =
            "INSERT INTO publicutilities.orders " +
                    "(desired_time, tenant_id, order_state_id, works_begin, works_end, order_description) " +
                    "VALUES (?, ?, " +
                    "(SELECT order_state_id FROM publicutilities.order_states WHERE order_state_name = ?), ?, ?, ?)";

    public static final String ORDER_UPDATE_BY_ID_QUERY =
            "UPDATE publicutilities.orders " +
                    "SET desired_time = ?, tenant_id = ?, order_state_id = " +
                    "(SELECT order_state_id FROM publicutilities.order_states WHERE order_state_name = ?)" +
                    ", works_begin = ?, works_end = ?, order_description = ? " +
                    "WHERE order_id = ?";

    public static final String ORDER_GET_BY_WORKER_ID =
            "SELECT order_id, desired_time, tenant_id, order_state_id, works_begin, works_end, order_description " +
                    "FROM publicutilities.orders " +
                    "INNER JOIN (SELECT order_id FROM publicutilities.order_workers WHERE employee_id = ?) as worker_orders " +
                    "USING (order_id) " +
                    "WHERE (order_state_id = 4) " +
                    "ORDER BY works_begin " +
                    "LIMIT ?, ?";

}
