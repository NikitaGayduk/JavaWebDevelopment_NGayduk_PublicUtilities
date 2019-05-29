package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AccountDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public class NewLoginValidator implements Validator {
    private static final NewLoginValidator instance = new NewLoginValidator();

    private NewLoginValidator() {
    }

    public static NewLoginValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(HttpServletRequest request) {
        try {
            Account account = AccountDAOImpl.getInstance().getAccountByLogin(request.getParameter(Constants.ACCOUNT_LOGIN));
            if (account == null) {
                return true;
            } else {
                return false;
            }

        } catch (DAOException exc) {
            return false;
        }
    }
}
