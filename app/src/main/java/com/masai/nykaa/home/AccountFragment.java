package com.masai.nykaa.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.masai.nykaa.R;
import com.masai.nykaa.welcome.LoginScreen;

public class AccountFragment extends Fragment implements View.OnClickListener {

    public AccountFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.account_fragment, container, false);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getContext(), LoginScreen.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

    }
}