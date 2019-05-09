package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public interface RegistrationService {

    public void tenantRegister(HttpServletRequest request) throws ServiceExecuttingException;

    public void goRegistrationPage(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException;

}
