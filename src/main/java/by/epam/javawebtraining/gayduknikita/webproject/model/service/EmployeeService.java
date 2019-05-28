package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author NikitaGayduk
 * @date 25.05.2019
 */
public interface EmployeeService {

    void setEmployeeAttribute(HttpServletRequest request) throws ServiceExecuttingException;

    void setOrderEmployeeAttribute(HttpServletRequest request) throws ServiceExecuttingException;

    void setFreeEmployeeAttribute(HttpServletRequest request) throws ServiceExecuttingException;

    void changeState(HttpServletRequest request) throws ServiceExecuttingException;

    void setOrderWorker(HttpServletRequest request) throws ServiceExecuttingException;

}
