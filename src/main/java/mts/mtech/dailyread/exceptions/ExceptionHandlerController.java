package mts.mtech.dailyread.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Mitchell T Severa
 * 9/4/2018
 * 11:33 AM
 */

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    mts.mtech.dailyread.error.Error invalidRequestError(InvalidRequestException e) {
        return new  mts.mtech.dailyread.error.Error(4,e.getMessage());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    mts.mtech.dailyread.error.Error recordNotFound(RecordNotFoundException e) {
        return new  mts.mtech.dailyread.error.Error(4,e.getMessage());
    }

    @ExceptionHandler(SystemErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    mts.mtech.dailyread.error.Error systemError(SystemErrorException e) {
        return new  mts.mtech.dailyread.error.Error(5,e.getMessage());
    }

}
