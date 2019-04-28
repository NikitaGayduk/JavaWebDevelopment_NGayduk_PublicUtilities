package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Entity;

import java.util.List;

/**
 * @author NikitaGayduk
 * @date 22.04.2019
 */
public interface EntityDAO <K, T extends Entity> {

    List<T> findAll();
    T get(K id);
    boolean delete(K id);
    boolean add(T entity);
    boolean update(T entity);
}
