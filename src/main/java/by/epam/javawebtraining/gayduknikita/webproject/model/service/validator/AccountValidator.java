package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public class AccountValidator implements Validator {
    private static final AccountValidator instance = new AccountValidator();

    private Pattern loginPattern;
    private Pattern passwordPattern;

    {
        loginPattern = Pattern.compile(Constants.LOGIN_REGEX);
        passwordPattern = Pattern.compile(Constants.PASSWORD_REGEX);
    }


    private AccountValidator() {
    }

    public static AccountValidator getInstance() {
        return instance;
    }


    @Override
    public boolean isValid(HttpServletRequest request) {

        return loginPattern.matcher(request.getParameter(Constants.ACCOUNT_LOGIN)).matches()
                && passwordPattern.matcher(request.getParameter(Constants.ACCOUNT_PASSWORD)).matches();
    }
}
