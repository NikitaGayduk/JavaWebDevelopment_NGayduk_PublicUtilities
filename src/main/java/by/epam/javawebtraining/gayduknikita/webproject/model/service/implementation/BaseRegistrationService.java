package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.DAOFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.RegistrationService;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.validator.ValidatorsFactory;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public class BaseRegistrationService implements RegistrationService {
    private static final Logger LOGGER = Logger.getRootLogger();

    private static final TenantDAO tenantDAO = DAOFactory.getTenantDAO();


    @Override
    public void registerTenant(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            ValidatorsFactory.getRegistrationValidator().validate(request);
            Account account = new Account();
            account.setLogin(request.getParameter(Constants.ACCOUNT_LOGIN));
            account.setPassword(request.getParameter(Constants.ACCOUNT_PASSWORD));
            account.setRole(Role.valueOf(Constants.ROLE_TENANT_NAME));

            Tenant tenant = new Tenant();
            tenant.setSurname(request.getParameter(Constants.TENANT_SURNAME));
            tenant.setName(request.getParameter(Constants.TENANT_NAME));
            tenant.setPatronymic(request.getParameter(Constants.TENANT_PATRONYMIC));
            tenant.setAccountID(-1);
            tenant.setAddressID(Integer.parseInt(request.getParameter(Constants.ADDRESS_ID)));

            account.setId(tenantDAO.addTenant(account,tenant));

            request.getSession().setAttribute(Constants.ACCOUNT_ATTRIBUTE, account);
            request.getSession().setAttribute(Constants.TENANT_ATTRIBUTE, tenant);

        } catch (ValidationException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        } catch (DAOException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void registerEmployee(HttpServletRequest request) throws ServiceExecuttingException {

    }

    @Override
    public void fillTenantRegistrationPage(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        /*try {
            request.getRequestDispatcher(Constants.REGISTRATION_PAGE_PATH).forward(request,response);
        } catch (IOException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        } catch (ServletException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }*/
    }
}
