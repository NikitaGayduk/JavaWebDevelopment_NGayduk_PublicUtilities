package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import by.epam.javawebtraining.gayduknikita.webproject.util.TimestampBuilder;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public class OrderExecutionTimeValidator implements Validator {
    private static final OrderExecutionTimeValidator instance = new OrderExecutionTimeValidator();

    private OrderExecutionTimeValidator() {
    }

    public static OrderExecutionTimeValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(HttpServletRequest request) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        Timestamp begin = TimestampBuilder.createTimestamp(
                request.getParameter(Constants.PARAMETER_ORDER_WORKS_BEGIN_DATE)
                , request.getParameter(Constants.PARAMETER_ORDER_WORKS_BEGIN_TIME));

        Timestamp end = TimestampBuilder.createTimestamp(
                request.getParameter(Constants.PARAMETER_ORDER_WORKS_END_DATE)
                , request.getParameter(Constants.PARAMETER_ORDER_WORKS_END_TIME));

        if (begin != null && end != null) {
            return begin.after(currentTimestamp) && end.after(begin);
        } else {
            return false;
        }
    }
}
