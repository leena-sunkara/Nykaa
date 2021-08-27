package com.masai.nykaa.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.masai.nykaa.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterTwo extends
        SliderViewAdapter<SliderAdapterTwo.SliderAdapterVHTwo> {

    int[] images;

    public SliderAdapterTwo(int[] images) {
        this.images = images;
    }

    @Override
    public SliderAdapterTwo.SliderAdapterVHTwo onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_item, parent, false);
        return new SliderAdapterVHTwo(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapterTwo.SliderAdapterVHTwo viewHolder, final int position) {
        viewHolder.imageView.setImageResource(images[position]);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click action
            }
        });
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public static class SliderAdapterVHTwo extends SliderViewAdapter.ViewHolder {
        ImageView imageView;

        public SliderAdapterVHTwo(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}