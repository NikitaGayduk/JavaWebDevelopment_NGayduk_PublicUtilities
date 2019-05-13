package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.AddressDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Address;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class AddressDAOImpl extends BaseDAOImpl<Integer, Address> implements AddressDAO {
    {
        getAllSQLQuery = SQLRequestContainer.ADDRESS_GET_ALL_QUERY;
        getSQLQuery = SQLRequestContainer.ADDRESS_GET_BY_ID_QUERY;
        deleteSQLQuery = SQLRequestContainer.ADDRESS_DELETE_BY_ID_QUERY;
        addSQLQuery = SQLRequestContainer.ADDRESS_ADD_QUERY;
        updateSQLQuery = SQLRequestContainer.ADDRESS_UPDATE_BY_ID_QUERY;
        daoHandler = DAOHandlerFactory.getDAOAddressHandler();
    }
}
