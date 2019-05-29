package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import by.epam.javawebtraining.gayduknikita.webproject.util.TimestampBuilder;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public class DesiredTimeValidator implements Validator {
    private static final DesiredTimeValidator instance = new DesiredTimeValidator();

    private DesiredTimeValidator() {
    }

    public static DesiredTimeValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(HttpServletRequest request) {
        Timestamp desiredTimestamp = TimestampBuilder.createTimestamp(request.getParameter(Constants.PARAMETER_ORDER_DESIRED_DATE)
                , request.getParameter(Constants.PARAMETER_ORDER_DESIRED_TIME));

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        if (desiredTimestamp != null) {
            return desiredTimestamp.after(currentTimestamp);
        } else {
            return false;
        }
    }
}