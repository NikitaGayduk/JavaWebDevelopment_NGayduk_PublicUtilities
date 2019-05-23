package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EmployeeDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.AbstractDAOHandler;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler.DAOHandlerFactory;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.requestcontainer.SQLRequestContainer;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {
    private AbstractDAOHandler<Employee> daoHandler;

    {

        daoHandler = DAOHandlerFactory.getDAOEmployeeHandler();
    }

    @Override
    public List<Employee> getAll() throws DAOException {
        return null;
    }

    @Override
    public Employee get(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean delete(int id) throws DAOException {
        return false;
    }

    @Override
    public int add(Employee entity) throws DAOException {
        return 0;
    }

    @Override
    public boolean update(Employee entity) throws DAOException {
        return false;
    }

    @Override
    public Employee getEmployeeByAccount(Account account) throws DAOException {
        Connection connection = connectionPool.getConnection();
        try {

            return getByID(SQLRequestContainer.EMPLOYEE_GET_BY_ACCOUNT_ID_QUERY, connection, daoHandler, account.getId()).get(0);

        } catch (SQLException exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new DAOException(exc);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
