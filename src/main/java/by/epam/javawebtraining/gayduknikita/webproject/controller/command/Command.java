package by.epam.javawebtraining.gayduknikita.webproject.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * @author NikitaGayduk
 * @date 26.04.2019
 */
public interface Command {

    String execute(HttpServletRequest request);
}
