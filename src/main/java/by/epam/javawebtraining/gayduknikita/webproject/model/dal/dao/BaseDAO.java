package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOSQLException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Entity;

import java.util.List;

/**
 * @author NikitaGayduk
 * @date 12.05.2019
 */
public interface BaseDAO<K, T extends Entity> {

    List<T> getAll() throws DAOSQLException;

    T get(K id) throws DAOSQLException;

    boolean delete(K id) throws DAOSQLException;

    int add(T entity) throws DAOSQLException;

    boolean update(T entity) throws DAOSQLException;

}
