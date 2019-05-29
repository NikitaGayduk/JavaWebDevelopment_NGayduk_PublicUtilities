package by.epam.javawebtraining.gayduknikita.webproject.model.service.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.ServiceExecuttingException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AddressDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation.AddressDAOImpl;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Address;
import by.epam.javawebtraining.gayduknikita.webproject.model.service.AddressService;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 29.05.2019
 */
public class BaseAddressService implements AddressService {
    private static final BaseAddressService instance = new BaseAddressService();
    private static final Logger LOGGER = Logger.getRootLogger();

    private BaseAddressService() {
    }

    public static BaseAddressService getInstance(){
        return instance;
    }

    @Override
    public void setAddressAttribute(HttpServletRequest request) throws ServiceExecuttingException {
        try {
            List<Address> addressList = AddressDAOImpl.getInstance().getAll();
            request.setAttribute(Constants.ADDRESS_LIST_ATTRIBUTE, addressList);

        } catch (
                DAOException exc) {
            LOGGER.error(exc);
            throw new ServiceExecuttingException(exc);
        }
    }
}
