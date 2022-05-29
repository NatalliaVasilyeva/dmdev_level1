package org.dmdev.natalliavasilyeva.collections.part2.task1.model;

import java.util.Objects;

public class Movie {
    private final int id;
    private final String year;
    private final String month;
    private final Genre genre;
    private final double rating;

    public Movie(int id, String year, String month, Genre genre, double rating) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Double.compare(movie.rating, rating) == 0 && Objects.equals(year, movie.year) && Objects.equals(month, movie.month) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, genre, rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }
}