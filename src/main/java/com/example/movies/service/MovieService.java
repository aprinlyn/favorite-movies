package com.example.movies.service;

import com.example.movies.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(String id);
    Movie saveMovie(Movie movie);
    Movie updateMovie(String id, Movie movie);
    void deleteMovie(String id);
} 