package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.implementation;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.BaseDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.EntityDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.TenantDAO;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Entity;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Tenant;

import java.util.List;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public class BaseTenantDAO extends BaseDAO implements EntityDAO<Integer, Tenant>, TenantDAO {
    @Override
    public List<Tenant> getAll() throws DAOSQLException {
        return null;
    }

    @Override
    public Tenant get(Integer id) throws DAOSQLException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAOSQLException {
        return false;
    }

    @Override
    public int add(Tenant entity) throws DAOSQLException {
        return 0;
    }

    @Override
    public boolean update(Tenant entity) throws DAOSQLException {
        return false;
    }
}
