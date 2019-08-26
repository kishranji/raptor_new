package com.example.raptor.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.raptor.AppHelper;
import com.example.raptor.R;

public class OtpActivity extends AppCompatActivity {

    TextView mTitle,mTime,mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        init();
    }

    private void init() {

        mTime = findViewById(R.id.otp_time);
        mTitle = findViewById(R.id.otp_heder);
        mBack = findViewById(R.id.otp_back);

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

    }
}
