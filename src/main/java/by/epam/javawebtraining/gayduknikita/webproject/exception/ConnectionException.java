package by.epam.javawebtraining.gayduknikita.webproject.exception;

/**
 * @author NikitaGayduk
 * @date 24.04.2019
 */
public class ConnectionException extends Exception {
    public ConnectionException() {
    }

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
