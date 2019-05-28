package by.epam.javawebtraining.gayduknikita.webproject.controller.command.implementation.getpagecommand;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.Command;
import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CommandResult;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.RegistrationService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation.BaseRegistrationService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 25.05.2019
 */
public class GetEmployeeRegistrationPage implements Command {
    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws CommandExecutingException {
        try {
            RegistrationService registration = new BaseRegistrationService();
            registration.fillEmployeeRegistrationPage(request);

            return new CommandResult(Constants.EMPLOYEE_REGISTRATION_PAGE_PATH, CommandResult.Action.FORWARD);

        } catch (ServiceExecuttingException exc){
            LOGGER.error("Can't execute command", exc);
            throw new CommandExecutingException(exc);
        }
    }
}
