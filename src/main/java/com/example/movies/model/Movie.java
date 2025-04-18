package com.example.movies.model;

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
public class Movie {

    @Id
    private String id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    @NotBlank(message = "Director is required")
    @Size(max = 100, message = "Director name must be less than 100 characters")
    private String director;

    @NotNull(message = "Release year is required")
    private Integer releaseYear;

    private String genre;
    
    private List<String> actors;
    
    private String plot;
    
    private Double rating;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
} 