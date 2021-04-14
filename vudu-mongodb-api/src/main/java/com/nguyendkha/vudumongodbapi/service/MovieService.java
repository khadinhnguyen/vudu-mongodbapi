package com.nguyendkha.vudumongodbapi.service;

import com.nguyendkha.vudumongodbapi.exception.MovieCollectionException;
import com.nguyendkha.vudumongodbapi.model.Movie;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface MovieService {

    public List<Movie> getAllMovie();
    void createMovie(Movie movie) throws MovieCollectionException , ConstraintViolationException;
    void updateOneMove(String id, Movie movie) throws MovieCollectionException;
}
