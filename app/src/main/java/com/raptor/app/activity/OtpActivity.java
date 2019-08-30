package com.raptor.app.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.raptor.app.AppHelper;
import com.raptor.app.R;
import com.raptor.app.otp_view.OTPListener;
import com.raptor.app.otp_view.OtpTextView;
import com.raptor.app.util.KToast;

public class OtpActivity extends AppCompatActivity {

    TextView mTitle, mTime, mBack, mResendText, mSubmitText;
    RelativeLayout mSubmit;
    Context mContext;
    OtpTextView mOtpTextView;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_otp);
        init();
    }

    private void init() {

        mTime = findViewById(R.id.otp_time);
        mTitle = findViewById(R.id.otp_heder);
        mBack = findViewById(R.id.otp_back);
        mContext = getApplicationContext();
        mTime = findViewById(R.id.otp_time);
        mTitle = findViewById(R.id.otp_heder);
        mBack = findViewById(R.id.otp_back);
        mSubmitText = findViewById(R.id.otp_submit_TXT);
        mResendText = findViewById(R.id.otp_resend_TXT);
        mSubmit = findViewById(R.id.otp_submit_BTN);
        mOtpTextView = findViewById(R.id.otp_view);

        AppHelper.setTextViewGradient(mTime, mTime.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });
        AppHelper.setTextViewGradient(mTitle, mTitle.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });
        AppHelper.setTextViewGradient(mBack, mBack.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

        clickListener();
    }


    private void clickListener() {

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOtpTextView.getOTP().trim().length() != 6) {
                    KToast.errorToast(OtpActivity.this, "Enter your OTP");
//                    Toast.makeText(mContext, "Enter your OTP", Toast.LENGTH_SHORT).show();
                } else {
                    callResetPassword();
                }
            }
        });

        mOtpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            @Override
            public void onOTPComplete(String otp) {

            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void callResetPassword() {
        Intent aIntent = new Intent(this, ResetPasswordActivity.class);
        startActivity(aIntent);
        finish();
    }
}
