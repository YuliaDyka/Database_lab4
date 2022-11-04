package com.api.exception;

public class FilmsHasActorsException extends RuntimeException{

    public FilmsHasActorsException(Integer actor_id, Integer film_id){
        super("'actor' with id=" + actor_id +  " already have 'films' with id=" + film_id);
    }
}
