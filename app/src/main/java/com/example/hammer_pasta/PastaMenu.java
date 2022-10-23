package com.example.hammer_pasta;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hammer_pasta.adapter.BannerAdapter;
import com.example.hammer_pasta.data.DishList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PastaMenu extends Fragment {


    public static RecyclerView foodrecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pasta_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodrecycler =(RecyclerView) view.findViewById(R.id.food_scroller);
        try {
            DishList dishList = new DishList("Pasta", getContext(), foodrecycler);
            dishList.execute();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }






}