package com.jakty.moviemanager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class MovieDao implements MovieDaoInterface{

    @Override
    public boolean addMovie(Movie movie) {
        Session session = DButils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Serializable opMovie =  session.save(movie);
        if(opMovie == null){
            tx.rollback();
            return false;
        }
        tx.commit();
        session.close();
        System.out.println("Successfully added movie; movie id = "+opMovie);
        return true;
    }

    @Override
    public void showMovie() {

        Session session = DButils.getSessionFactory().openSession();
        List<Movie> list = session.createQuery("FROM Movie").list();
        list.stream().forEach(System.out::println);

    }

    @Override
    public Movie updateMovieReleaseDate(Integer movieId, Date releaseDate) {

        Session session = DButils.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, movieId);


        if(movie == null){
            session.getTransaction().rollback();
            return null;
        }
        movie.setReleasedIn(releaseDate);
        session.update(movie);
        session.getTransaction().commit();


        return movie;
    }

    @Override
    public boolean deleteMovie(Integer movieId) {
        Session session = DButils.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, movieId);
        if(movie == null){
            return false;
        }
        session.delete(movie);
        session.getTransaction().commit();
        return true;
    }
}
