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

    public static final String ACCOUNT_GET_BY_LOGIN =
            "SELECT account_id, account_login, account_password, role_name FROM publicutilities.accounts " +
                    "INNER JOIN publicutilities.roles USING (role_id) " +
                    "WHERE account_login = ?";

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
                    "FROM publicutilities.tenants " +
                    "WHERE tenant_id = ?";

    public static final String TENANT_GET_BY_ACCOUNT_ID_QUERY =
            "SELECT tenant_id, tenant_surname, tenant_name, tenant_patronymic, account_id, address_id " +
                    "FROM publicutilities.tenants " +
                    "WHERE account_id = ?";

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
            "SELECT order_id, desired_time, tenant_id, order_state_name, works_begin, works_end, order_description " +
                    "FROM publicutilities.orders " +
                    "INNER JOIN publicutilities.order_states " +
                    "USING (order_state_id) " +
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

    public static final String ORDER_GET_BY_TENANT_ID_QUERY =
            "SELECT order_id, desired_time, tenant_id, order_state_name, works_begin, works_end, order_description " +
                    "FROM publicutilities.orders " +
                    "INNER JOIN publicutilities.order_states " +
                    "USING (order_state_id) " +
                    "WHERE tenant_id = ?  AND order_state_name IN ('WAITING_CONFIRM','WAITING_EXECUTION')";

    public static final String ORDER_GET_BY_WORKER_ID_QUERY =
            "SELECT order_id, desired_time, tenant_id, order_state_name, works_begin, works_end, order_description " +
                    "FROM publicutilities.orders " +
                    "INNER JOIN publicutilities.order_states " +
                    "USING (order_state_id) " +
                    "WHERE order_id IN (SELECT order_id FROM publicutilities.order_workers WHERE employee_id = ?) " +
                    "AND order_state_name = 'WAITING_EXECUTION'";

    public static final String ORDER_GET_ALL_AWAITING_QUERY =
            "SELECT order_id, desired_time, tenant_id, order_state_name, works_begin, works_end, order_description " +
                    "FROM publicutilities.orders " +
                    "INNER JOIN publicutilities.order_states " +
                    "USING (order_state_id) " +
                    "WHERE order_state_name = 'WAITING_CONFIRM'";

    public static final String ORDER_GET_BY_TIME_PERIOD_QUERY =
            "SELECT * FROM publicutilities.orders " +
                    "WHERE (works_begin between ? and ? " +
                    "OR works_end between ? and ?)";


    //employee
    public static final String EMPLOYEE_GET_ALL_QUERY =
            "SELECT employee_id, employee_surname, employee_name" +
                    ", employee_patronymic, account_id, employee_state_name " +
                    "FROM publicutilities.employees " +
                    "INNER JOIN publicutilities.employee_states " +
                    "USING (employee_state_id)";

    public static final String EMPLOYEE_GET_BY_ID_QUERY =
            "SELECT employee_id, employee_surname, employee_name" +
                    ", employee_patronymic, account_id, employee_state_name " +
                    "FROM publicutilities.employees " +
                    "INNER JOIN publicutilities.employee_states " +
                    "USING (employee_state_id) " +
                    "WHERE employee_id = ?";

    public static final String EMPLOYEE_ADD_QUERY =
            "INSERT INTO publicutilities.employees " +
                    "(employee_surname, employee_name, employee_patronymic, account_id, employee_state_id) " +
                    "VALUES (?, ?, ?, ?, " +
                    "(SELECT employee_state_id FROM publicutilities.employee_states WHERE employee_state_name = ?))";

    public static final String EMPLOYEE_GET_BY_ACCOUNT_ID_QUERY =
            "SELECT employee_id, employee_surname, employee_name" +
                    ", employee_patronymic, account_id, employee_state_name " +
                    "FROM publicutilities.employees " +
                    "INNER JOIN publicutilities.employee_states " +
                    "USING (employee_state_id) " +
                    "WHERE account_id = ?";

    public static final String EMPLOYEE_UPDATE_BY_ID_QUERY =
            "UPDATE publicutilities.employees " +
                    "SET employee_surname = ?, employee_name = ?, employee_patronymic = ?, " +
                    "account_id = ?, employee_state_id = " +
                    "(SELECT employee_state_id FROM publicutilities.employee_states WHERE employee_state_name = ?) " +
                    "WHERE employee_id = ?";

    public static final String EMPLOYEE_GET_ALL_WORKS_QUERY =
            "SELECT employee_id, employee_surname, employee_name" +
                    ", employee_patronymic, account_id, employee_state_name " +
                    "FROM publicutilities.employees " +
                    "INNER JOIN publicutilities.employee_states " +
                    "USING (employee_state_id) " +
                    "WHERE employee_state_name = 'WORKS'";

    public static final String EMPLOYEE_GET_BY_ORDER_ID_QUERY =
            "SELECT employee_id, employee_surname, employee_name" +
                    ", employee_patronymic, account_id, employee_state_name " +
                    "FROM publicutilities.employees " +
                    "INNER JOIN publicutilities.employee_states " +
                    "USING (employee_state_id) " +
                    "WHERE employee_id IN (SELECT employee_id FROM publicutilities.order_workers WHERE order_id = ?)";

    public static final String EMPLOYEE_GET_FREE_DURING_TIME_QUERY =
            "SELECT employee_id, employee_surname, employee_name, employee_patronymic, account_id" +
                    ", employee_state_name " +
                    "FROM publicutilities.employees INNER JOIN publicutilities.employee_states " +
                    "USING (employee_state_id) " +
                    "INNER JOIN publicutilities.accounts USING (account_id) WHERE role_id = 4 " +
                    "AND employee_id NOT IN( " +
                    "SELECT employee_id FROM publicutilities.order_workers WHERE order_id " +
                    "IN (SELECT order_id FROM publicutilities.orders " +
                    "WHERE (works_begin between ? and ? " +
                    "OR works_end between ? and ?)))";

    public static final String EMPLOYEE_ORDER_ADD_QUERY =
            "INSERT INTO publicutilities.order_workers " +
                    "(order_id, employee_id) " +
                    "VALUES (?, ?)";
}
