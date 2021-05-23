package com.nguyendkha.vudumongodbapi.repository;

import com.nguyendkha.vudumongodbapi.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Optional<Movie> findByTitle(String title);
    List<Movie> findByCategory(String category);
    List<Movie> findByFeature(String feature);

}
