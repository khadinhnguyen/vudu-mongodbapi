package com.nguyendkha.vudumongodbapi.service;

import com.nguyendkha.vudumongodbapi.exception.MovieCollectionException;
import com.nguyendkha.vudumongodbapi.model.Movie;
import com.nguyendkha.vudumongodbapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Movie> retrieveByCategory(String category) {
        List<Movie> movies = movieRepository.findByCategory(category);
        if(movies.size() > 0){
            return movies;
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public List<Movie> retrieveByFeature(String feature) {
        List<Movie> movies = movieRepository.findByFeature(feature);
        if(movies.size() > 0){
            return movies;
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public Movie getOneMovie(String id) throws MovieCollectionException {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(movieOptional.isPresent()){
            return movieOptional.get();
        } else {
            throw new MovieCollectionException(MovieCollectionException.NotFoundException(id));
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

    @Override
    public void updateOneMove(String id, Movie movie) throws MovieCollectionException {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        Optional<Movie> movieWithSameTitle = movieRepository.findByTitle(movie.getTitle());
        if(movieWithSameTitle.isPresent() && !movieWithSameTitle.get().getId().equals(id)){
            throw new MovieCollectionException(MovieCollectionException.MovieAlreadyExists());
        }
        if(movieOptional.isPresent()){
            Movie movieToBeUpdated = movieOptional.get();
            movieToBeUpdated.setTitle(movie.getTitle());
            movieToBeUpdated.setSynopsis(movie.getSynopsis());
            movieToBeUpdated.setRentalPrice(movie.getRentalPrice());
            movieToBeUpdated.setPurchasePrice(movie.getPurchasePrice());
            movieToBeUpdated.setCategory(movie.getCategory());
            movieToBeUpdated.setGenre(movie.getGenre());
            movieToBeUpdated.setRating(movie.getRating());
            movieToBeUpdated.setNumberOfStar(movie.getNumberOfStar());
            movieToBeUpdated.setFeature(movie.getFeature());
            movieRepository.save(movieToBeUpdated);
        } else {
            throw new MovieCollectionException(MovieCollectionException.NotFoundException(id));
        }
    }
    @Override
    public void uploadSmallPosterImg(String id, MultipartFile file){
        System.out.println("Hello");
    }

    @Override
    public void deleteMovie(String id) throws MovieCollectionException {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(!movieOptional.isPresent()){
            throw new MovieCollectionException(MovieCollectionException.NotFoundException(id));
        }else{
            movieRepository.deleteById(id);
        }
    }
}
