package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
class RegistrationValidator implements Validator {
    private static final Logger LOGGER = Logger.getRootLogger();

    private Pattern loginPattern;
    private Pattern passwordPattern;
    private Pattern surnamePattern;
    private Pattern namePattern;
    private Pattern patronymicPattern;

    {
        loginPattern = Pattern.compile(Constants.LOGIN_REGEX);
        passwordPattern = Pattern.compile(Constants.PASSWORD_REGEX);
        surnamePattern = Pattern.compile(Constants.SURNAME_REGEX);
        namePattern = Pattern.compile(Constants.NAME_REGEX);
        patronymicPattern = Pattern.compile(Constants.PATRONYMIC_REGEX);
    }

    @Override
    public void validate(HttpServletRequest request) throws ValidationException {
        try {
            boolean result = true;

            if (!loginPattern.matcher(request.getParameter(Constants.LOGIN_PARAMETER)).matches()) {
                LOGGER.error("Invalid login");
                result = false;
            }
            if (!passwordPattern.matcher(request.getParameter(Constants.PASSWORD_PARAMETER)).matches()) {
                LOGGER.error("Invalid password");
                result = false;
            }
            if (surnamePattern.matcher(request.getParameter(Constants.TENANT_SURNAME_PARAMETER)).matches()) {
                LOGGER.error("Invalid tenant surname");
                result = false;
            }
            if (namePattern.matcher(request.getParameter(Constants.TENANT_NAME_PARAMETER)).matches()) {
                LOGGER.error("Invalid tenant name");
                result = false;
            }
            if (patronymicPattern.matcher(request.getParameter(Constants.TENANT_PATRONYMIC_PARAMETER)).matches()) {
                LOGGER.error("Invalid tenant patronymic");
                result = false;
            }

            if (result = false){
                throw new ValidationException();
            }
        } catch (NullPointerException exc){
            LOGGER.fatal("The request does not contain the required parameter", exc);
        }
    }
}
