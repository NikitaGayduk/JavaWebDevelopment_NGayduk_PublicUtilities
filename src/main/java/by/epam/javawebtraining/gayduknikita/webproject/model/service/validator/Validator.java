package by.epam.javawebtraining.gayduknikita.webproject.model.service.validator;

import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public interface Validator {

    // TODO: 08.05.2019 solve problem with validation regex
    public void validate(HttpServletRequest request) throws ValidationException;

}
