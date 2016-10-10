package com.example.monisha.monisha_fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements FragmentCover.OnClickListenerInt {

    Fragment mcontent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
        {
            mcontent = getSupportFragmentManager().getFragment(savedInstanceState,"mcontent");
        }
        else
        {
            mcontent= FragmentCover.newInstance(R.id.fragcover);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, mcontent).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mcontent.isAdded())
        getSupportFragmentManager().putFragment(outState,"mcontent", mcontent);
    }

    @Override
    public void OnClickListenerInt(int position, HashMap<String, ?> movie) {
        mcontent=  FragAboutMe.newInstance(R.id.fragabt);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mcontent).addToBackStack(null).commit();
    }
}
