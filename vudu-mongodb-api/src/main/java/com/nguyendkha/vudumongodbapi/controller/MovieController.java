package com.nguyendkha.vudumongodbapi.controller;

import com.nguyendkha.vudumongodbapi.model.Movie;
import com.nguyendkha.vudumongodbapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovie(){
        List<Movie> movies = movieRepository.findAll();
        if(movies.size() > 0){
            return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No data is found", HttpStatus.NOT_FOUND);
        }
    }

}
