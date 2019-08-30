package com.raptor.app.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.raptor.app.AppHelper;
import com.raptor.app.R;

public class LoginActivity extends AppCompatActivity {

    TextView mLoginTextView1, mLoginTextView2, mLoginTextView3, mLoginText, mForgotPass;
    RelativeLayout mLoginBTN;
    EditText mUserName, mUserPassword;
    String mUserNameStr = "", mPasswordStr = "";
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_login);
        init();
        clickListener();

    }

    private void init() {


        mLoginTextView1 = (TextView) findViewById(R.id.login_info1);
        mLoginTextView2 = (TextView) findViewById(R.id.login_info2);
        mLoginTextView3 = (TextView) findViewById(R.id.login_info3);
        mLoginText = (TextView) findViewById(R.id.login_text);
        mLoginBTN = (RelativeLayout) findViewById(R.id.loginBTN);
        mForgotPass = (TextView) findViewById(R.id.login_forgotpassword);
        mUserName = (EditText) findViewById(R.id.login_username);
        mUserPassword = (EditText) findViewById(R.id.login_userpass);
        AppHelper.setTextViewGradient(mLoginTextView1, mLoginTextView1.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });
        AppHelper.setTextViewGradient(mForgotPass, mForgotPass.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });
        AppHelper.setTextViewGradient(mLoginTextView2, mLoginTextView2.getText().toString(), new int[]{
                Color.parseColor("#F4681E"),
                Color.parseColor("#6875D9"),
                Color.parseColor("#6875D9"),
        });
        AppHelper.setTextViewGradient(mLoginTextView3, mLoginTextView3.getText().toString(), new int[]{
                Color.parseColor("#F4681E"),
                Color.parseColor("#6875D9"),
                Color.parseColor("#6875D9"),
        });

        AppHelper.setTextViewGradient(mLoginText, mLoginText.getText().toString(), new int[]{
                Color.parseColor("#3C2848"),
                Color.parseColor("#CE1C59"),
                Color.parseColor("#3C2848"),
        });
    }

    private void clickListener() {
        mUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mUserNameStr = mUserName.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mUserPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPasswordStr = mUserPassword.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mLoginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUserNameStr.equals("")) {
                    mUserName.setError("Please fill out this filed");
                } else if (mPasswordStr.equals("")) {
                    mUserPassword.setError("Please fill out this filed");
                } else {
                    //validate login
                }
            }
        });

        mForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showForgotPasswordAlert();
            }
        });
    }


    void showForgotPasswordAlert() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.forgot_password_dialog, viewGroup, false);
        TextView mTitle = dialogView.findViewById(R.id.forgot_pass_title);
        TextView mInfo1 = dialogView.findViewById(R.id.forgot_pass_info1);
        TextView mInfo2 = dialogView.findViewById(R.id.forgot_pass_info2);
        TextView mInfo3 = dialogView.findViewById(R.id.forgot_pass_info3);
        TextView mOkayTxt = dialogView.findViewById(R.id.forgot_pass_ok_txt);
        TextView mCancelTxt = dialogView.findViewById(R.id.forgot_pass_cancel_txt);
        RelativeLayout mOkayBTN = dialogView.findViewById(R.id.forgot_pass_ok);
        RelativeLayout mCancelBTN = dialogView.findViewById(R.id.forgot_pass_cancel);
        final EditText mForgotPassUserName = dialogView.findViewById(R.id.forgot_pass_username);

        AppHelper.setTextViewGradient(mOkayTxt, mOkayTxt.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

        AppHelper.setTextViewGradient(mCancelTxt, mCancelTxt.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

        AppHelper.setTextViewGradient(mTitle, mTitle.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

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
        AppHelper.setTextViewGradient(mInfo3, mInfo3.getText().toString(), new int[]{
                Color.parseColor("#9D4FD8"),
                Color.parseColor("#D12270"),
                Color.parseColor("#F4681E"),
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();


        mOkayBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mForgotPassUserName.getText().toString().isEmpty())
                    mForgotPassUserName.setError("Please fill out this filed");
                else {
                    alertDialog.dismiss();
                    callOtpActivity();
                }
            }
        });

        mCancelBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    private void callOtpActivity() {
        Intent aIntent = new Intent(this, OtpActivity.class);
        startActivity(aIntent);

    }
}
