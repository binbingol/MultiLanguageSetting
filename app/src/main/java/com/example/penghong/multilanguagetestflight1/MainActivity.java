package com.example.penghong.multilanguagetestflight1;

//import android.app.Fragment;
//import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
//import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Locale;

public class MainActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Read from app base locale and determine the starting language */
        Locale locale = getLocale(this);
        if (!locale.equals(getResources().getConfiguration().locale)) {
            setLocale();
            recreate();
        }

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment newFrag = new MainFragment();
            ft.replace(R.id.fragment, newFrag);
            ft.commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction(); //getFragmentManager().beginTransaction();
////                Fragment prev = getSupportFragmentManager().findFragmentByTag("settingsFragment"); //getFragmentManager().findFragmentByTag("dialog");
////                if (prev != null) {
////                    ft.remove(prev);
////                }
////                ft.addToBackStack(null);
//
//                // Create and show the dialog.
//                Fragment newFragment = new SettingsPreferenceFragment();
//                ft.replace(R.id.fragment, newFragment, "settingsPreferenceFragment");
//                ft.addToBackStack(newFragment.getClass().getName());
//                ft.commit();

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.preferences) {
            Intent intent = new Intent();
            intent.setClass(this, LanguagePreferenceActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
