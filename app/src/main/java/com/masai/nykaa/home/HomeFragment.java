package com.masai.nykaa.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.nykaa.retrofit.Makeup;
import com.masai.nykaa.R;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment implements OnCategoryClickListener {

    SliderView sliderView;
    int[] images = {R.drawable.slider_image_one, R.drawable.slider_image_two,
            R.drawable.slider_image_three, R.drawable.slider_image_four,
            R.drawable.slider_image_five, R.drawable.slider_image_six};

    RecyclerView categoryRecyclerView;
    Context context;
    int[] categoryImages = {R.drawable.category_makeup, R.drawable.category_skin,
            R.drawable.category_fragrances, R.drawable.category_health,
            R.drawable.category_natural, R.drawable.category_haircare,
            R.drawable.category_mombaby,
            R.drawable.category_personalcare, R.drawable.category_luxe,
            R.drawable.category_globalstore};
    CategoryAdapter categoryAdapter;

    public HomeFragment() {
        //default constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sliderView = view.findViewById(R.id.imageSlider);
        setImageSlider();

        categoryRecyclerView = view.findViewById(R.id.categoryRecyclerView);
        setCategoryRecyclerView();
    }

    private void setImageSlider() {
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();
    }

    private void setCategoryRecyclerView() {
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(horizontalLayoutManager);
        categoryAdapter = new CategoryAdapter(categoryImages, context, this);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    @Override
    public void onCategoryClick(int position) {
        Intent intent = new Intent(this.getContext(), Makeup.class);
        startActivity(intent);
    }
}