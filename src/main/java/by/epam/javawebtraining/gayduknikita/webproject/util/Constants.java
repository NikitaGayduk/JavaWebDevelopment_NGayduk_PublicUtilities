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
    public static final String COMMAND_LOGIN = "login";
    public static final String COMMAND_GET_REGISTRATION_PAGE = "getregistrationpage";
    public static final String COMMAND_REGISTRATION = "registration";
    public static final String COMMAND_LOGOUT = "logout";

    //validation constants
    public static final String LOGIN_REGEX = "\\A[A-Za-z0-9]{2,20}\\Z";
    public static final String PASSWORD_REGEX = "\\A[A-Za-z0-9]{5,20}\\Z";
    public static final String SURNAME_REGEX = "\\A[A-ZА-Я][a-zа-я]{2,34}\\Z";
    public static final String NAME_REGEX = "\\A[A-ZА-Я][a-zа-я]{2,24}\\Z";
    public static final String PATRONYMIC_REGEX = "\\A[A-ZА-Я][a-zа-я]{2,24}\\Z";

    //JSP attributes
    public static final String ACCOUNT_ATTRIBUTE = "account";
    public static final String TENANT_ATTRIBUTE = "tenant";

    //servlet path
    public static final String LOGIN_PATH = "/login";
    public static final String REGISTRATION_PAGE_PATH = "/jsp/registration.jsp";
    public static final String TENANT_MAIN_PAGE_PATH = "/jsp/tenantmain.jsp";

    //database keys
    public static final String ROLE_TENANT_NAME = "TENANT";

    //filter constants
    public static final String REQUEST_ENCODING ="UTF-8";

    //columns
    public static final String STREET_ID = "street_id";
    public static final String ADDRESS_ID = "address_id";
    public static final String TENANT_ID = "tenant_id";
    public static final String ACCOUNT_ID = "account_id";
    public static final String ROLE_ID = "role_id";
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_STATE_ID = "order_state_id";
    public static final String EMPLOYEE_ID = "employee_id";

    public static final String STREET_NAME = "street_name";

    public static final String ADDRESS_HOUSE = "house";
    public static final String ADDRESS_APARTMENTS = "apartments";

    public static final String TENANT_SURNAME = "tenant_surname";
    public static final String TENANT_NAME = "tenant_name";
    public static final String TENANT_PATRONYMIC = "tenant_patronymic";

    public static final String ACCOUNT_LOGIN = "account_login";
    public static final String ACCOUNT_PASSWORD = "account_password";

    public static final String ROLE_NAME = "role_name";

    public static final String ORDER_DESIRED_TIME = "desired_time";
    public static final String ORDER_WORKS_BEGIN = "works_begin";
    public static final String ORDER_WORKS_END = "works_end";
    public static final String ORDER_STATE_NAME = "order_state_name";
    public static final String ORDER_DESCRIPTION = "order_description";

    public static final String EMPLOYEE_SURNAME = "order_surname";
    public static final String EMPLOYEE_NAME = "order_name";
    public static final String EMPLOYEE_PATRONYMIC = "order_patronymic";


}
