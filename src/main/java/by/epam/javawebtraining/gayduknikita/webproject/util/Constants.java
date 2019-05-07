package by.epam.javawebtraining.gayduknikita.webproject.util;

/**
 * @author NikitaGayduk
 * @date 24.04.2019
 */
public class Constants {
    //DAL constants
    public static final String DB_PROPERTIES = "/dbconnection.properties";
    public static final int DB_CONNECTION_ISVALID_TIMEOUT = 10;
    public static final String JDBC_DRIVER_PROPERTY_NAME = "jdbc_driver";
    public static final String INITIAL_POOL_SIZE_PROPERTY_NAME = "initial_pool_size";
    public static final String URL_PROPERTY_NAME = "url";
    public static final String USER_PROPERTY_NAME = "user";
    public static final String PASSWORD_PROPERTY_NAME = "password";

    //command constants
    public static final String REQUEST_COMMAND_PARAMETER = "command";
    public static final String COMMAND_PROPERTIES = "/command.properties";

    //validation constants
    public static final String LOGIN_REGEX = "\\A[A-Za-z0-9]{2,20}\\Z";
    public static final String PASSWORD_REGEX = "\\A[A-Za-z0-9]{5,20}\\Z";
    public static final String SURNAME_REGEX = "\\A[A-ZА-Я][a-zа-я]{2,34}\\Z";
    public static final String NAME_REGEX = "\\A[A-ZА-Я][a-zа-я]{2,24}\\Z";
    public static final String PATRONYMIC_REGEX = "\\A[A-ZА-Я][a-zа-я]{2,24}\\Z";

    //JSP parameters
    public static final String LOGIN_PARAMETER = "login";
    public static final String PASSWORD_PARAMETER = "password";
    public static final String TENANT_SURNAME_PARAMETER = "tenant_surname";
    public static final String TENANT_NAME_PARAMETER = "tenant_name";
    public static final String TENANT_PATRONYMIC_PARAMETER = "tenant_patronymic";

    //database keys
    public static final String ROLE_TENANT_NAME = "Tenant";

    //filter constants
    public static final String REQUEST_ENCODING ="UTF-8";
}
