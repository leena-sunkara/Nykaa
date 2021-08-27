package com.masai.nykaa.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.masai.nykaa.R;
import com.masai.nykaa.home.HomeScreen;
import com.masai.nykaa.welcome.LoginScreen;

public class RegisterEmail extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("users");

    private TextView tvEmail;
    private EditText etChoosePassword, etFullName, etMobileNumber;
    private Button btnRegister;
    private ImageView ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_email);
        initViews();
    }

    private void initViews() {
        tvEmail = findViewById(R.id.email);
        etChoosePassword = findViewById(R.id.choosePassword);
        etFullName = findViewById(R.id.fullName);
        etMobileNumber = findViewById(R.id.mobileNumber);
        btnRegister = findViewById(R.id.btnRegister);

        String email = getIntent().getStringExtra("mail");
        tvEmail.setText(email);

        ivClose = findViewById(R.id.close);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = tvEmail.getText().toString();
                String password = etChoosePassword.getText().toString();
                String name = etFullName.getText().toString();
                String number = etMobileNumber.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    User user = new User(email, password, name, number);
                                    databaseReference.child(firebaseAuth.getCurrentUser().getUid())
                                            .setValue(user)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            });
                                }
                            }
                        });
            }
        });
    }
}