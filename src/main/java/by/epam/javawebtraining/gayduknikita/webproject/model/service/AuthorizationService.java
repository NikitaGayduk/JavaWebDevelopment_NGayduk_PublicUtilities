package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 08.05.2019
 */
public interface AuthorizationService {

    public String login(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException;

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException;

}
