package com.example.monisha.monisha_fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by monisha on 2/10/2016.
 */
public class Activity_ViewPager extends AppCompatActivity{

    MyFragmentStatePagerAdapter myPagerAdapter;
    ViewPager mViewPager;
    MovieData movieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        movieData =new MovieData();
        myPagerAdapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(),movieData.getSize());
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(myPagerAdapter);
        //cutomizeViewPager();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

}
