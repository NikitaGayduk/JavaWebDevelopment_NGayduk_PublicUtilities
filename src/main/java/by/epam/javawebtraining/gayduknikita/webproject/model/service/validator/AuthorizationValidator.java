package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
class AuthorizationValidator implements Validator {
    private static final Logger LOGGER = Logger.getRootLogger();

    private Pattern loginPattern;
    private Pattern passwordPattern;

    {
        loginPattern = Pattern.compile(Constants.LOGIN_REGEX);
        passwordPattern = Pattern.compile(Constants.PASSWORD_REGEX);
    }

    @Override
    public void validate(HttpServletRequest request) throws ValidationException {
        try {
            boolean result = true;

            if (!loginPattern.matcher(request.getParameter(Constants.ACCOUNT_LOGIN)).matches()) {
                LOGGER.error("Invalid login");
                result = false;
            }
            if (!passwordPattern.matcher(request.getParameter(Constants.ACCOUNT_PASSWORD)).matches()) {
                LOGGER.error("Invalid password");
                result = false;
            }
            if (result == false) {
                LOGGER.error("Invalid registration data");
                throw new ValidationException("Invalid registration data");
            }
        } catch (NullPointerException exc) {
            LOGGER.fatal("The request does not contain the required parameter", exc);
            throw new ValidationException();
        }
    }
}
