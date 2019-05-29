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

    public String registerTenant(HttpServletRequest request) throws ServiceExecuttingException;

    public String registerEmployee(HttpServletRequest request) throws ServiceExecuttingException;

    public void fillEmployeeRegistrationPage(HttpServletRequest request) throws ServiceExecuttingException;

}
