package org.dmdev.natalliavasilyeva.collections.part2.task1;

import org.dmdev.natalliavasilyeva.collections.part2.task1.model.Genre;
import org.dmdev.natalliavasilyeva.collections.part2.task1.model.Month;
import org.dmdev.natalliavasilyeva.collections.part2.task1.model.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {

    private final Map<String, Set<Movie>> movies;

    public Cinema() {
        this.movies = new TreeMap<>();
    }

    public Map<String, Set<Movie>> getMovies() {
        return movies;
    }

    public void addNewMovie(Movie movie) {
        Set<Movie> existMovies = getAllMoviesByYear(movie.getYear());
        existMovies.add(movie);
        movies.put(movie.getYear(), existMovies);
    }

    public Set<Movie> getAllMoviesByYear(String year) {
        return movies.getOrDefault(year, new LinkedHashSet<>());
    }

    public List<Movie> getAllMoviesByGenre(Genre genre) {
        List<Movie> moviesByGenre = new ArrayList<>();
        for (Map.Entry<String, Set<Movie>> entry : movies.entrySet()) {
            for (Movie movie : entry.getValue()) {
                if (movie.getGenre().equals(genre)) {
                    moviesByGenre.add(movie);
                }
            }
        }
        return moviesByGenre;
    }

    public List<Movie> getAllMoviesByYearAndMonth(String year, Month month) {
        List<Movie> moviesByYearAndMonth = new ArrayList<>();
        Set<Movie> moviesByYear = getAllMoviesByYear(year);
        if (!moviesByYear.isEmpty()) {
            for (Movie movie : moviesByYear) {
                if (movie.getMonth().equals(month)) {
                    moviesByYearAndMonth.add(movie);
                }
            }
        }
        return moviesByYearAndMonth;
    }

    public List<Movie> getTop10Movies() {
        Comparator<Movie> ratingComparator = Comparator.comparingDouble(Movie::getRating).reversed();
        List<Movie> moviesByRaiting = new ArrayList<>();
        for (Map.Entry<String, Set<Movie>> entry : movies.entrySet()) {
            moviesByRaiting.addAll(entry.getValue());
        }
        moviesByRaiting.sort(ratingComparator);
        return moviesByRaiting.size() >= 10 ? moviesByRaiting.subList(0, 10) : moviesByRaiting.subList(0, moviesByRaiting.size() - 1);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "films=" + movies +
                '}';
    }
}