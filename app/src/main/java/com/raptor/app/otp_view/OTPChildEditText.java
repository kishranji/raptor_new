package com.raptor.app.otp_view;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.AttributeSet;

import com.raptor.app.R;

class OTPChildEditText extends AppCompatEditText {

    public OTPChildEditText(Context context) {
        super(context);
        init(context);
    }

    public OTPChildEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OTPChildEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setCursorVisible(false);
        setTextColor(context.getResources().getColor(R.color.transparent));
        setBackgroundDrawable(null);
        setInputType(InputType.TYPE_CLASS_NUMBER);
        setSelectAllOnFocus(false);
        setTextIsSelectable(false);
    }

    @Override
    public void onSelectionChanged(int start, int end) {

        CharSequence text = getText();
        if (text != null && start != text.length() || end != text.length()) {
            setSelection(text.length(), text.length());
            return;
        }

        super.onSelectionChanged(start, end);
    }

}