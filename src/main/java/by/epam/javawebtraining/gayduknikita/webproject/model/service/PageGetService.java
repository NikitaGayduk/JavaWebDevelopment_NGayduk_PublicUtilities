package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public interface PageGetService {

    public String getPageByRole(HttpServletRequest request) throws ServiceExecuttingException;

}
