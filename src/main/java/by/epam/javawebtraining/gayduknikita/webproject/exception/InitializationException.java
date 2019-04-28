package by.epam.javawebtraining.gayduknikita.webproject.exception;

/**
 * @author NikitaGayduk
 * @date 24.04.2019
 */
public class InitializationException extends Exception {
    public InitializationException() {
    }

    public InitializationException(String message) {
        super(message);
    }

    public InitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitializationException(Throwable cause) {
        super(cause);
    }
}
