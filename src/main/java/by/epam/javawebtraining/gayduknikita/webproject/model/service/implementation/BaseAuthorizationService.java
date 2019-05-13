package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.DAOFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.AuthorizationService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.ValidatorsFactory;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NikitaGayduk
 * @date 08.05.2019
 */
public class BaseAuthorizationService implements AuthorizationService {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final AccountDAO accountDAO = DAOFactory.getAccountDao();

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        try {
            //ValidatorsFactory.getAuthorizationValidator().validate(request);

            String login = request.getParameter(Constants.LOGIN_PARAMETER);
            String password = request.getParameter(Constants.PASSWORD_PARAMETER);

            Account account = accountDAO.getAccount(login, password);

            if (account == null) {
                response.sendRedirect(request.getContextPath() + Constants.LOGIN_PATH);
            } else {
                request.getSession().setAttribute(Constants.ACCOUNT_ATTRIBUTE, account);
                if (account.getRole() == Role.ADMINISTRATOR) {
                    request.getRequestDispatcher("/jsp/adminmain.jsp").forward(request, response);
                } else if (account.getRole() == Role.OPERATOR){
                    request.getRequestDispatcher("/jsp/operatormain.jsp").forward(request, response);
                } else if (account.getRole() == Role.TENANT){
                    request.getRequestDispatcher("/jsp/tenantmain.jsp").forward(request, response);
                } else if (account.getRole() == Role.WORKER){
                    request.getRequestDispatcher("/jsp/workermain.jsp").forward(request, response);
                }
            }

/*        } catch (ValidationException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);*/
        } catch (DAOSQLException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        } catch (IOException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        } catch (ServletException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        try {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + Constants.LOGIN_PATH);
        } catch (IOException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }
}