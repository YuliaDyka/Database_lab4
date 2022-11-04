package com.api.controller;

import com.api.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ActorsAlreadyHasFilmsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String actorsHasFilmsHandler(ActorsAlreadyHasFilmsException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String noFoundHandler(EntityNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(FilmsAlreadyHasActorsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String FilmsHasActorsHandler(FilmsAlreadyHasActorsException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DoesNotHaveException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String hasNotContainsHandler(DoesNotHaveException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(LogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String logNotFoundHandler(LogNotFoundException ex) {
        return ex.getMessage();
    }
}
