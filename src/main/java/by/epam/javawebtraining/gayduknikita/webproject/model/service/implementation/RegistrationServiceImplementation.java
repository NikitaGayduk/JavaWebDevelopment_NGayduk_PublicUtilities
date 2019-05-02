package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.model.service.RegistrationService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.ValidatorsFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public class RegistrationServiceImplementation implements RegistrationService {

    @Override
    public void register(HttpServletRequest request) {
        ValidatorsFactory.getRegistrationValidator().validate(request);
    }
}
