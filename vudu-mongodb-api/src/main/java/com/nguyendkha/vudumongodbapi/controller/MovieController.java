package com.nguyendkha.vudumongodbapi.controller;

import com.nguyendkha.vudumongodbapi.exception.MovieCollectionException;
import com.nguyendkha.vudumongodbapi.model.Movie;
import com.nguyendkha.vudumongodbapi.repository.MovieRepository;
import com.nguyendkha.vudumongodbapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {


    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> movies = movieService.getAllMovie();
        return new ResponseEntity<>(movies, movies.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }

    @PostMapping("/movie")
    public ResponseEntity<?> createMovie(@RequestBody Movie movie){
        try{
            movieService.createMovie(movie);
            return new ResponseEntity<>("Movie is successfully created", HttpStatus.OK);
        }catch (MovieCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }catch(ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<?> updateOneMovie(@PathVariable("id") String id, @RequestBody Movie movie){
        try{
            movieService.updateOneMove(id, movie);
            return new ResponseEntity<>("Movie is successfully updated", HttpStatus.OK);
        }catch(MovieCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
