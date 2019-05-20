package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.DAOFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;
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
    private static final TenantDAO tenantDAO = DAOFactory.getTenantDAO();

    @Override
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        try {
            //ValidatorsFactory.getAuthorizationValidator().validate(request);

            String login = request.getParameter(Constants.ACCOUNT_LOGIN);
            String password = request.getParameter(Constants.ACCOUNT_PASSWORD);

            Account account = accountDAO.getAccount(login, password);

            String result = null;

            if (account == null) {
                result = Constants.LOGIN_PATH;
            } else {
                request.getSession().setAttribute(Constants.ACCOUNT_ATTRIBUTE, account);

                if (account.getRole() == Role.ADMINISTRATOR) {
                    result = "/jsp/adminmain.jsp";

                } else if (account.getRole() == Role.OPERATOR){
                    result = "/jsp/operatormain.jsp";

                } else if (account.getRole() == Role.TENANT){
                    Tenant tenant = tenantDAO.getTenantByAccount(account);
                    request.getSession().setAttribute(Constants.TENANT_ATTRIBUTE, tenant);
                    result = "/jsp/tenantmain.jsp";

                } else if (account.getRole() == Role.WORKER){
                    result = "/jsp/workermain.jsp";
                }
            }

            return result;

/*        } catch (ValidationException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);*/
        } catch (DAOSQLException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
            request.getSession().invalidate();
    }
}