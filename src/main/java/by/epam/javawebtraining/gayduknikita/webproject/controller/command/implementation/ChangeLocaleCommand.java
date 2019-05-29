package by.epam.javawebtraining.gayduknikita.webproject.controller.command.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.Command;
import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CommandResult;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation.BasePageGetService;
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

        try {
            String language = request.getParameter(Constants.PARAMETER_LANGUAGE);
            request.getSession().setAttribute(Constants.LANGUAGE_ATTRIBUTE, language);

            String page = BasePageGetService.getInstance().getPageByRole(request);

            return new CommandResult(page, CommandResult.Action.FORWARD);
        } catch (ServiceExecuttingException exc) {
            LOGGER.error("Can't execute command", exc);
            throw new CommandExecutingException(exc);
        }
    }
}
