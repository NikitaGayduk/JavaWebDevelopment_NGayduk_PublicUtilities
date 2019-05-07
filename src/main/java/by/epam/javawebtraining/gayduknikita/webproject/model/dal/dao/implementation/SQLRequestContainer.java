package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

/**
 * @author NikitaGayduk
 * @date 06.05.2019
 */
public class SQLRequestContainer {
    public static final String CREATE_ACCOUNT  =
            "INSERT INTO publicutilities.accounts (account_login, account_password, role_id) " +
            "VALUES (?, ?, (SELECT role_id FROM publicutilities.roles WHERE role_name=?))";
}
