package com.masai.nykaa.welcome;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class LoginViewPagerAdapter extends FragmentStatePagerAdapter {

    public LoginViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return LoginScreenFragmentOne.newInstances();
            case 1:
                return LoginScreenFragmentTwo.newInstances();
            case 2:
                return LoginScreenFragmentThree.newInstances();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
