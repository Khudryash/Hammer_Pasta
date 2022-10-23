package com.example.hammer_pasta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.hammer_pasta.adapter.BannerAdapter;
import com.example.hammer_pasta.adapter.VPAdapter;
import com.example.hammer_pasta.data.DishList;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Menu extends Fragment {

    public static RecyclerView foodrecycler;
    RecyclerView bannerrecycler;
    BannerAdapter bannerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);

    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<Integer> bannerListList = new ArrayList<>();
        bannerListList.add(R.drawable.ban);
        bannerListList.add(R.drawable.ban);
        bannerListList.add(R.drawable.ban);
        setBannerRecycler(bannerListList);
//        setContentView(R.layout.activity_main);

        TabLayout tabLayout = requireView().findViewById(R.id.tabLayout2);
        ViewPager viewPager = requireView().findViewById(R.id.viewPager2);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter2 = new VPAdapter(getChildFragmentManager());

        vpAdapter2.addFragment(new PastaMenu(), "Паста");
        vpAdapter2.addFragment(new ChickenMenu(), "Курица");
        viewPager.setAdapter(vpAdapter2);

        foodrecycler =(RecyclerView) view.findViewById(R.id.food_scroller);

    }

    private void setBannerRecycler(List<Integer> bannerListList){
        bannerrecycler = requireView().findViewById(R.id.banner_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        bannerrecycler.setLayoutManager(layoutManager);
        bannerAdapter = new BannerAdapter(getActivity(), bannerListList);
        bannerrecycler.setAdapter(bannerAdapter);
    }
}
