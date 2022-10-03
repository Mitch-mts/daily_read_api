package mts.mtech.dailyread.exception;

/**
 * @author Mitchell Tawanda Severa
 * 9/2/18
 * 8:33 AM
 */
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message, Exception cause) {
        super(message,cause);
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
