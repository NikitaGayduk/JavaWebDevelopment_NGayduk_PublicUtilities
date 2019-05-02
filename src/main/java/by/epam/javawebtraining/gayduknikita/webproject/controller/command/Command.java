package by.epam.javawebtraining.gayduknikita.webproject.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 26.04.2019
 */
public interface Command {

    String execute(HttpServletRequest request, HttpServletResponse response);
}
