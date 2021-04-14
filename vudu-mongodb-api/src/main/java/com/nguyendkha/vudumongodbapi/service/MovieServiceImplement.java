package com.nguyendkha.vudumongodbapi.service;

import com.nguyendkha.vudumongodbapi.exception.MovieCollectionException;
import com.nguyendkha.vudumongodbapi.model.Movie;
import com.nguyendkha.vudumongodbapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImplement implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovie(){
        List<Movie> movies = movieRepository.findAll();
        if(movies.size() > 0){
            return movies;
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public void createMovie(Movie movie) throws MovieCollectionException, ConstraintViolationException {
        Optional<Movie> optionalMovie = movieRepository.findByTitle(movie.getTitle());
        if(optionalMovie.isPresent()){
            throw new MovieCollectionException(MovieCollectionException.MovieAlreadyExists());
        }else{
            movie.setDateCreated(new Date(System.currentTimeMillis()));
            movieRepository.save(movie);
        }

    }
}
