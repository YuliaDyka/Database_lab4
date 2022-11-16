package com.api.exception;

public class DoesNotHaveException extends RuntimeException {
    public DoesNotHaveException(Integer actorId, Integer filmId, String curentName, String targetName){
        super(curentName +" with id=" + actorId +  " doesn't have" + targetName + " with id=" + filmId);
    }
}