package com.example.hammer_pasta.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hammer_pasta.R;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    Context context;
    List<Integer> bannerList;

    public BannerAdapter(Context context, List<Integer> bannerList) {
        this.context = context;
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.banner_row_item, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {

        holder.bannerImage.setImageResource(bannerList.get(position));

    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public static final class BannerViewHolder extends RecyclerView.ViewHolder{

        ImageView bannerImage;


        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);

            bannerImage = itemView.findViewById(R.id.banner_image);

        }
    }

}
