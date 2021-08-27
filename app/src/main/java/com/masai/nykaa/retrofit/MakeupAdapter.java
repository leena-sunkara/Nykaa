package com.masai.nykaa.retrofit;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masai.nykaa.R;

import java.util.List;

public class MakeupAdapter extends RecyclerView.Adapter<MakeupAdapter.MakeupVH> {

    private List<ResponseModel> responseModelList;

    public MakeupAdapter(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public MakeupVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new MakeupVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakeupVH holder, int position) {
        holder.setData(responseModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
        notifyDataSetChanged();
    }

    public static class MakeupVH extends RecyclerView.ViewHolder {

        ImageView mImage, mLike;
        TextView mTitle, mPrice, mRating, mAddToBag;

        public MakeupVH(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mLike = itemView.findViewById(R.id.like);
            mTitle = itemView.findViewById(R.id.title);
            mPrice = itemView.findViewById(R.id.price);
            mRating = itemView.findViewById(R.id.rating);
            mAddToBag = itemView.findViewById(R.id.addToBag);
        }

        @SuppressLint("SetTextI18n")
        public void setData(ResponseModel data) {
            Glide.with(itemView).load((data.getImageLink())).into(mImage);
            mTitle.setText(data.getName());
            double price = Double.parseDouble(data.getPrice());
            int cost = (int) Math.ceil(price * 70);
            mPrice.setText("₹" + cost);
            mRating.setText("Rating: " + data.getRating() + "");
        }
    }
}
