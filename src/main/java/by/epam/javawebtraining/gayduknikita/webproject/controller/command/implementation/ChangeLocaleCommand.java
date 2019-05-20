package by.epam.javawebtraining.gayduknikita.webproject.controller.command.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.Command;
import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CommandResult;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

/**
 * @author NikitaGayduk
 * @date 19.05.2019
 */
public class ChangeLocaleCommand implements Command {
    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws CommandExecutingException {
        String newLocale = request.getParameter(Constants.LOCALE);

        request.getSession().setAttribute(Constants.LOCALE, newLocale);
        Config.set(request.getSession(), Config.FMT_LOCALE, newLocale);

        return new CommandResult(request.getRequestURI(), CommandResult.Action.REDIRECT);
    }
}
