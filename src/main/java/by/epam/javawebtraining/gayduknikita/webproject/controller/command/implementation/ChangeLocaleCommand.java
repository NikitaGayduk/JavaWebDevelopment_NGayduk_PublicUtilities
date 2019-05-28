package by.epam.javawebtraining.gayduknikita.webproject.controller.command.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.Command;
import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CommandResult;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

/**
 * @author NikitaGayduk
 * @date 19.05.2019
 */
public class ChangeLocaleCommand implements Command {
    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandExecutingException {

            String language = request.getParameter(Constants.PARAMETER_LANGUAGE);
            request.getSession().setAttribute(Constants.LANGUAGE_ATTRIBUTE, language);

        System.out.println(request.getContextPath());
        System.out.println(request.getRequestURI());
        System.out.println(request.getPathInfo());
        System.out.println(request.getPathTranslated());
        System.out.println(request.getRequestURL());
        System.out.println(request.getServletPath());
        System.out.println(request.getLocalName());

            return new CommandResult(request.getRequestURI(), CommandResult.Action.FORWARD);
    }
}
