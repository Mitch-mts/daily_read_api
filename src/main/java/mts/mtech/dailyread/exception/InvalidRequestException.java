package mts.mtech.dailyread.exception;

/**
 * @author Mitchell Tawanda Severa
 * 9/2/18
 * 8:33 AM
 */
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message, Exception cause) {
        super(message,cause);
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
