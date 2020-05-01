package com.dewaara.moviehub.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.dewaara.moviehub.models.Movie;
import com.dewaara.moviehub.adapters.MovieAdapter;
import com.dewaara.moviehub.adapters.MovieItemClickListener;
import com.dewaara.moviehub.R;
import com.dewaara.moviehub.models.Slide;
import com.dewaara.moviehub.adapters.SliderPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);

        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);

        // SETUP AT TIME
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(),1000,3000);

        indicator.setupWithViewPager(sliderpager,true);

        // RecyclerView setup

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Judwa",R.drawable.judwaa,R.drawable.slide2));
        lstMovies.add(new Movie("Movie Ramleela",R.drawable.ramleela,R.drawable.slide1));
        lstMovies.add(new Movie("October Movie",R.drawable.octover_movie,R.drawable.slide2));
        lstMovies.add(new Movie("Movie Simba",R.drawable.simba,R.drawable.slide1));
        lstMovies.add(new Movie("Ramleela",R.drawable.ramleela,R.drawable.slide2));
        lstMovies.add(new Movie("Kabir Singh",R.drawable.judwaa,R.drawable.slide1));

        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies, this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));


    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        // Here, I sent mivie information to the MoviedetailActivity
        // Also, I create the translation animation between the two activity

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        // create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                                                    movieImageView,"sharedName");

        startActivity(intent,options.toBundle());

        Toast.makeText(this, "item clicked : " + movie.getTitle(),Toast.LENGTH_SHORT).show();
    }


    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }




}
