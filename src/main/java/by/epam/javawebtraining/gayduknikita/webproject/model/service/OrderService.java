package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 20.05.2019
 */
public interface OrderService {

    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException;

}
