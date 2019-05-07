package by.epam.javawebtraining.gayduknikita.webproject.exception;

/**
 * @author NikitaGayduk
 * @date 04.05.2019
 */
public class CommandExecutingException extends Exception {
    public CommandExecutingException() {
    }

    public CommandExecutingException(String message) {
        super(message);
    }

    public CommandExecutingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandExecutingException(Throwable cause) {
        super(cause);
    }
}
