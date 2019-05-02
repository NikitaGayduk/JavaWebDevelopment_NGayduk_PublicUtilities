package by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.util;

import by.epam.javawebtraining.gayduknikita.webproject.exception.PropertiesLoadingException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author NikitaGayduk
 * @date 24.04.2019
 */
public class DBProperties {
    private static final Logger LOGGER = Logger.getRootLogger();
    private String jdbcDriver;
    private String url;
    private String user;
    private String password;
    private int initialPoolSize;


    /**
     * This class upload database connection properties from properties file
     * @throws PropertiesLoadingException
     */
    public void loadProperties() throws PropertiesLoadingException {
        try (InputStream fis = this.getClass().getClassLoader().getResourceAsStream(Constants.DB_PROPERTIES)) {
            Properties property = new Properties();
            property.load(fis);
            jdbcDriver = property.getProperty(Constants.JDBC_DRIVER_PROPERTY_NAME);
            initialPoolSize = Integer.parseInt(property.getProperty(Constants.INITIAL_POOL_SIZE_PROPERTY_NAME));
            url = property.getProperty(Constants.URL_PROPERTY_NAME);
            user = property.getProperty(Constants.USER_PROPERTY_NAME);
            password = property.getProperty(Constants.PASSWORD_PROPERTY_NAME);

        } catch (FileNotFoundException exc) {
            LOGGER.fatal("Can't found dbconnection.properties file\n" + exc.getMessage());
            throw new PropertiesLoadingException(exc);
        } catch (IOException exc) {
            LOGGER.fatal("Problem with dbconnection.properties file\n" + exc.getMessage());
            throw new PropertiesLoadingException(exc);
        } catch (NumberFormatException exc) {
            LOGGER.fatal("Initial pool size is not integer type\n" + exc.getMessage());
            throw new PropertiesLoadingException(exc);
        }
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public String getURL() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getInitialPoolSize() {
        return initialPoolSize;
    }
}
