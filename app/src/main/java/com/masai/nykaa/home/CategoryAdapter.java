package com.masai.nykaa.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.nykaa.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryVH> {

    int[] categoryImages;
    Context context;
    OnCategoryClickListener listener;

    public CategoryAdapter(int[] categoryImages, Context context, OnCategoryClickListener listener) {
        this.categoryImages = categoryImages;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {
        holder.imageView.setImageResource(categoryImages[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategoryClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryImages.length;
    }

    public static class CategoryVH extends RecyclerView.ViewHolder {
        ImageView imageView;

        public CategoryVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categoryImageView);
        }
    }
}