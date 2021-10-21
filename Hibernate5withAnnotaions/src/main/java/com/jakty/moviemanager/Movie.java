package com.jakty.moviemanager;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MOVIE_MANAGER")
//@GenericGenerator(name = "idgen" , strategy = "increment")
public class Movie {

    @Id
    @Column(name = "MOVIEID")
//    @GeneratedValue(generator = "idgen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(name = "MOVIENAME")
    private String movieName;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "RELEASEDIN")
    private Date releasedIn;

    @Column(name = "REVENUEINDOLLARS")
    private Double revenueInDollars;

    public Movie() {
    }

    public Movie(Integer movieId, String movieName, String language, Date releasedIn, Double revenueInDollars) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.language = language;
        this.releasedIn = releasedIn;
        this.revenueInDollars = revenueInDollars;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getReleasedIn() {
        return releasedIn;
    }

    public void setReleasedIn(Date releasedIn) {
        this.releasedIn = releasedIn;
    }

    public Double getRevenueInDollars() {
        return revenueInDollars;
    }

    public void setRevenueInDollars(Double revenueInDollars) {
        this.revenueInDollars = revenueInDollars;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", language='" + language + '\'' +
                ", releasedIn=" + releasedIn +
                ", revenueInDollars=" + revenueInDollars +
                '}';
    }
}
