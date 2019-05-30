package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AddressDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.OrderDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AddressDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.OrderDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.TenantDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.*;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.OrderService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.DesiredTimeValidator;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.OrderDescriptionValidator;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.OrderExecutionTimeValidator;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import by.epam.javawebtraining.gayduknikita.webproject.util.TimestampBuilder;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author NikitaGayduk
 * @date 20.05.2019
 */
public class BaseOrderService implements OrderService {
    private static final BaseOrderService instance = new BaseOrderService();
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final OrderDAO orderDAO = OrderDAOImpl.getInstance();
    private static final TenantDAO tenantDAO = TenantDAOImpl.getInstance();
    private static final AddressDAO addressDAO = AddressDAOImpl.getInstance();

    private BaseOrderService() {
    }

    public static BaseOrderService getInstance(){
        return instance;
    }

    @Override
    public String createOrder(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {

        if (!OrderDescriptionValidator.getInstance().isValid(request)
                || !DesiredTimeValidator.getInstance().isValid(request)){
            return Constants.CREATE_ORDER_PAGE_PATH;
        }

        try {
            Order order = new Order();
            Tenant tenant = (Tenant) request.getSession().getAttribute(Constants.TENANT_ATTRIBUTE);

            Timestamp timestamp = TimestampBuilder.createTimestamp(request.getParameter(Constants.PARAMETER_ORDER_DESIRED_DATE)
                    , request.getParameter(Constants.PARAMETER_ORDER_DESIRED_TIME));

            order.setDesiredTime(timestamp);
            order.setTenantID(tenant.getId());
            order.setState(OrderState.WAITING_CONFIRM);
            order.setOrderDiscription(request.getParameter(Constants.ORDER_DESCRIPTION));

            orderDAO.add(order);

            return Constants.TENANT_MAIN_PAGE_PATH;
        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void setTenantOrdersAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            Tenant tenant = (Tenant) request.getSession().getAttribute(Constants.TENANT_ATTRIBUTE);
            List<Order> ordersList = orderDAO.getOrdersByTenant(tenant);
            request.getSession().setAttribute(Constants.ORDER_LIST_ATTRIBUTE, ordersList);

        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void setWorkerOrdersAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            Employee employee = (Employee) request.getSession().getAttribute(Constants.EMPLOYEE_ATTRIBUTE);
            List<Order> ordersList = orderDAO.getOrdersByWorker(employee);

            Set<Integer> idSet = new HashSet<>();
            for (Order order : ordersList) {
                idSet.add(order.getTenantID());
            }

            Map<Integer, Tenant> tenantsMap = new HashMap<>();
            for (Integer id : idSet) {
                Tenant tenant = tenantDAO.get(id);
                tenantsMap.put(tenant.getId(), tenant);
            }

            Map<Integer, Address> addressMap = new HashMap<>();
            for (Tenant tenant : tenantsMap.values()) {
                Address address = addressDAO.get(tenant.getAddressID());
                addressMap.put(address.getId(), address);
            }

            request.setAttribute(Constants.ORDER_LIST_ATTRIBUTE, ordersList);
            request.setAttribute(Constants.TENANT_MAP_ATTRIBUTE, tenantsMap);
            request.setAttribute(Constants.ADDRESS_MAP_ATTRIBUTE, addressMap);

        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void setOperatorOrdersAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            List<Order> ordersList = orderDAO.getAwaiting();

            request.setAttribute(Constants.ORDER_LIST_ATTRIBUTE, ordersList);

        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void changeOrderState(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            int orderId = Integer.parseInt(request.getParameter(Constants.PARAMETER_ORDER_ID));
            Order order = orderDAO.get(orderId);
            order.setState(OrderState.valueOf(request.getParameter(Constants.PARAMETER_ORDER_STATE)));
            orderDAO.update(order);
            request.setAttribute(Constants.ORDER_ATTRIBUTE, order);
        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void setOrderAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            int orderId = Integer.parseInt(request.getParameter(Constants.PARAMETER_ORDER_ID));
            Order order = orderDAO.get(orderId);
            request.getSession().setAttribute(Constants.ORDER_ATTRIBUTE, order);

        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public String changeOrderExecutionTime(HttpServletRequest request) throws ServiceExecuttingException {
        changeOrderState(request);

        if(!OrderExecutionTimeValidator.getInstance().isValid(request)){
            return Constants.ORDER_TIME_PROCESSING_PAGE_PATH;
        }

        Timestamp begin = TimestampBuilder.createTimestamp(
                request.getParameter(Constants.PARAMETER_ORDER_WORKS_BEGIN_DATE)
                , request.getParameter(Constants.PARAMETER_ORDER_WORKS_BEGIN_TIME));

        Timestamp end = TimestampBuilder.createTimestamp(
                request.getParameter(Constants.PARAMETER_ORDER_WORKS_END_DATE)
                , request.getParameter(Constants.PARAMETER_ORDER_WORKS_END_TIME));

        try {
            int orderId = Integer.parseInt(request.getParameter(Constants.PARAMETER_ORDER_ID));
            Order order = orderDAO.get(orderId);
            order.setWorksBegin(begin);
            order.setWorksEnd(end);
            orderDAO.update(order);
            request.getSession().setAttribute(Constants.ORDER_ATTRIBUTE, order);

            return Constants.GET_ORDER_EMPLOYEE_PAGE;
        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }

    }
}
