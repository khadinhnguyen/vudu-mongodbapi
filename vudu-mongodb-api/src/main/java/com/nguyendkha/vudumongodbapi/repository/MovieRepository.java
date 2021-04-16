package com.nguyendkha.vudumongodbapi.repository;

import com.nguyendkha.vudumongodbapi.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    //@Query("{'title': ?0}") // passed in parameter index. ?0 is parameter index at 0
    Optional<Movie> findByTitle(String title);
}
