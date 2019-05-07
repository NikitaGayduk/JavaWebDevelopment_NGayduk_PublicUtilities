package by.epam.javawebtraining.gayduknikita.webproject.exception;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class DAOSQLException extends Exception {
    public DAOSQLException() {
    }

    public DAOSQLException(String message) {
        super(message);
    }

    public DAOSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOSQLException(Throwable cause) {
        super(cause);
    }
}
