package by.epam.javawebtraining.gayduknikita.webproject.controller.command.implementation.getpagecommand;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.Command;
import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CommandResult;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 26.05.2019
 */
public class GetTranslatePage implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws CommandExecutingException {

        System.out.println(request.getContextPath() + request.getRequestURI());

        return new CommandResult("/main", CommandResult.Action.FORWARD);
    }
}
