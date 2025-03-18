package app.mapl.controllers;



import app.mapl.models.Movie;
import app.mapl.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class MoviesController {
    @Autowired
    MoviesService moviesService;

    @RequestMapping(value = "/movies", method = RequestMethod.POST, consumes = "application/json")
    public Movie createMovie(@RequestBody Movie c) {
        return moviesService.createMovies(c);
    }
    @GetMapping(value = "/movies/{id}")
    public Movie getMovie(@PathVariable("id") long id) {

        return moviesService.getMovies(id);
    }


    @GetMapping(value = "/movies")
    public List<Movie> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @PutMapping(value = "/movies", consumes = "application/json")
    public Movie updateMovie(@RequestBody Movie change) {
        return moviesService.updateMovies(change);
    }
    @DeleteMapping(value = "/movies/{movieId}")
    public boolean deleteMovie(@PathVariable("movieId") long movieId) {
        return moviesService.deleteMovies(movieId);
    }


}
