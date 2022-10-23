package com.example.hammer_pasta;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hammer_pasta.data.DishList;

import java.io.IOException;

public class ChickenMenu extends Fragment {
    public static RecyclerView foodrecycler2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chicken_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodrecycler2 =(RecyclerView) view.findViewById(R.id.food_scroller2);
        try {
            DishList dishList = new DishList("Chicken", getContext(), foodrecycler2);
            dishList.execute();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}