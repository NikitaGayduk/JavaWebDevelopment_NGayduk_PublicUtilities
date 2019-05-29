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
    public static final String COMMAND_CHANGE_LOCALE = "changeLocale";

    //validation constants
    public static final String LOGIN_REGEX = "\\A[A-Za-z0-9]{2,20}\\Z";
    public static final String PASSWORD_REGEX = "\\A[A-Za-z0-9]{5,20}\\Z";

    public static final String SURNAME_REGEX = "\\A[А-Я][а-я]{2,34}\\Z";
    public static final String NAME_REGEX = "\\A[А-Я][а-я]{2,24}\\Z";
    public static final String PATRONYMIC_REGEX = "\\A[А-Я][а-я]{2,24}\\Z";

    public static final String ORDER_DESCRIPTION_REGEX = "\\A[А-Яа-я0-9 ]{5,45}\\Z";

    //JSP attributes
    public static final String LANGUAGE_ATTRIBUTE = "language";
    public static final String ACCOUNT_ATTRIBUTE = "account";
    public static final String ROLE_ATTRIBUTE = "role";
    public static final String TENANT_ATTRIBUTE = "tenant";
    public static final String EMPLOYEE_ATTRIBUTE = "employee";
    public static final String ORDER_ATTRIBUTE = "order";
    public static final String ORDER_LIST_ATTRIBUTE = "orderList";
    public static final String EMPLOYEE_LIST_ATTRIBUTE = "employeeList";
    public static final String FREE_EMPLOYEE_LIST_ATTRIBUTE = "freeEmployeeList";
    public static final String EMPLOYEE_STATE_LIST_ATTRIBUTE = "employeeStatesList";
    public static final String ACCOUNT_MAP_ATTRIBUTE = "accountMap";
    public static final String TENANT_MAP_ATTRIBUTE = "tenantMap";
    public static final String ADDRESS_MAP_ATTRIBUTE = "addressMap";
    public static final String ADDRESS_LIST_ATTRIBUTE = "addressList";
    public static final String ORDER_BEGIN_TIMESTAMP_ATTRIBUTE = "timestampBegin";
    public static final String ORDER_END_TIMESTAMP_ATTRIBUTE = "timestampEnd";

    //servlet path
    public static final String ERROR_PAGE_PATH = "/WEB-INF/jsp/errorpage/error_page.jsp";
    public static final String LOGIN_PATH = "/login";
    public static final String REGISTRATION_PAGE_PATH = "/WEB-INF/jsp/registration.jsp";
    public static final String EMPLOYEE_REGISTRATION_PAGE_PATH = "/WEB-INF/jsp/employee_registration.jsp";
    public static final String ADMIN_MAIN_PAGE_PATH = "/WEB-INF/jsp/adminmain.jsp";
    public static final String TENANT_MAIN_PAGE_PATH = "/WEB-INF/jsp/tenantmain.jsp";
    public static final String WORKER_MAIN_PAGE_PATH = "/WEB-INF/jsp/workermain.jsp";
    public static final String OPERATOR_MAIN_PAGE_PATH = "/WEB-INF/jsp/operatormain.jsp";
    public static final String CREATE_ORDER_PAGE_PATH = "/WEB-INF/jsp/create_order.jsp";
    public static final String ORDER_TIME_PROCESSING_PAGE_PATH = "/WEB-INF/jsp/process_order_time.jsp";
    public static final String ORDER_WORKERS_PROCESSING_PAGE_PATH = "/WEB-INF/jsp/process_order_workers.jsp";


    //database keys
    public static final String ROLE_TENANT_NAME = "TENANT";

    //filter constants
    public static final String REQUEST_ENCODING = "UTF-8";

    //columns
    public static final String STREET_ID = "street_id";
    public static final String ADDRESS_ID = "address_id";
    public static final String TENANT_ID = "tenant_id";
    public static final String ACCOUNT_ID = "account_id";
    public static final String ROLE_ID = "role_id";
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_STATE_ID = "order_state_id";
    public static final String EMPLOYEE_STATE_ID = "employee_state_id";
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

    public static final String EMPLOYEE_SURNAME = "employee_surname";
    public static final String EMPLOYEE_NAME = "employee_name";
    public static final String EMPLOYEE_PATRONYMIC = "employee_patronymic";
    public static final String EMPLOYEE_STATE_NAME = "employee_state_name";

    //parameters
    public static final String PARAMETER_LANGUAGE = "language";
    public static final String PARAMETER_ORDER_ID = "order_id";
    public static final String PARAMETER_ORDER_DESIRED_DATE = "order_desired_date";
    public static final String PARAMETER_ORDER_DESIRED_TIME = "order_desired_time";
    public static final String PARAMETER_ORDER_WORKS_BEGIN_DATE = "order_works_begin_date";
    public static final String PARAMETER_ORDER_WORKS_BEGIN_TIME = "order_works_begin_time";
    public static final String PARAMETER_ORDER_WORKS_END_DATE = "order_works_end_date";
    public static final String PARAMETER_ORDER_WORKS_END_TIME = "order_works_end_time";
    public static final String PARAMETER_ORDER_DICRIPTION = "order_discription";
    public static final String PARAMETER_ORDER_STATE = "order_state";

    public static final String PARAMETER_EMPLOYEE_ID = "employee_id";
    public static final String PARAMETER_EMPLOYEE_STATE = "employee_state";

    public static final String PARAMETER_SURNAME = "surname";
    public static final String PARAMETER_NAME = "name";
    public static final String PARAMETER_PATRONYMIC = "patronymic";
}
