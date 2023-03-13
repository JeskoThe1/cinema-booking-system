package com.application.dao.impl;

import com.application.dao.DataSource;
import com.application.model.Movie;
import com.application.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try {
            Connection connection = DataSource.getConnection();
            JDBCUserDao userDao = new JDBCUserDao();
            userDao.setConnection(connection);
            //User userToAdd = new User(1, "Bleach@gmail.com", "Bleach", "54321", false);
            //userDao.save(userToAdd);
            List<User> users = userDao.getAll();
            for(User user : users){
                System.out.println(user);
            }
            JDBCMovieDao movieDao = new JDBCMovieDao();
            movieDao.setConnection(connection);
            //Movie movieToAdd = new Movie(1, "Venom 2", "Andy Serkis", "Film just bad, don't watch more than one time", 100);
            //movieDao.save(movieToAdd);
            List<Movie> movies = movieDao.getAll();
            for(Movie movie : movies){
                System.out.println(movie);
            }
            Movie movieByID = movieDao.get(6);
            if(movieByID != null)
                System.out.println(movieByID);
            else
                System.out.println("No such movie");
            movieDao.delete(5);
            List<Movie> movies2 = movieDao.getAll();
            for(Movie movie : movies2){
                System.out.println(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
