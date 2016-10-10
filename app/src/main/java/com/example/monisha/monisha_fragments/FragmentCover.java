package com.example.monisha.monisha_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by monisha on 2/9/2016.
 */
public class FragmentCover extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static FragmentCover newInstance(int section_number)
    {
        FragmentCover fragment = new FragmentCover();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, section_number);
        fragment.setArguments(args);
        return fragment;
    }
    public FragmentCover()
    {

    }
    public static FragmentCover newInstance (HashMap<String, ?> movie)
    {
        //String ARG_MOVIE;
        FragmentCover fragment = new FragmentCover();
        Bundle args= new Bundle();
        args.putSerializable(ARG_SECTION_NUMBER, movie);
        fragment.setArguments(args);
        return fragment;
    }
    public interface OnClickListenerInt{
        public void OnClickListenerInt( int position, HashMap<String,?> movie);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View About_me;
        View Movie_pager;
        View Movie_list;
        View rootView = null;
        final MovieData movieD = new MovieData();
        int option = getArguments().getInt(ARG_SECTION_NUMBER);
        rootView = inflater.inflate(R.layout.fragment_cover, container, false);

        About_me = rootView.findViewById(R.id.AboutMe);
        Movie_pager = rootView.findViewById(R.id.MoviePager);
        Movie_list = rootView.findViewById(R.id.MovieList);

        final OnClickListenerInt mListener;
        try {
            mListener = (OnClickListenerInt) getContext();
        }
        catch (ClassCastException e)
        {throw new ClassCastException ("The hosting activity of the fragment" + "forget to implement onFragmentInteractionListener");
        }

        About_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieD.getItem(10);
                mListener.OnClickListenerInt(1,movie);

            }
        });
        Movie_pager.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),Activity_ViewPager.class);
                startActivity(intent);
            }
        });
        Movie_list.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),Activity_MasterDetail.class);
                startActivity(intent);
            }
        });
            return rootView;
    }
}
