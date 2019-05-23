package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 20.05.2019
 */
public interface OrderService {

    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException;

    public void setTenantOrdersAttribute(HttpServletRequest request) throws ServiceExecuttingException;

    public void changeOrderState(HttpServletRequest request) throws ServiceExecuttingException;

}
