package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.logicexception.ValidationException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AccountDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.DAOFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EntityDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.BaseTenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Role;
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
    private static final AccountDAO accountDAO = DAOFactory.getAccountDao();
    private static final TenantDAO tenantDAO = new BaseTenantDAO();

    @Override
    public void tenantRegister(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            //ValidatorsFactory.getRegistrationValidator().validate(request);
            Account account = new Account(request.getParameter(Constants.LOGIN_PARAMETER)
                    ,request.getParameter(Constants.PASSWORD_PARAMETER)
                    , Role.valueOf(Constants.ROLE_TENANT_NAME));
            accountDAO.add(account);

/*        } catch (ValidationException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);*/
        } catch (DAOSQLException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }

    @Override
    public void goRegistrationPage(HttpServletRequest request, HttpServletResponse response) throws ServiceExecuttingException {
        try {
            request.getRequestDispatcher("/jsp/registration.jsp").forward(request,response);
        } catch (IOException exc){
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        } catch (ServletException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }
}
