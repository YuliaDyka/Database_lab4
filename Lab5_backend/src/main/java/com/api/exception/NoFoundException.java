package com.api.exception;

public class NoFoundException extends RuntimeException{

    public NoFoundException(Integer id, String name){
        super("Could not find " + name +" with id=" + id);
    }

}
