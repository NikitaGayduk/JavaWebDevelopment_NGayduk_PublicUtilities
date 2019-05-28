package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public class OrderDescriptionValidator implements Validator {
    private static final OrderDescriptionValidator instance = new OrderDescriptionValidator();

    private Pattern descriptionPattern;

    {
        descriptionPattern = Pattern.compile(Constants.ORDER_DESCRIPTION_REGEX);
    }


    private OrderDescriptionValidator() {
    }

    public static OrderDescriptionValidator getInstance() {
        return instance;
    }

    @Override
    public boolean isValid(HttpServletRequest request) {

        return descriptionPattern.matcher(request.getParameter(Constants.ORDER_DESCRIPTION)).matches();

    }
}
