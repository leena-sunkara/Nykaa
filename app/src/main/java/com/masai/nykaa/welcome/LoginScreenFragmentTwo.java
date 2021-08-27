package com.masai.nykaa.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.masai.nykaa.R;

public class LoginScreenFragmentTwo extends Fragment {

    public static LoginScreenFragmentTwo newInstances() {
        LoginScreenFragmentTwo loginScreenFragmentTwo = new LoginScreenFragmentTwo();
        return loginScreenFragmentTwo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_screen_fragment_two, container, false);
    }
}