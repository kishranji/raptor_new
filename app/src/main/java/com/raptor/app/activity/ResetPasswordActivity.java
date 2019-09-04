package com.raptor.app.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.raptor.app.AppHelper;
import com.raptor.app.R;
import com.raptor.app.util.KToast;
import com.raptor.app.util.KeyboardUtils;

public class ResetPasswordActivity extends AppCompatActivity {

    TextView mInfo1, mInfo2, mBack, mResetTxt;
    LinearLayout mResetBTN;
    EditText mPass, mConfirmPass;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_reset_password);
        init();
    }

    private void init() {

        mInfo1 = findViewById(R.id.reset_info1);
        mInfo2 = findViewById(R.id.reset_info2);
        mBack = findViewById(R.id.reset_back);
        mResetTxt = findViewById(R.id.reset_text);
        mResetBTN = findViewById(R.id.resetBTN);
        mPass = findViewById(R.id.reset_userpass);
        mConfirmPass = findViewById(R.id.reset_confirm_userpass);


        AppHelper.setTextViewGradient(mInfo1, mInfo1.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

        AppHelper.setTextViewGradient(mInfo2, mInfo2.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

        AppHelper.setTextViewGradient(mBack, mBack.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

        AppHelper.setTextViewGradient(mResetTxt, mResetTxt.getText().toString(), new int[]{
                Color.parseColor("#3C2848"),
                Color.parseColor("#CE1C59"),
                Color.parseColor("#3C2848"),
        });

        clickListener();

    }

    private void clickListener() {
        mResetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {
                    callNextScreen();
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void callNextScreen() {

    }


    private boolean validation() {

        boolean mBoolean = true;

        if (mPass.getText().toString().trim().length() == 0) {
            mBoolean = false;
            mPass.setError("Enter your create password");
            KeyboardUtils.showSoftKeyboard(this, mPass);
        } else if (mConfirmPass.getText().toString().trim().length() == 0) {
            mBoolean = false;
            mConfirmPass.setError("Enter your confirm password");
            KeyboardUtils.showSoftKeyboard(this, mConfirmPass);
        } else if (!mPass.getText().toString().trim().equals(mConfirmPass.getText().toString().trim())) {
            mBoolean = false;
            //KToast.errorToast(this, "Create password and confirm password must be same");
        }

        return mBoolean;
    }
}
