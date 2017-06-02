package com.example.penghong.multilanguagetestflight1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by penghong on 21/10/16.
 */

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment newFragment = new SettingsPreferenceFragment();
            ft.replace(R.id.fragment, newFragment, "settingsPreferenceFragment");
//            ft.addToBackStack(newFragment.getClass().getName());
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {

//        getSupportFragmentManager().getFragments()
//        getSupportFragmentManager().popBackStack();
//        getSupportFragmentManager().beginTransaction().commit();

        super.onBackPressed();

    }
}
