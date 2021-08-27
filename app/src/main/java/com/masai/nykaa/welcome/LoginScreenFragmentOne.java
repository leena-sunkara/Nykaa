package com.masai.nykaa.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.masai.nykaa.R;

public class LoginScreenFragmentOne extends Fragment {

    public static LoginScreenFragmentOne newInstances() {
        LoginScreenFragmentOne loginScreenFragmentOne = new LoginScreenFragmentOne();
        return loginScreenFragmentOne;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_screen_fragment_one, container, false);
    }
}
