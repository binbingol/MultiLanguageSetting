package com.example.penghong.multilanguagetestflight1;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.support.v7.preference.PreferenceManager;

/**
 * Created by penghong on 18/10/16.
 */

public class LanguagePreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setPreferenceScreen(PreferenceManager.);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onPause() {
//        Language.setFromPreference(getActivity(), "language", true);

        super.onPause();
    }

    private CharSequence getEntryType (ListPreference pref, String value) {
        int index = pref.findIndexOfValue(value);
        return pref.getEntries()[index];
    }

    private CharSequence getEntryValue (ListPreference pref, String entry) {
        int index = -1;
        if (entry != null && pref.getEntries() != null) {
            for(int i = pref.getEntries().length -1; i >= 0; --i) {
                if (pref.getEntries()[i].equals(entry)) {
                    index = i;
                    break;
                }
            }
        }
        return index != -1 ? pref.getEntryValues()[index] : null;
    }
}
