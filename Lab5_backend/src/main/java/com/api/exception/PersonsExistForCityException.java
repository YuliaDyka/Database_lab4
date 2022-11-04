package com.api.exception;

public class PersonsExistForCityException extends RuntimeException {
    public PersonsExistForCityException(Integer id) {
        super("There are available persons for 'city' with id=" + id);
    }
}
