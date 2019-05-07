package by.epam.javawebtraining.gayduknikita.webproject.exception;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class ServiceExecuttingException extends Exception {
    public ServiceExecuttingException() {
    }

    public ServiceExecuttingException(String message) {
        super(message);
    }

    public ServiceExecuttingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceExecuttingException(Throwable cause) {
        super(cause);
    }
}
