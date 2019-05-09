package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

/**
 * @author NikitaGayduk
 * @date 06.05.2019
 */
public class SQLRequestContainer {
    public static final String CREATE_ACCOUNT =
            "INSERT INTO publicutilities.accounts (account_login, account_password, role_id) " +
                    "VALUES (?, ?, (SELECT role_id FROM publicutilities.roles WHERE role_name=?))";

    public static final String GET_ACCOUNT =
            "SELECT account_id, role_name FROM publicutilities.accounts " +
                    "INNER JOIN publicutilities.roles USING (role_id) " +
                    "WHERE account_login = ? AND account_password = ?";

    public static final String GET_TENANT_ADDRESS =
            "SELECT address_id, house, apartments, street_name FROM publicutilities.addresses " +
                    "INNER JOIN publicutilities.streets USING (street_id)" +
                    "WHERE address_id = (SELECT address_id FROM publicutilities.tenants WHERE tenant_id = ?)";
}
