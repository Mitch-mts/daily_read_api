package mts.mtech.dailyread.exception;

/**
 * @author Mitchell Tawanda Severa
 * 9/2/18
 * 8:34 AM
 */
public class SystemErrorException extends RuntimeException {
    public SystemErrorException(String message, Exception cause) {
        super(message,cause);
    }

    public SystemErrorException(String message) {
        super(message);
    }
}
