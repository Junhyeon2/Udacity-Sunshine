package com.example.android.sunshine.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

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

    //[Lesson2] 17.Implement limits part2 - 01. showDialog 메소드 재정의 하여 다이얼로그에 TextChangeListener 정의
    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        EditText editText = getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //[Lesson2] 17.Implement limits part2 - 02. 텍스트가 입력이 끝난 이후에 문자열 길이를 확인하여 버튼 활성화 또는 비활성화
                Dialog dialog = getDialog();
                if(dialog instanceof AlertDialog){
                    AlertDialog alertDialog = (AlertDialog) dialog;
                    Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    if(s.length() < mMinLength){
                        positiveButton.setEnabled(false);
                    }else {
                        positiveButton.setEnabled(true);
                    }
                }
            }
        });
    }
}
