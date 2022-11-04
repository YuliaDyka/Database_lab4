package com.api.exception;

public class HasNoContainsException  extends RuntimeException {
    public HasNoContainsException(Integer actorId, Integer filmId, String curentName, String targetName){
        super(curentName +" with id=" + actorId +  " doesn't have" + targetName + " with id=" + filmId);
    }
}