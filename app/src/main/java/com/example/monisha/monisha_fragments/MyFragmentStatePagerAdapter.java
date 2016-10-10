package com.example.monisha.monisha_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by monisha on 2/10/2016.
 */
public class MyFragmentStatePagerAdapter extends FragmentPagerAdapter {
    int count;
MovieData movieData = new MovieData();
    public MyFragmentStatePagerAdapter(FragmentManager fm, int size) {
        super(fm);
        count = size;
    }

    @Override
    public Fragment getItem(int position) {
        return Fragment_DetailView.newInstance((HashMap<String,?>)movieData.getItem(position));
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l=Locale.getDefault();
        HashMap<String,?> movie = (HashMap<String,?>) movieData.getItem(position);
        String name = (String) movie.get("name");
        return name.toUpperCase(l);
    }
}
