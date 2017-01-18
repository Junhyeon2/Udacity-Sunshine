package com.example.android.sunshine.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
//[Lesson2] 15.Implement limits part1 - 02. EditTextPreference 상속 받아 Custom EditTextPreference 정의
public class LocationEditTextPreference extends EditTextPreference{
    private static final int DEFAULT_MINIMUM_LENGTH = 2;
    private int mMinLength;

    public LocationEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LocationEditTextPreference,
                0,
                0
        );

        try {
            mMinLength = typedArray.getInteger(R.styleable.LocationEditTextPreference_minLength, DEFAULT_MINIMUM_LENGTH);
        } finally {
            typedArray.recycle();
        }
    }
}
