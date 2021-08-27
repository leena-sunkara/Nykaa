package com.masai.nykaa.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.masai.nykaa.R;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private ImageView home, shop, explore, account, cart, wishlist, bell;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        initViews();
        HomeFragment homeFragment = new HomeFragment();
        launchFragment(homeFragment, "HomeFragment");
    }

    private void initViews() {
        home = findViewById(R.id.home);
        shop = findViewById(R.id.shop);
        explore = findViewById(R.id.explore);
        account = findViewById(R.id.account);

        fragmentManager = getSupportFragmentManager();

        home.setOnClickListener(this);
        shop.setOnClickListener(this);
        explore.setOnClickListener(this);
        account.setOnClickListener(this);

        cart = findViewById(R.id.cart);
        wishlist = findViewById(R.id.wishlist);
        bell = findViewById(R.id.bell);

        cart.setOnClickListener(this);
        wishlist.setOnClickListener(this);
        bell.setOnClickListener(this);
    }

    private void launchFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment, tag).addToBackStack(tag).commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                HomeFragment homeFragment = new HomeFragment();
                launchFragment(homeFragment, "HomeFragment");
                break;
            case R.id.shop:
                ShopFragment shopFragment = new ShopFragment();
                launchFragment(shopFragment, "ShopFragment");
                break;
            case R.id.explore:
                ExploreFragment exploreFragment = new ExploreFragment();
                launchFragment(exploreFragment, "ExploreFragment");
                break;
            case R.id.account:
                AccountFragment accountFragment = new AccountFragment();
                launchFragment(accountFragment, "AccountFragment");
                break;

            case R.id.cart:
                Intent cartlistIntent = new Intent(getApplicationContext(), Cart.class);
                startActivity(cartlistIntent);
                break;

            case R.id.wishlist:
                Intent wishlistIntent = new Intent(getApplicationContext(), Wishlist.class);
                startActivity(wishlistIntent);
                break;

            case R.id.bell:
                Intent bellIntent = new Intent(getApplicationContext(), Bell.class);
                startActivity(bellIntent);
                break;
        }
    }
}