package app.mapl.services;

import app.mapl.models.Movie;

import java.util.List;

public interface MoviesService {

    Movie createMovies(Movie c);

    Movie getMovies(long id);

    List<Movie> getAllMovies();

    Movie updateMovies(Movie change);

    boolean deleteMovies(long movieId);
}
