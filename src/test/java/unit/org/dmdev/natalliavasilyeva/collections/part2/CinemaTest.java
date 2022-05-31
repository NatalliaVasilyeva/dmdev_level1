package unit.org.dmdev.natalliavasilyeva.collections.part2;

import org.dmdev.natalliavasilyeva.collections.part2.task1.Cinema;
import org.dmdev.natalliavasilyeva.collections.part2.task1.model.Genre;
import org.dmdev.natalliavasilyeva.collections.part2.task1.model.Month;
import org.dmdev.natalliavasilyeva.collections.part2.task1.model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CinemaTest {

    private Cinema cinema;
    private Movie movie1;
    private Movie movie2;
    private Movie movie3;
    private Movie movie4;
    private Movie movie5;
    private Movie movie6;
    private Movie movie7;
    private Movie movie8;
    private Movie movie9;
    private Movie movie10;
    private Movie movie11;


    @BeforeEach
    public void createData() {
        movie1 = new Movie(1, "2010", Month.JANUARY, Genre.ACTION, 8.1);
        movie2 = new Movie(2, "2010", Month.DECEMBER, Genre.COMEDY, 5.0);
        movie3 = new Movie(3, "2010", Month.SEPTEMBER, Genre.MELODRAMA, 7.3);
        movie4 = new Movie(4, "2015", Month.FEBRUARY, Genre.DRAMA, 9.4);
        movie5 = new Movie(5, "2015", Month.JUNE, Genre.COMEDY, 10.0);
        movie6 = new Movie(6, "2015",  Month.SEPTEMBER, Genre.ACTION, 8.9);
        movie7 = new Movie(7, "2018", Month.MARCH, Genre.COMEDY, 9.9);
        movie8 = new Movie(8, "2018", Month.NOVEMBER, Genre.DRAMA, 3.6);
        movie9 = new Movie(9, "2018", Month.OCTOBER, Genre.MELODRAMA, 5.7);
        movie10 = new Movie(10, "2020", Month.JULY, Genre.ACTION, 9.6);
        movie11 = new Movie(11, "2020", Month.APRIL, Genre.DRAMA, 2.0);

        cinema = new Cinema();
        cinema.addNewMovie(movie1);
        cinema.addNewMovie(movie2);
        cinema.addNewMovie(movie3);
        cinema.addNewMovie(movie4);
        cinema.addNewMovie(movie5);
        cinema.addNewMovie(movie6);
        cinema.addNewMovie(movie7);
        cinema.addNewMovie(movie8);
        cinema.addNewMovie(movie9);
        cinema.addNewMovie(movie10);
        cinema.addNewMovie(movie11);
    }

    @AfterEach
    public void clearData() {
        cinema.getMovies().clear();
    }

    @Test
    public void shouldAddMovieTest() {
        //given
        int size = cinema.getMovies().size();

        //when
        cinema.addNewMovie(new Movie(1, "2017", Month.JANUARY, Genre.ACTION, 7.3));
        int newSize = cinema.getMovies().size();

        //then

        Assertions.assertEquals(size+1, newSize);
    }

    @Test
    public void shouldReturnAllMoviesForYearTest() {
        //given
        String year = "2010";
        HashSet<Movie> expectedMovies = new LinkedHashSet<>(){{
            add(movie1);
            add(movie2);
            add(movie3);
        }};

        //when
       Set<Movie> actualMovies = cinema.getAllMoviesByYear(year);

        //then
        Assertions.assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void shouldReturnAllMoviesForGenreTest() {
        //given
        Genre genre = Genre.ACTION;
        List<Movie> expectedMovies = new ArrayList<>(){{
            add(movie1);
            add(movie6);
            add(movie10);
        }};

        //when
        List<Movie> actualMovies = cinema.getAllMoviesByGenre(genre);

        //then
        Assertions.assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void shouldReturnAllMoviesForYearAndMonthTest() {
        //given
        String year = "2020";
        Month month = Month.JULY;
        List<Movie> expectedMovies = new ArrayList<>(){{
            add(movie10);
        }};

        //when
        List<Movie> actualMovies = cinema.getAllMoviesByYearAndMonth(year, month);

        //then
        Assertions.assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void shouldReturnTop10MoviesTest() {
        //given
        List<Movie> expectedMovies = new ArrayList<>(){{
            add(movie5);
            add(movie7);
            add(movie10);
            add(movie4);
            add(movie6);
            add(movie1);
            add(movie3);
            add(movie9);
            add(movie2);
            add(movie8);
        }};

        //when
        List<Movie> actualMovies = cinema.getTop10Movies();

        //then
        Assertions.assertEquals(expectedMovies, actualMovies);
    }

}