package com.example.penghong.multilanguagetestflight1;


import android.content.Context;
//import android.preference.Preference;
import android.support.v7.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by penghong on 22/10/16.
 */

public class CustomLanguagePreference extends Preference {

    public RadioButton  mRadioButton;
//    public RadioGroup   mRadioGroup;

    private View        mView;
    private LayoutInflater    mInflater;

    public CustomLanguagePreference(Context context) {
        super(context);
        init();
    }

    public CustomLanguagePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomLanguagePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomLanguagePreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

//    @Override
    public boolean isChecked() {
//        return super.isChecked();
        return mRadioButton.isChecked();
    }
//
//    @Override
    public void setChecked(boolean checked) {

        if (mRadioButton == null) {
            Log.d("CustomPreference", "radiobutton is null");
            return;

        }
//        super.setChecked(checked);
        mRadioButton.setChecked(checked);
//        mRadioButton.invalidate();


    }

    @Override
    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {

        if (mRadioButton == null) {
            Log.d("CustomPreference", "radiobutton1 is null");
        }
        super.setOnPreferenceClickListener(onPreferenceClickListener);
    }

    @Override
    public void setWidgetLayoutResource(int widgetLayoutResId) {
        super.setWidgetLayoutResource(widgetLayoutResId);
        mView = mInflater.inflate(widgetLayoutResId, null);
//        mRadioGroup = (RadioGroup) mView.findViewById(R.id.radioGroup);
        mRadioButton = (RadioButton) mView.findViewById(R.id.radioButton);

//        mRadioButton.setVisibility(View.GONE);

        if (mRadioButton == null) {
            Log.d("CustomPreference", "radiobutton is null");
        }
    }

    private void init() {
//        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater = LayoutInflater.from(getContext());
        mView = mInflater.inflate(R.layout.item_radiobuttonfalse, null);
//        mView = mInflater.inflate(widgetLayoutResId, null);
//        mRadioGroup = (RadioGroup) mView.findViewById(R.id.radioGroup);
        mRadioButton = (RadioButton) mView.findViewById(R.id.radioButton);
    }
}
