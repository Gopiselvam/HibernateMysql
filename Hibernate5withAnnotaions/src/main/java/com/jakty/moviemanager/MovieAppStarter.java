package com.jakty.moviemanager;

import java.sql.Date;
import java.util.Scanner;

public interface MovieAppStarter {

    public static void main(String[] args) {

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        MovieDaoInterface dao = new MovieDao();

        whileloop:
        while (true) {
            System.out.println("Choose the number:\n1: add movie\n2: show movies\n3: delete movie\n" +
                    "4: update movie release date\n press -1 to exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    Movie movie = new Movie();
//                    System.out.println("Enter the movie Id\n");
//                    Integer movieId = sc.nextInt();
//                    movie.setMovieId(movieId);
                    System.out.println("Enter the movie name\n");
                    String movieName = sc.nextLine();
                    movie.setMovieName(movieName);
                    System.out.println("Enter the movie language\n");
                    String movieLang = sc.nextLine();
                    movie.setLanguage(movieLang);
                    System.out.println("Enter the movie release date\n");
                    String releasedIn = sc.nextLine();
                    movie.setReleasedIn(Date.valueOf(releasedIn));
                    System.out.println("Enter the estimated revenue in dollors\n");
                    Double revenue = sc.nextDouble();
                    movie.setRevenueInDollars(revenue);
                    boolean res = dao.addMovie(movie);
                    System.out.println("add movie result " + res);
                    break;

                case 2:
                    dao.showMovie();
                    break;

                case 3:
                    System.out.println("Enter the movie id to be deleted");
                    Integer movId = sc.nextInt();
                    dao.deleteMovie(movId);
                    break;

                case 4:
                    System.out.println("Enter the movie id to be updated");
                    Integer moviId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the release date of the movie");
                    String releaseDate = sc.nextLine();
                    dao.updateMovieReleaseDate(moviId, Date.valueOf(releaseDate));
                    break;


                default:
                    System.out.println("exiting");
                    break whileloop;
            }
        }

    }
}
