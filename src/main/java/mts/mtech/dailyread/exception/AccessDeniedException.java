package mts.mtech.dailyread.exception;

/**
 * @author Mitchell Tawanda Severa
 * 9/2/18
 * 8:33 AM
 */
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message, Exception cause) {
        super(message,cause);
    }

    public AccessDeniedException(String message) {
        super(message);
    }
}
