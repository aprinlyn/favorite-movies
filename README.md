# Favorite Movies API - Spring Boot with MongoDB

A RESTful API for favorite movie management built with Spring Boot and MongoDB.

## Features

- CRUD operations for favorite movies
- Data validation
- Error handling
- Docker support

## API Endpoints

- `POST /movies` - Add a movie to favorite
- `GET /movies` - List all favorite movies
- `GET /movies/{id}` - Get detail of a specific favorite movie
- `PUT /movies/{id}` - Edit a favorite movie
- `DELETE /movies/{id}` - Delete a favorite movie

## Prerequisites

- Java 17 or higher
- Docker and Docker Compose (for Docker deployment)
- Maven (for local development)

## Running with Docker

The easiest way to run the application is using Docker Compose:

```bash
cd favorite-movies
docker-compose up -d
```

This will start:
- MongoDB on port 27017
- Favorite Movies API application on port 8080

## Running Locally

To run the application locally:

1. Start MongoDB (using Docker or local installation):
   ```bash
   docker run -d -p 27017:27017 --name mongodb mongo:latest
   ```

2. Build and run the application:
   ```bash
   cd favorite-movies
   mvn clean install
   java -jar target/*.jar
   ```

## Using the API

Here are some example API requests:

### Add a Movie

```bash
curl -X POST http://localhost:8080/movies \
  -H "Content-Type: application/json" \
  -d '{
    "title": "The Shawshank Redemption",
    "director": "Frank Darabont",
    "releaseYear": 1994,
    "genre": "Drama",
    "actors": ["Tim Robbins", "Morgan Freeman"],
    "plot": "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
    "rating": 9.3
  }'
```

### Get All Movies

```bash
curl -X GET http://localhost:8080/movies
```

### Get Movie by ID

```bash
curl -X GET http://localhost:8080/movies/{id}
```

### Update a Movie

```bash
curl -X PUT http://localhost:8080/movies/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated Title",
    "director": "Director Name",
    "releaseYear": 2000,
    "genre": "Action",
    "actors": ["Actor 1", "Actor 2"],
    "plot": "Updated plot description",
    "rating": 8.5
  }'
```

### Delete a Movie

```bash
curl -X DELETE http://localhost:8080/movies/{id}
```

## Project Structure

```
favorite-movies/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── movies/
│   │   │               ├── controller/
│   │   │               ├── exception/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               └── MoviesApplication.java
│   │   └── resources/
│   │       └── application.properties
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
``` 