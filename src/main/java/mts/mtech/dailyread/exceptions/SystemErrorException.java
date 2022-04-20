package mts.mtech.dailyread.exceptions;

/**
 * @author Mitchell T Severa
 * 9/4/2018
 * 11:33 AM
 */
public class SystemErrorException extends RuntimeException{

    public SystemErrorException(String message) {
        super(message);
    }
}