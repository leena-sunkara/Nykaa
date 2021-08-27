package com.masai.nykaa.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.masai.nykaa.home.HomeScreen;
import com.masai.nykaa.R;

public class LoginEmailOtp extends AppCompatActivity {

    private TextView tvEmail, tvResend;
    private EditText etOtpOne, etOtpTwo, etOtpThree, etOtpFour, etOtpFive, etOtpSix;
    private Button btnVerify, btnOpenEmailApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_email_otp);

        tvEmail = findViewById(R.id.email);
        tvResend = findViewById(R.id.resend);
        etOtpOne = findViewById(R.id.otpOne);
        etOtpTwo = findViewById(R.id.otpTwo);
        etOtpThree = findViewById(R.id.otpThree);
        etOtpFour = findViewById(R.id.otpFour);
        etOtpFive = findViewById(R.id.otpFive);
        etOtpSix = findViewById(R.id.otpSix);
        btnVerify = findViewById(R.id.verify);
        btnOpenEmailApps = findViewById(R.id.openEmailApps);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginEmailOtp.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        btnOpenEmailApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open email options
            }
        });
    }
}