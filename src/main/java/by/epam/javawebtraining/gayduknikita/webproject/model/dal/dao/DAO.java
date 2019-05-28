package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.exception.DAOException;
import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Entity;

import java.util.List;

/**
 * @author NikitaGayduk
 * @date 12.05.2019
 */
public interface DAO <T extends Entity> {

    List<T> getAll() throws DAOException;

    T get(int id) throws DAOException;

    boolean delete(int id) throws DAOException;

    int add(T entity) throws DAOException;

    boolean update(T entity) throws DAOException;

}
