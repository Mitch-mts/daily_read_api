package mts.mtech.dailyread.exceptions;

/**
 * @author Mitchell T Severa
 * 9/4/2018
 * 11:52 AM
 */
public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message) {
        super(message);
    }
}
