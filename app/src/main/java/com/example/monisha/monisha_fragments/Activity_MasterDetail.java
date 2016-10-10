package com.example.monisha.monisha_fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

/**
 * Created by monisha on 2/10/2016.
 */
public class Activity_MasterDetail extends AppCompatActivity implements Fragment_List.OnClickListenerInt

{
private boolean mTwoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        if(savedInstanceState == null)
        {
         getSupportFragmentManager().beginTransaction().replace(R.id.main_container, Fragment_List.newInstance(1)).commit();
        }

        if(findViewById(R.id.detail_container)!= null)
            mTwoPane = true;

    }

    @Override
    public void OnClickListenerInt(int position, HashMap<String, ?> movie)
    {
        if (mTwoPane)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_container, Fragment_DetailView.newInstance(movie)).addToBackStack(null).commit();
        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, Fragment_DetailView.newInstance(movie)).addToBackStack(null).commit();
        }
    }
}
