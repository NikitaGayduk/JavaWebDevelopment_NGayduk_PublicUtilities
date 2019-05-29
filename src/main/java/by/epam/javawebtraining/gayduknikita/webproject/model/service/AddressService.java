package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public interface AddressService {

    public void setAddressAttribute(HttpServletRequest request) throws ServiceExecuttingException;

}
