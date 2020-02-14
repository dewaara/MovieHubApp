package com.dewaara.moviehub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_pager);

        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide1,"Slide Title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.slide2,"Slide Title \nmore text here"));


        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter(adapter);

    }
}
