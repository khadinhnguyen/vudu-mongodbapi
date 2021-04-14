package com.nguyendkha.vudumongodbapi.repository;

import com.nguyendkha.vudumongodbapi.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
