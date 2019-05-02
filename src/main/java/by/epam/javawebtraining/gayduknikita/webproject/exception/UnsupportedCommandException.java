package by.epam.javawebtraining.gayduknikita.webproject.exception;

/**
 * @author NikitaGayduk
 * @date 02.05.2019
 */
public class UnsupportedCommandException extends Exception {
    public UnsupportedCommandException() {
    }

    public UnsupportedCommandException(String message) {
        super(message);
    }

    public UnsupportedCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedCommandException(Throwable cause) {
        super(cause);
    }
}
