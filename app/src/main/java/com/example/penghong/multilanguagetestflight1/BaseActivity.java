package com.example.penghong.multilanguagetestflight1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
//import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;
import android.util.Log;

import java.util.Locale;

/**
 * Created by penghong on 18/10/16.
 */

public class BaseActivity extends AppCompatActivity implements PreferenceFragmentCompat.OnPreferenceStartScreenCallback {
    private Locale mLocale;

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("BaseActivity", getClass().toString() + " onStart");

        Locale locale = getLocale(this);
        if (!locale.equals(mLocale)) {
            mLocale = locale;
        } else {
            mLocale = getResources().getConfiguration().locale;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("BaseActivity", getClass().toString() + " onResume");
        Locale locale = getLocale(this);
        if (!locale.equals(mLocale)) {
            mLocale = locale;
        } else {
            mLocale = getResources().getConfiguration().locale;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("BaseActivity", getClass().toString() + " onPause");
        Locale locale = getLocale(this);
        if (!locale.equals(mLocale)) {
            mLocale = locale;
            setLocale();
            recreate();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("BaseActivity", getClass().toString() + " onRestart");
        Locale locale = getLocale(this);
        if (!locale.equals(mLocale)) {
            mLocale = locale;
            setLocale();
            recreate();
        }
    }

    public static Locale getLocale(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String lang = sharedPreferences.getString("language", "en");
        Locale locale = Locale.ENGLISH;
        switch (lang) {
            case "en":
                locale = Locale.ENGLISH;
                break;
            case "zh-rCN":
                locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case "zh-rTW":
                locale = Locale.TRADITIONAL_CHINESE;
                break;

        }
        return locale;
    }

    public void setLocale () {
        final Resources resources = getResources();
        final Configuration configuration = resources.getConfiguration();
        final Locale locale = getLocale(this);
        if (!configuration.locale.equals(locale)) {
//            configuration.setLocale(locale);
            configuration.locale = locale;
            resources.updateConfiguration(configuration, null);
        }
    }

    @Override
    public boolean onPreferenceStartScreen(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen) {
        SettingsPreferenceFragment fragment = new SettingsPreferenceFragment();
        Bundle args = new Bundle();
        args.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT, preferenceScreen.getKey());
        fragment.setArguments(args);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.fragment, fragment, preferenceScreen.getKey());
//        ft.addToBackStack(preferenceScreen.getKey());
        ft.commit();

        return true;
    }
}
