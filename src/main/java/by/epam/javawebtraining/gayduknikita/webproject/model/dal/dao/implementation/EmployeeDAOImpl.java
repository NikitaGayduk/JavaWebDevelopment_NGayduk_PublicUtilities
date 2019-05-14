package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EmployeeDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Employee;

import java.util.List;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {

    @Override
    public List<Employee> getAll() throws DAOSQLException {
        return null;
    }

    @Override
    public Employee get(int id) throws DAOSQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws DAOSQLException {
        return false;
    }

    @Override
    public int add(Employee entity) throws DAOSQLException {
        return 0;
    }

    @Override
    public boolean update(Employee entity) throws DAOSQLException {
        return false;
    }
}
