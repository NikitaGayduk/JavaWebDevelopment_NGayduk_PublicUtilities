package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.DAOFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EmployeeDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.*;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.AuthorizationService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 08.05.2019
 */
public class BaseAuthorizationService implements AuthorizationService {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final AccountDAO accountDAO = DAOFactory.getAccountDao();
    private static final TenantDAO tenantDAO = DAOFactory.getTenantDAO();
    private static final EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();

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
                    new BaseOrderService().setTenantOrdersAttribute(request);
                    result = "/jsp/tenantmain.jsp";

                } else if (account.getRole() == Role.WORKER){
                    Employee worker = employeeDAO.getEmployeeByAccount(account);
                    request.getSession().setAttribute(Constants.EMPLOYEE_ATTRIBUTE, worker);
                    result = "/jsp/workermain.jsp";
                }
            }

            return result;

/*        } catch (ValidationException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);*/
        } catch (DAOException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
            request.getSession().invalidate();
    }
}