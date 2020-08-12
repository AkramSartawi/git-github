package com.exalt.usecase.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Optional;
import static org.springframework.http.HttpStatus.LENGTH_REQUIRED;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(PassowrdException.class)
    @ResponseStatus(LENGTH_REQUIRED)
    protected ResponseEntity<Object> handlePassowr(
            PassowrdException ex) {
        logger.error("password error length");
        ApiError apiError = new ApiError(ex.getMessage());
        return new ResponseEntity(Optional.of(apiError), LENGTH_REQUIRED);
    }

    @ExceptionHandler(EmailException.class)
    protected ResponseEntity<Object> handlePassowr(
            EmailException ex) {
        logger.error("Email alrady exit");
        ApiError apiError = new ApiError(ex.getMessage());
        return new ResponseEntity(Optional.of(apiError), LENGTH_REQUIRED);
    }

    @ExceptionHandler(GeneralException.class)
    protected ResponseEntity<Object> handlePassowr(GeneralException ex) {
        logger.error("Error {}",ex);
        ApiError apiError = new ApiError(ex.getMessage());
        return new ResponseEntity(Optional.of(apiError), ex.getError().getStatus());
    }
}