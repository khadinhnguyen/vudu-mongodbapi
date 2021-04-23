package com.nguyendkha.vudumongodbapi.controller;

import com.nguyendkha.vudumongodbapi.exception.MovieCollectionException;
import com.nguyendkha.vudumongodbapi.model.Movie;
import com.nguyendkha.vudumongodbapi.service.MovieService;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@CrossOrigin("*") // allow all inward connection-> only use in development stage
public class MovieController {


    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovies(){
        List<Movie> movies = movieService.getAllMovie();
        return new ResponseEntity<>(movies, movies.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }


    @GetMapping("/movie/{id}")
    public ResponseEntity<?> retriveMovie(@PathVariable("id") String id)  {
        try{
            Movie movie = movieService.getOneMovie(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }catch (MovieCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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

//    @PostMapping(
//            path = "/movie/image/{id}/upload",
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public void uploadUserProfileImg(@PathVariable ("id") String id,
//                                     @RequestParam ("file1") MultipartFile file1) {
//        userProfileService.uploadUserProfileImage(userProfileId, file);
//        movieService.uploadSmallPosterImg(id,file1);
//
//    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<?> updateOneMovie(@PathVariable("id") String id, @RequestBody Movie movie){
        try{
            movieService.updateOneMove(id, movie);
            return new ResponseEntity<>("Movie is successfully updated", HttpStatus.OK);
        }catch(MovieCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteOneMovie(@PathVariable("id") String id){
        try{
            movieService.deleteMovie(id);
            return new ResponseEntity<>("movie is successfully deleted", HttpStatus.OK);
        }catch (MovieCollectionException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
