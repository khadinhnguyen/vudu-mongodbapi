package com.nguyendkha.vudumongodbapi.service;

import com.nguyendkha.vudumongodbapi.exception.MovieCollectionException;
import com.nguyendkha.vudumongodbapi.model.Movie;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface MovieService {

    List<Movie> getAllMovie();
    List<Movie> retrieveByCategory(String category);
    List<Movie> retrieveByFeature(String feature);
    Movie getOneMovie(String id) throws MovieCollectionException;
    void createMovie(Movie movie) throws MovieCollectionException , ConstraintViolationException;
    void updateOneMove(String id, Movie movie) throws MovieCollectionException;
    void deleteMovie(String id) throws MovieCollectionException;

    void uploadSmallPosterImg(String id, MultipartFile file1);



}
