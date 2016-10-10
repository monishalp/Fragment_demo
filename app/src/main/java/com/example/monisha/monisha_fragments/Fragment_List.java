package com.example.monisha.monisha_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by monisha on 2/10/2016.
 */
public class Fragment_List extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static Fragment_List newInstance(int section_number)
    {
        Fragment_List fragment = new Fragment_List();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, section_number);
        fragment.setArguments(args);
        return fragment;
    }
    public Fragment_List()
    {

    }
    public static Fragment_List newInstance (HashMap<String, ?> movie)
    {
        //String ARG_MOVIE;
        Fragment_List fragment = new Fragment_List();
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
        View List1;
        View List2;
        View List3;
        View List4;
        View List5;
        View rootView = null;
        final MovieData movieD = new MovieData();
        int option = getArguments().getInt(ARG_SECTION_NUMBER);
        rootView = inflater.inflate(R.layout.activity_fragment_list, container, false);

        List1 = rootView.findViewById(R.id.L1);
        List2 = rootView.findViewById(R.id.L2);
        List3 = rootView.findViewById(R.id.L3);
        List4 = rootView.findViewById(R.id.L4);
        List5 = rootView.findViewById(R.id.L5);

        final OnClickListenerInt mListener;
        try {
            mListener = (OnClickListenerInt) getContext();
        }
        catch (ClassCastException e)
        {throw new ClassCastException ("The hosting activity of the fragment" + "forget to implement onFragmentInteractionListener");
        }

        List1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieD.getItem(1);
                mListener.OnClickListenerInt(1,movie);

            }
        });

        List2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieD.getItem(2);
                mListener.OnClickListenerInt(2, movie);

            }
        });
        List3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieD.getItem(3);
                mListener.OnClickListenerInt(3,movie);

            }
        });
        List4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieD.getItem(4);
                mListener.OnClickListenerInt(4,movie);

            }
        });
        List5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                HashMap<String, ?> movie = (HashMap<String, ?>) movieD.getItem(5);
                mListener.OnClickListenerInt(5,movie);

            }
        });

        return rootView;
    }
}
