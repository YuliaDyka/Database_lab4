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
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cityNotFoundHandler(CityNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personNotFoundHandler(PersonNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bookNotFoundHandler(BookNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(LogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String logNotFoundHandler(LogNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PersonHasBookException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String personHasBookHandler(PersonHasBookException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PersonHasNoBookException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String personHasNoBookHandler(PersonHasNoBookException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(FreeBookAbsentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String freeBookAbsentHandler(FreeBookAbsentException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PersonsExistForCityException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String personsExistForCityHandler(PersonsExistForCityException ex) {
        return ex.getMessage();
    }
}
