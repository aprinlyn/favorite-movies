package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByDirectorContainingIgnoreCase(String director);
    List<Movie> findByGenre(String genre);
    List<Movie> findByReleaseYear(Integer releaseYear);
} 