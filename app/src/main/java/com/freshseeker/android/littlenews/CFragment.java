package com.freshseeker.android.littlenews;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RestPagerAdapter restPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_out, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);

        //TabLayout+ViewPager
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);
        restPagerAdapter = new RestPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(restPagerAdapter);
        viewPager.setOffscreenPageLimit(1);//预加载1个Tab
        //setTabMode
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        super.onViewCreated(view, savedInstanceState);
    }
}
