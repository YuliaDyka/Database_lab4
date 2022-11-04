package com.api.exception;

public class PersonHasNoBookException extends RuntimeException {
    public PersonHasNoBookException(Integer bookId, Integer personId){
        super("'person' with id=" + personId +  " doesn't have 'book' with id=" + bookId);
    }
}
