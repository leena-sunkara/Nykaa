package com.masai.nykaa.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.masai.nykaa.R;
import com.masai.nykaa.home.HomeScreen;
import com.masai.nykaa.welcome.LoginScreen;

public class RegisterMobileTwo extends AppCompatActivity {

    private TextView tvMobileNumber;
    private EditText etFullName, etEmailAddress;
    private Button btnSave;
    private ImageView ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_mobile_two);

        ivClose = findViewById(R.id.close);
        tvMobileNumber = findViewById(R.id.mobileNumber);
        etFullName = findViewById(R.id.fullName);
        etEmailAddress = findViewById(R.id.email);
        btnSave = findViewById(R.id.save);

        String number = getIntent().getStringExtra("number");
        tvMobileNumber.setText(number);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}