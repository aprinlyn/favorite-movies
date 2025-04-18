package com.example.movies.service.impl;

import com.example.movies.exception.ResourceNotFoundException;
import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        LocalDateTime now = LocalDateTime.now();
        movie.setCreatedAt(now);
        movie.setUpdatedAt(now);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(String id, Movie movieDetails) {
        return movieRepository.findById(id)
                .map(existingMovie -> {
                    existingMovie.setTitle(movieDetails.getTitle());
                    existingMovie.setDirector(movieDetails.getDirector());
                    existingMovie.setReleaseYear(movieDetails.getReleaseYear());
                    existingMovie.setGenre(movieDetails.getGenre());
                    existingMovie.setActors(movieDetails.getActors());
                    existingMovie.setPlot(movieDetails.getPlot());
                    existingMovie.setRating(movieDetails.getRating());
                    existingMovie.setUpdatedAt(LocalDateTime.now());
                    return movieRepository.save(existingMovie);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
    }

    @Override
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
} 