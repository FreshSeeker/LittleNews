package com.freshseeker.android.littlenews.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freshseeker.android.littlenews.adapter.GankPagerAdapter;
import com.freshseeker.android.littlenews.R;

public class BFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private GankPagerAdapter gankPagerAdapter;

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
        gankPagerAdapter = new GankPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(gankPagerAdapter);
        viewPager.setOffscreenPageLimit(1);//预加载1个Tab
        //setTabMode
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        //取消切换时的过渡动画
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                // 默认切换的时候，会有一个过渡动画，设为false后，取消动画，直接显示
//                viewPager.setCurrentItem(tab.getPosition(), false);
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        super.onViewCreated(view, savedInstanceState);
    }
}
