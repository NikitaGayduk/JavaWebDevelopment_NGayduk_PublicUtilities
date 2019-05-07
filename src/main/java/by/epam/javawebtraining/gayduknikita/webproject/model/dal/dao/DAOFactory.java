package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.BaseAccountDAO;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class DAOFactory {
    private static AccountDAO accountDAO = new BaseAccountDAO();

    private DAOFactory() {
    }

    public static AccountDAO getAccountDao(){
        return accountDAO;
    }
}
