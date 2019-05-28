package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EmployeeDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AccountDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.EmployeeDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.TenantDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.*;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.AuthorizationService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.AccountValidator;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.Validator;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NikitaGayduk
 * @date 08.05.2019
 */
public class BaseAuthorizationService implements AuthorizationService {
    private static final BaseAuthorizationService instance = new BaseAuthorizationService();
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final AccountDAO accountDAO = AccountDAOImpl.getInstance();
    private static final TenantDAO tenantDAO = TenantDAOImpl.getInstance();
    private static final EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();

    private BaseAuthorizationService() {
    }

    public static BaseAuthorizationService getInstance(){
        return instance;
    }

    @Override
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        try {
            if(!AccountValidator.getInstance().isValid(request)){
                return Constants.LOGIN_PATH;
            }

            Account account = accountDAO.getAccount(request.getParameter(Constants.ACCOUNT_LOGIN)
                    , request.getParameter(Constants.ACCOUNT_PASSWORD));

            String result = null;

            if (account != null) {
                request.getSession().setAttribute(Constants.ACCOUNT_ATTRIBUTE, account);

                if (account.getRole() == Role.ADMINISTRATOR) {

                    BaseEmployeeService.getInstance().setEmployeeAttribute(request);
                    result = Constants.ADMIN_MAIN_PAGE_PATH;

                } else if (account.getRole() == Role.TENANT) {
                    Tenant tenant = tenantDAO.getTenantByAccount(account);
                    request.getSession().setAttribute(Constants.TENANT_ATTRIBUTE, tenant);
                    BaseOrderService.getInstance().setTenantOrdersAttribute(request);
                    result = Constants.TENANT_MAIN_PAGE_PATH;

                } else if (account.getRole() == Role.WORKER || account.getRole() == Role.OPERATOR){
                    Employee employee = employeeDAO.getEmployeeByAccount(account);

                    if (employee.getEmployeeState() == Employee.EmployeeState.WORKS) {
                        request.getSession().setAttribute(Constants.EMPLOYEE_ATTRIBUTE, employee);

                        if (account.getRole() == Role.WORKER) {
                            BaseOrderService.getInstance().setWorkerOrdersAttribute(request);
                            result = Constants.WORKER_MAIN_PAGE_PATH;
                        } else {
                            BaseOrderService.getInstance().setOperatorOrdersAttribute(request);
                            result = Constants.OPERATOR_MAIN_PAGE_PATH;
                        }
                    } else {
                        request.getSession().invalidate();
                        result = Constants.LOGIN_PATH;
                    }

                }
            } else {
                result = Constants.LOGIN_PATH;
            }

            return result;

        } catch (DAOException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        request.getSession().invalidate();
        return Constants.LOGIN_PATH;
    }
}