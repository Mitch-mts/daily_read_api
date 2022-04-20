package mts.mtech.dailyread.error;

/**
 * @author Mitchell T Severa
 * 9/4/2018
 * 12:15 PM
 */
public class Error {
    private final int code;
    private final String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
