package com.example.hammer_pasta;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hammer_pasta.adapter.BannerAdapter;
import com.example.hammer_pasta.adapter.VPAdapter;
import com.example.hammer_pasta.data.DishList;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Menu extends Fragment {

    RecyclerView bannerrecycler;
    BannerAdapter bannerAdapter;
    public static RecyclerView foodrecycler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);

    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        foodrecycler =(RecyclerView) view.findViewById(R.id.food_scroller);

        List<Integer> bannerListList = new ArrayList<>();

        bannerListList.add(R.drawable.ban);
        bannerListList.add(R.drawable.ban);
        bannerListList.add(R.drawable.ban);

        setBannerRecycler(bannerListList);

        try {
            DishList dishList = new DishList("Pasta", getContext());
            dishList.execute();
        } catch (IOException e) {
            System.out.print("хуй"+e);
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void setBannerRecycler(List<Integer> bannerListList){
        bannerrecycler = requireView().findViewById(R.id.banner_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        bannerrecycler.setLayoutManager(layoutManager);
        bannerAdapter = new BannerAdapter(getActivity(), bannerListList);
        bannerrecycler.setAdapter(bannerAdapter);
    }
}
