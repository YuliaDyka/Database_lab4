package com.api.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Integer id, String name){
        super("Could not find " + name +" with id=" + id);
    }

}
