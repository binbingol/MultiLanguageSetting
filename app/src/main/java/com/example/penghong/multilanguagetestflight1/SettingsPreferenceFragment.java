package com.example.penghong.multilanguagetestflight1;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.preference.Preference;
import android.util.Log;
//import android.support.v7.preference.PreferenceFragmentCompat;
import com.takisoft.fix.support.v7.preference.PreferenceFragmentCompatDividers;

import java.util.Locale;

/**
 * Created by penghong on 19/10/16.
 */

public class SettingsPreferenceFragment extends PreferenceFragmentCompatDividers/*extends PreferenceFragmentCompat*/ {
    @Override
    public void onCreatePreferencesFix(Bundle bundle, String rootKey) {
        // Load the Preferences from the XML file
//        setPreferencesFromResource(R.xml.app_preference, rootKey);
        setPreferencesFromResource(R.xml.preference_language, rootKey);

        changeLanguage();
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        try {
//            return super.onCreateView(inflater, container, savedInstanceState);
//        } finally {
//            // Uncomment this if you want to change the dividers' style
//            // setDividerPreferences(DIVIDER_PADDING_CHILD | DIVIDER_CATEGORY_AFTER_LAST | DIVIDER_CATEGORY_BETWEEN);
//        }
//    }


    private void changeLanguage() {
        final CustomLanguagePreference prefEn   = (CustomLanguagePreference) findPreference("language_en");
        final Preference prefZhrCn              = findPreference("language_zh_rCN");
        final Preference prefZhrTw              = findPreference("language_zh_rTW");

        if (prefEn != null) {

            if (prefEn instanceof CustomLanguagePreference) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getPreferenceManager().getContext());
                String lang = sharedPreferences.getString("language", "en");
                boolean radioButtonCheck = sharedPreferences.getBoolean("radioButtonCheck", true);

                if (lang.contentEquals("en") && radioButtonCheck == true) {
                    prefEn.setWidgetLayoutResource(R.layout.item_radiobuttontrue);
                } else {
                    prefEn.setWidgetLayoutResource(R.layout.item_radiobuttonfalse);
                }
            }

            prefEn.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    setLocale(Locale.ENGLISH, "en");
                    createNewLanguagePreference();
                    return true;
                }
            });
        }
        if (prefZhrCn != null) {
            if (prefZhrCn instanceof CustomLanguagePreference) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getPreferenceManager().getContext());
                String lang = sharedPreferences.getString("language", "en");
                boolean radioButtonCheck = sharedPreferences.getBoolean("radioButtonCheck", true);

                if (lang.contentEquals("zh-rCN") && radioButtonCheck == true) {
                    prefZhrCn.setWidgetLayoutResource(R.layout.item_radiobuttontrue);
                } else {
                    prefZhrCn.setWidgetLayoutResource(R.layout.item_radiobuttonfalse);
                }
            }

            prefZhrCn.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    setLocale(Locale.SIMPLIFIED_CHINESE, "zh-rCN");
                    createNewLanguagePreference();

                    return true;
                }
            });
        }
        if (prefZhrTw != null) {
            if (prefZhrTw instanceof CustomLanguagePreference) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getPreferenceManager().getContext());
                String lang = sharedPreferences.getString("language", "en");
                boolean radioButtonCheck = sharedPreferences.getBoolean("radioButtonCheck", true);

                if (lang.contentEquals("zh-rTW") && radioButtonCheck == true) {
                    prefZhrTw.setWidgetLayoutResource(R.layout.item_radiobuttontrue);
                } else {
                    prefZhrTw.setWidgetLayoutResource(R.layout.item_radiobuttonfalse);
                }
            }

            prefZhrTw.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    setLocale(Locale.TRADITIONAL_CHINESE, "zh-rTW");
                    createNewLanguagePreference();

                    return true;
                }
            });
        }
    }

    private void setLocale(Locale locale, String lang) {
        final Resources resources = getResources();
        final Configuration configuration = resources.getConfiguration();
//        if (!configuration.locale.equals(locale)) {
//            configuration.setLocale(locale);

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getPreferenceManager().getContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("language", lang);
            editor.commit();

            configuration.locale = locale;
            resources.updateConfiguration(configuration, null);
//        }
    }

    private void createNewLanguagePreference() {
//        removePreviousLanguagePreference();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment newFragment = new SettingsPreferenceFragment();
        ft.replace(R.id.fragment, newFragment,"settingsPreferenceFragment");
//        ft.addToBackStack(newFragment.getClass().getName());
//        getFragmentManager().popBackStack();
        ft.commit();


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getPreferenceManager().getContext());
//        boolean radioButtonCheck = sharedPreferences.getBoolean("radioButtonCheck", false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("radioButtonCheck", true);
        editor.commit();
    }

//    private void removePreviousLanguagePreference() {
//        Fragment prevFrag = getFragmentManager().findFragmentByTag("settingsPreferenceFragment");
//        if (prevFrag != null) {
//            Toast.makeText(getPreferenceManager().getContext(), "Remove", Toast.LENGTH_SHORT).show();
//            getFragmentManager().popBackStack();
//            getFragmentManager().beginTransaction().remove(prevFrag).commit();
//        }
//    }
}
