package by.epam.javawebtraining.gayduknikita.webproject.model.dal.dao.daohandler;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Entity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NikitaGayduk
 * @date 09.05.2019
 */
public abstract class AbstractDAOHandler<T extends Entity> {
    protected static final Logger LOGGER = Logger.getRootLogger();

    abstract public T build(ResultSet resultSet) throws SQLException;

    abstract public void parse(T entity, PreparedStatement statement, boolean useID) throws SQLException;

}
