package com.jakty.moviemanager;

import org.hibernate.Session;

import java.sql.Date;

public interface MovieDaoInterface {

    public boolean addMovie(Movie movie);
    public void showMovie();
    public Movie updateMovieReleaseDate(Integer movieId, Date releaseDate);
    public boolean deleteMovie(Integer movieId);
}
