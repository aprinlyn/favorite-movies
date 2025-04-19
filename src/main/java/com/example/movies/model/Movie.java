package com.example.movies.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
@Schema(description = "Movie entity representing a movie in the favorites collection")
public class Movie {

    @Id
    @Schema(description = "Unique identifier of the movie", example = "60c72b2f5e7c2a1b3c9d4e5f")
    private String id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    @Schema(description = "Title of the movie", example = "The Shawshank Redemption", required = true)
    private String title;

    @NotBlank(message = "Director is required")
    @Size(max = 100, message = "Director name must be less than 100 characters")
    @Schema(description = "Director of the movie", example = "Frank Darabont", required = true)
    private String director;

    @NotNull(message = "Release year is required")
    @Schema(description = "Year the movie was released", example = "1994", required = true)
    private Integer releaseYear;

    @Schema(description = "Genre of the movie", example = "Drama")
    private String genre;
    
    @Schema(description = "List of actors in the movie", example = "[\"Tim Robbins\", \"Morgan Freeman\"]")
    private List<String> actors;
    
    @Schema(description = "Plot summary of the movie", example = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.")
    private String plot;
    
    @Schema(description = "Rating of the movie (scale of 1-10)", example = "9.3")
    private Double rating;
    
    @Schema(description = "Timestamp when the movie was added to favorites", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;
    
    @Schema(description = "Timestamp when the movie information was last updated", accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime updatedAt;
} 