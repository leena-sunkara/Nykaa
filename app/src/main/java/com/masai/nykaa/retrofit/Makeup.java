package com.masai.nykaa.retrofit;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.nykaa.R;
import com.masai.nykaa.home.SliderAdapter;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Makeup extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.banner_01, R.drawable.banner_02,
            R.drawable.banner_03};

    private TextView sort, filter;
    private RecyclerView recyclerView;
    private MakeupAdapter makeupAdapter;

    private List<ResponseModel> responseModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeup_category);

        sliderView = findViewById(R.id.imageSlider);
        setImageSlider();

        recyclerView = findViewById(R.id.productRecyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://makeup-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<ResponseModel>> call = apiService.getData();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                responseModelList = response.body();
                makeupAdapter.updateData(responseModelList);
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        makeupAdapter = new MakeupAdapter(responseModelList);
        recyclerView.setAdapter(makeupAdapter);
    }

    private void setImageSlider() {
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();
    }
}