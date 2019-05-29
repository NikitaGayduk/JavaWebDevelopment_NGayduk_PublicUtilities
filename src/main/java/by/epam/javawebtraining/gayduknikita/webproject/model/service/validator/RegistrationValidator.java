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
public class RegistrationValidator implements Validator {
    private static final RegistrationValidator instance = new RegistrationValidator();
    private Pattern surnamePattern;
    private Pattern namePattern;
    private Pattern patronymicPattern;

    {
        surnamePattern = Pattern.compile(Constants.SURNAME_REGEX);
        namePattern = Pattern.compile(Constants.NAME_REGEX);
        patronymicPattern = Pattern.compile(Constants.PATRONYMIC_REGEX);
    }

    private RegistrationValidator() {
    }

    public static RegistrationValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(HttpServletRequest request) {

        return surnamePattern.matcher(request.getParameter(Constants.EMPLOYEE_SURNAME)).matches()
                && namePattern.matcher(request.getParameter(Constants.EMPLOYEE_NAME)).matches()
                && patronymicPattern.matcher(request.getParameter(Constants.EMPLOYEE_PATRONYMIC)).matches();

    }
}
