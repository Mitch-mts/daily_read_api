package mts.mtech.dailyread.exceptions;

/**
 * @author Mitchell T Severa
 * 9/4/2018
 * 11:52 AM
 */
public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String message) {
        super(message);
    }
}
