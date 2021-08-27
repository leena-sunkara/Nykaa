package com.masai.nykaa.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.masai.nykaa.R;
import com.masai.nykaa.home.HomeScreen;

public class LoginMobile extends AppCompatActivity {

    private TextView tvNumber, tvResend;
    private EditText etOtpOne, etOtpTwo, etOtpThree, etOtpFour, etOtpFive, etOtpSix;
    private Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_mobile);

        tvNumber = findViewById(R.id.number);
        String number = getIntent().getStringExtra("number");
        tvNumber.setText(number);

        etOtpOne = findViewById(R.id.otpOne);
        etOtpTwo = findViewById(R.id.otpTwo);
        etOtpThree = findViewById(R.id.otpThree);
        etOtpFour = findViewById(R.id.otpFour);
        etOtpFive = findViewById(R.id.otpFive);
        etOtpSix = findViewById(R.id.otpSix);

        btnVerify.findViewById(R.id.verify);
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}