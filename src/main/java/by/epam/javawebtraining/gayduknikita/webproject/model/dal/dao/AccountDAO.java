package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public interface AccountDAO extends EntityDAO<Integer, Account> {

    public Account getAccount(String account_name, String password) throws DAOSQLException;
}
