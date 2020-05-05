package com.dewaara.moviehub.utils;

import com.dewaara.moviehub.R;
import com.dewaara.moviehub.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies() {

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Judwa", R.drawable.judwaa,R.drawable.slide2));
        lstMovies.add(new Movie("Movie Ramleela",R.drawable.ramleela,R.drawable.slide1));
        lstMovies.add(new Movie("October Movie",R.drawable.octover_movie,R.drawable.slide2));
        lstMovies.add(new Movie("Movie Simba",R.drawable.simba,R.drawable.slide1));
        lstMovies.add(new Movie("Ramleela",R.drawable.ramleela,R.drawable.slide2));
        lstMovies.add(new Movie("Kabir Singh",R.drawable.judwaa,R.drawable.slide1));

        return lstMovies;

    }

    public static List<Movie> getWeekmovies() {

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Judwa", R.drawable.judwaa,R.drawable.slide2));
        lstMovies.add(new Movie("Movie Ramleela",R.drawable.ramleela,R.drawable.slide1));
        lstMovies.add(new Movie("October Movie",R.drawable.octover_movie,R.drawable.slide2));
        lstMovies.add(new Movie("Movie Simba",R.drawable.simba,R.drawable.slide1));


        return lstMovies;

    }

}
