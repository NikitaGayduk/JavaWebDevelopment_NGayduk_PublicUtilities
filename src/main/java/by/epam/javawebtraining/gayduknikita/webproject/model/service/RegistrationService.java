package by.epam.javawebtraining.gayduknikita.webproject.model.service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public interface RegistrationService {

    public void register(HttpServletRequest request);

}
