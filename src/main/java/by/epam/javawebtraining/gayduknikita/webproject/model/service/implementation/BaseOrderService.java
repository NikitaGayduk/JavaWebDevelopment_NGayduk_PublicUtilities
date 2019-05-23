package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.DAOFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.OrderDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Order;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.OrderState;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.OrderService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 20.05.2019
 */
public class BaseOrderService implements OrderService {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final OrderDAO orderDAO = DAOFactory.getOrderDAO();

    @Override
    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        try {
            Order order = new Order();
            Tenant tenant = (Tenant) request.getSession().getAttribute(Constants.TENANT_ATTRIBUTE);

            Timestamp timestamp = createTimestamp(request.getParameter(Constants.PARAMETER_ORDER_DESIRED_DATE)
                    , request.getParameter(Constants.PARAMETER_ORDER_DESIRED_TIME));

            order.setDesiredTime(timestamp);
            order.setTenantID(tenant.getId());
            order.setState(OrderState.WAITING_CONFIRM);
            order.setOrderDiscription(request.getParameter(Constants.PARAMETER_ORDER_DICRIPTION));

            orderDAO.add(order);
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
        } catch (DAOException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    private Timestamp createTimestamp(String date, String time) {
        String timestamp = date + " " + time + ":00";

        return Timestamp.valueOf(timestamp);
    }
}
