package com.api.exception;

public class FreeBookAbsentException extends RuntimeException {
    public FreeBookAbsentException(Integer bookId){
        super("There is no free 'book' with id=" + bookId);
    }
}
