package by.epam.javawebtraining.gayduknikita.webproject.controller.command.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.Command;
import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CommandResult;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.AuthorizationService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation.BaseAuthorizationService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 27.04.2019
 */
public class LogoutCommand implements Command {
    private static final Logger LOGGER = Logger.getRootLogger();

    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws CommandExecutingException {
        try {
            AuthorizationService authorization = new BaseAuthorizationService();
            authorization.logout(request, response);

            return new CommandResult(Constants.LOGIN_PATH, CommandResult.Action.REDIRECT);
        } catch (ServiceExecuttingException exc) {
            LOGGER.error("Can't execute command", exc);
            throw new CommandExecutingException(exc);
        }
    }
}
