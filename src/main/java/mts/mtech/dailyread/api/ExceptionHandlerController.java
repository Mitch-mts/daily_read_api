package mts.mtech.dailyread.api;

import mts.mtech.dailyread.exception.AccessDeniedException;
import mts.mtech.dailyread.exception.InvalidRequestException;
import mts.mtech.dailyread.exception.RecordNotFoundException;
import mts.mtech.dailyread.exception.SystemErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mitchell Tawanda Severa
 * 9/2/18
 * 8:33 AM
 */

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerController {
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody mts.mtech.dailyread.error.Error invalidRequestError(InvalidRequestException e) {
        return new  mts.mtech.dailyread.error.Error(4, e.getMessage());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody mts.mtech.dailyread.error.Error recordNotFoundError(RecordNotFoundException e) {
        return new mts.mtech.dailyread.error. Error(4, e.getMessage());
    }

    @ExceptionHandler(SystemErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody mts.mtech.dailyread.error.Error systemError(SystemErrorException e) {
        return new  mts.mtech.dailyread.error.Error(5, e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody mts.mtech.dailyread.error.Error accessDeniedError(SystemErrorException e) {
        return new  mts.mtech.dailyread.error.Error(6, e.getMessage());
    }

}

