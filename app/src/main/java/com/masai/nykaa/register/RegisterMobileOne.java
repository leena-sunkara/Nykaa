package com.masai.nykaa.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.masai.nykaa.R;
import com.masai.nykaa.welcome.LoginScreen;

import java.util.concurrent.TimeUnit;

public class RegisterMobileOne extends AppCompatActivity {

    private TextView tvMobileNumber, tvOtpSent, tvResend;
    private Button btnSendOtp, btnVerify;
    private EditText etOtp;
    //private EditText etOtpOne, etOtpTwo, etOtpThree, etOtpFour, etOtpFive, etOtpSix;
    private ImageView ivClose;

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    PhoneAuthProvider.ForceResendingToken token;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_mobile_one);

        tvMobileNumber = findViewById(R.id.mobileNumber);
        tvResend = findViewById(R.id.resend);
        btnVerify = findViewById(R.id.verify);

        String number = getIntent().getStringExtra("number");
        tvMobileNumber.setText(number);

        etOtp = findViewById(R.id.otp);
        /*etOtpOne = findViewById(R.id.otpOne);
        etOtpTwo = findViewById(R.id.otpTwo);
        etOtpThree = findViewById(R.id.otpThree);
        etOtpFour = findViewById(R.id.otpFour);
        etOtpFive = findViewById(R.id.otpFive);
        etOtpSix = findViewById(R.id.otpSix);*/

        ivClose = findViewById(R.id.close);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
            }
        });

        btnSendOtp = findViewById(R.id.sendOtp);
        btnSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyPhoneNumber(number);
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp = etOtp.getText().toString();
                if (otp.isEmpty()) {
                    etOtp.setError("Enter a valid OTP");
                    return;
                }
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, otp);
                authenticateUser(credential);
            }
        });

        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                authenticateUser(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(RegisterMobileOne.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationId = s;
                token = forceResendingToken;
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);

            }
        };
    }

    public void verifyPhoneNumber(String number) {
        // Send OTP
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setActivity(this)
                .setPhoneNumber(number)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setCallbacks(callbacks)
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    public void authenticateUser(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(getApplicationContext(), RegisterMobileTwo.class);
                intent.putExtra("number", tvMobileNumber.getText().toString());
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterMobileOne.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}