package com.masai.nykaa.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.FirebaseDatabase;
import com.masai.nykaa.R;
import com.masai.nykaa.login.LoginEmail;
import com.masai.nykaa.register.RegisterEmail;
import com.masai.nykaa.register.RegisterMobileOne;

public class LoginRegister extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    private ImageView ivClose;
    private EditText etNumberEmail;
    private Button btnProceed;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);

        etNumberEmail = findViewById(R.id.numberEmail);
        btnProceed = findViewById(R.id.proceed);

        ivClose = findViewById(R.id.close);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isEmailValid = isEmailValid();
                boolean isMobileNumberValid = isMobileNumberValid();
                String text = etNumberEmail.getText().toString();
                if (isEmailValid) {
                    isCheckEmail(text, new OnEmailCheckListener() {
                        @Override
                        public void onSuccess(boolean isRegistered) {

                            if (isRegistered) {
                                //The email was registered before
                                Intent login = new Intent(getApplicationContext(), LoginEmail.class);
                                login.putExtra("mail", text);
                                startActivity(login);
                            } else {
                                //The email not registered before
                                Intent register = new Intent(getApplicationContext(), RegisterEmail.class);
                                register.putExtra("mail", text);
                                startActivity(register);
                            }

                        }
                    });
                } else if (isMobileNumberValid) {
                    Intent register = new Intent(LoginRegister.this, RegisterMobileOne.class);
                    register.putExtra("number", text);
                    startActivity(register);
                }
            }
        });

    }

    private boolean isEmailValid() {
        return etNumberEmail.getText().toString().length() != 0 && etNumberEmail.getText().toString().matches(emailValidation);
    }

    private boolean isMobileNumberValid() {
        return etNumberEmail.getText().toString().length() != 0;
    }

    public void isCheckEmail(final String email, final OnEmailCheckListener listener) {
        firebaseAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                boolean check = !task.getResult().getSignInMethods().isEmpty();
                listener.onSuccess(check);
            }
        });

    }
}