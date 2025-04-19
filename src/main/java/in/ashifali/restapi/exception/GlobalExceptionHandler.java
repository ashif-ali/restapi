package in.ashifali.restapi.exception;


import in.ashifali.restapi.io.ErrorObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


/**
 * Global exception handler for the application
 * @author Ashif Ali
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourseNotFoundException.class)
    public ErrorObject handleResourceNotFoundException(ResourseNotFoundException ex, WebRequest request) {
        log.error("Throwing the ResourceNotFoundException from GlobalExceptionHandler: {}", ex.getMessage());
        return ErrorObject.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timestamp(new Date())
                .errorCode("RESOURCE_NOT_FOUND")
                .build();
    }
}

