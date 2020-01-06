package pl.beata.springbootaspect.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.beata.springbootaspect.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>();


    @EventListener(ApplicationReadyEvent.class)
    private void init() {
        movies.add(new Movie("Gwiezdne wojny: Epizod IV: Nowa Nadzieja", "1977", "George Lucas"));
        movies.add(new Movie("Pulp Fiction", "1994", "Quentin Tarantino"));
        movies.add(new Movie("One More Time With Feeling", "2016", "Andrew Dominik"));
        movies.add(new Movie("Motyl i skafander", "2007", "Julian Schnabel"));
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public boolean addMovie(Optional<Movie> movie) {
        if(Optional.of(movie).isPresent()) {
            movies.add(movie.get());

            return true;
        }

        return false;
    }
}
