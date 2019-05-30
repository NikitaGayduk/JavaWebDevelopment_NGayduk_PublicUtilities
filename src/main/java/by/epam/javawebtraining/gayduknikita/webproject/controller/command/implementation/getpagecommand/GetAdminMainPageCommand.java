package by.epam.javawebtraining.gayduknikita.webproject.controller.command.implementation.getpagecommand;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.Command;
import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CommandResult;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation.BaseEmployeeService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation.BaseOrderService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 30.05.2019
 */
public class GetAdminMainPageCommand implements Command {
    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws CommandExecutingException {
        try {
            Role role = ((Account)request.getSession().getAttribute(Constants.ACCOUNT_ATTRIBUTE)).getRole();
            if( role == Role.ADMINISTRATOR) {
                BaseEmployeeService.getInstance().setEmployeeAttribute(request);
                return new CommandResult(Constants.ADMIN_MAIN_PAGE_PATH, CommandResult.Action.FORWARD);
            } else {
                return new CommandResult(Constants.LOGIN_PATH, CommandResult.Action.FORWARD);
            }

        } catch (ServiceExecuttingException exc){
            LOGGER.error("Can't execute command", exc);
            throw new CommandExecutingException(exc);
        }
    }
}
