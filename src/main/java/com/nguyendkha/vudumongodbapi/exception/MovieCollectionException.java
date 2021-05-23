package com.nguyendkha.vudumongodbapi.exception;

public class MovieCollectionException extends Exception{

    public static final long serialVersionID = 1L;
    public MovieCollectionException (String message) {
        super(message);
    }

    public static String NotFoundException (String id){
        return "Movie with " + id + " not found";
    }

    public static String MovieAlreadyExists () {
        return "Movie with given name already exist";
    }
}
