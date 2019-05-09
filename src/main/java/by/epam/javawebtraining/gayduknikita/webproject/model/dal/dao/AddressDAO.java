package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Address;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public interface AddressDAO extends EntityDAO<Integer, Address>  {

    Address getAddressByTenant(Tenant tenant) throws DAOSQLException;

}
