package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EmployeeDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.EmployeeDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.TenantDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.RegistrationService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.AccountValidator;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.NewLoginValidator;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.RegistrationValidator;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public class BaseRegistrationService implements RegistrationService {
    private static final BaseRegistrationService instance = new BaseRegistrationService();
    private static final Logger LOGGER = Logger.getRootLogger();

    private static final TenantDAO tenantDAO = TenantDAOImpl.getInstance();
    private static final EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();

    private BaseRegistrationService() {
    }

    public static BaseRegistrationService getInstance() {
        return instance;
    }

    @Override
    public String registerTenant(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            if (!AccountValidator.getInstance().isValid(request)
                    || !RegistrationValidator.getInstance().isValid(request)
                    || !NewLoginValidator.getInstance().isValid(request)) {
                BaseAddressService.getInstance().setAddressAttribute(request);
                return Constants.REGISTRATION_PAGE_PATH;
            }

            Account account = new Account();
            account.setLogin(request.getParameter(Constants.ACCOUNT_LOGIN));
            account.setPassword(request.getParameter(Constants.ACCOUNT_PASSWORD));
            account.setRole(Role.valueOf(Constants.ROLE_TENANT_NAME));

            Tenant tenant = new Tenant();
            tenant.setSurname(request.getParameter(Constants.PARAMETER_SURNAME));
            tenant.setName(request.getParameter(Constants.PARAMETER_NAME));
            tenant.setPatronymic(request.getParameter(Constants.PARAMETER_PATRONYMIC));
            tenant.setAccountID(-1);
            tenant.setAddressID(Integer.parseInt(request.getParameter(Constants.ADDRESS_ID)));

            account.setId(tenantDAO.addTenant(account, tenant));

            request.getSession().setAttribute(Constants.ACCOUNT_ATTRIBUTE, account);
            request.getSession().setAttribute(Constants.TENANT_ATTRIBUTE, tenant);

            return Constants.GET_TENANT_MAIN;
        } catch (DAOException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public String registerEmployee(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            if (!AccountValidator.getInstance().isValid(request)
                    || !RegistrationValidator.getInstance().isValid(request)
                    || !NewLoginValidator.getInstance().isValid(request)) {
                return Constants.EMPLOYEE_REGISTRATION_PAGE_PATH;
            }

            Account account = new Account();
            account.setLogin(request.getParameter(Constants.ACCOUNT_LOGIN));
            account.setPassword(request.getParameter(Constants.ACCOUNT_PASSWORD));
            account.setRole(Role.valueOf(request.getParameter(Constants.ROLE_NAME)));

            Employee employee = new Employee();
            employee.setEmployeeSurname(request.getParameter(Constants.PARAMETER_SURNAME));
            employee.setEmployeeName(request.getParameter(Constants.PARAMETER_NAME));
            employee.setEmployeePatronymic(request.getParameter(Constants.PARAMETER_PATRONYMIC));
            employee.setAccountID(-1);
            employee.setEmployeeState(Employee.EmployeeState.WORKS);

            employeeDAO.addEmployee(account, employee);

            return Constants.GET_ADMIN_MAIN;

        } catch (DAOException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void fillEmployeeRegistrationPage(HttpServletRequest request) throws ServiceExecuttingException {
        List<Employee.EmployeeState> employeeStates = Arrays.asList(Employee.EmployeeState.values());
        request.setAttribute(Constants.EMPLOYEE_STATE_LIST_ATTRIBUTE, employeeStates);
    }
}
