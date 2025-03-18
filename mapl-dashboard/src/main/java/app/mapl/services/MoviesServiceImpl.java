package app.mapl.services;


import app.mapl.models.Movie;
import app.mapl.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    MoviesRepository moviesRepository;
    /**
     * @param c
     * @return
     */
    @Override
    public Movie createMovies(Movie c) {
        return moviesRepository.save(c);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Movie getMovies(long id) {
        try {
            return moviesRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return
     */
    @Override
    public List<Movie> getAllMovies() {
          return moviesRepository.findAll();
        };

    /**
     * @param change
     * @return
     */
    @Override
    public Movie updateMovies(Movie change) {
        return moviesRepository.save(change);
    }

    /**
     * @param movieId
     * @return
     */
    @Override
    public boolean deleteMovies(long movieId) {
        try {
            moviesRepository.deleteById(movieId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
