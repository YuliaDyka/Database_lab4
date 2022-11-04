package com.api.exception;

public class PersonHasBookException extends RuntimeException {
    public PersonHasBookException(Integer bookId, Integer personId){
        super("'person' with id=" + personId +  " already have 'book' with id=" + bookId);
    }
}
