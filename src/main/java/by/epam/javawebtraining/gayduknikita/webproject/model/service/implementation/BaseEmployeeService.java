package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EmployeeDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.OrderDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AccountDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.EmployeeDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.OrderDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.EmployeeService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import by.epam.javawebtraining.gayduknikita.webproject.util.TimestampBuilder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NikitaGayduk
 * @date 25.05.2019
 */
public class BaseEmployeeService implements EmployeeService {
    private static final BaseEmployeeService instance = new BaseEmployeeService();
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final AccountDAO accountDAO = AccountDAOImpl.getInstance();
    private static final EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();

    private BaseEmployeeService() {
    }

    public static BaseEmployeeService getInstance(){
        return instance;
    }

    @Override
    public void setEmployeeAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            List<Employee> employeesList = employeeDAO.getAllWorkingEmployee();
            request.setAttribute(Constants.EMPLOYEE_LIST_ATTRIBUTE, employeesList);

            Map<Integer, Account> accountMap = new HashMap<>();
            for (Employee employee : employeesList) {
                Account account = accountDAO.get(employee.getAccountID());
                accountMap.put(account.getId(), account);
            }
            request.getSession().setAttribute(Constants.ACCOUNT_MAP_ATTRIBUTE, accountMap);

        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void setOrderEmployeeAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            int orderId = ((Order) request.getSession().getAttribute(Constants.ORDER_ATTRIBUTE)).getId();

            List<Employee> employeesList = employeeDAO.getEmployeeByOrderId(orderId);
            request.setAttribute(Constants.EMPLOYEE_LIST_ATTRIBUTE, employeesList);

        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void setFreeEmployeeAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            Order order = ((Order) request.getSession().getAttribute(Constants.ORDER_ATTRIBUTE));

            // TODO: 26.05.2019 add timestamp validator (begin < end)
            List<Employee> employeesList = employeeDAO.getAllFreeEmployee(order.getWorksBegin(), order.getWorksEnd());
            request.setAttribute(Constants.FREE_EMPLOYEE_LIST_ATTRIBUTE, employeesList);

        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void changeState(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            int employeeId = Integer.parseInt(request.getParameter(Constants.PARAMETER_EMPLOYEE_ID));
            Employee employee = employeeDAO.get(employeeId);
            employee.setEmployeeState(Employee.EmployeeState.valueOf(request.getParameter(Constants.PARAMETER_EMPLOYEE_STATE)));
            employeeDAO.update(employee);
        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void setOrderWorker(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            int employeeId = Integer.parseInt(request.getParameter(Constants.EMPLOYEE_ID));
            int orderId = ((Order) request.getSession().getAttribute(Constants.ORDER_ATTRIBUTE)).getId();
            employeeDAO.setOrderWorker(employeeId, orderId);
        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }
}
