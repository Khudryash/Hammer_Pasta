package com.example.hammer_pasta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.hammer_pasta.adapter.VPAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        vpAdapter.addFragment(new Menu(), "Меню");
        vpAdapter.addFragment(new Profile(), "Профиль");
        vpAdapter.addFragment(new Bag(), "Корзина");
        viewPager.setAdapter(vpAdapter);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.food_ic);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.prof_ic);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.bag_ic);
    }
}
