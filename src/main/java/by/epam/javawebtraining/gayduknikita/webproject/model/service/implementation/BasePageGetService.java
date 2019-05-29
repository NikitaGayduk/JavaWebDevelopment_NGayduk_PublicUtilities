package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AccountDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.EmployeeDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.TenantDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.PageGetService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public class BasePageGetService implements PageGetService {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final BasePageGetService instance = new BasePageGetService();

    private BasePageGetService() {
    }

    public static BasePageGetService getInstance() {
        return instance;
    }

    @Override
    public String getPageByRole(HttpServletRequest request) throws ServiceExecuttingException {

        String result = null;

        Account account = (Account) request.getSession().getAttribute(Constants.ACCOUNT_ATTRIBUTE);

        try {
            if (account != null) {

                if (account.getRole() == Role.ADMINISTRATOR) {

                    BaseEmployeeService.getInstance().setEmployeeAttribute(request);
                    result = Constants.ADMIN_MAIN_PAGE_PATH;

                } else if (account.getRole() == Role.TENANT) {
                    Tenant tenant = TenantDAOImpl.getInstance().getTenantByAccount(account);
                    request.getSession().setAttribute(Constants.TENANT_ATTRIBUTE, tenant);
                    BaseOrderService.getInstance().setTenantOrdersAttribute(request);
                    result = Constants.TENANT_MAIN_PAGE_PATH;

                } else if (account.getRole() == Role.WORKER || account.getRole() == Role.OPERATOR) {
                    Employee employee = EmployeeDAOImpl.getInstance().getEmployeeByAccount(account);

                    request.getSession().setAttribute(Constants.EMPLOYEE_ATTRIBUTE, employee);

                    if (account.getRole() == Role.WORKER) {
                        BaseOrderService.getInstance().setWorkerOrdersAttribute(request);
                        result = Constants.WORKER_MAIN_PAGE_PATH;
                    } else {
                        BaseOrderService.getInstance().setOperatorOrdersAttribute(request);
                        result = Constants.OPERATOR_MAIN_PAGE_PATH;
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
}
