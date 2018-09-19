package com.example.android.littlenews;

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

public class AFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewsPagerAdapter newsPagerAdapter;

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
        newsPagerAdapter = new NewsPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(newsPagerAdapter);
        viewPager.setOffscreenPageLimit(1);//预加载1个Tab
        tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.tab_selected));//设置文字默认背景色和选中的背景色
        tabLayout.setupWithViewPager(viewPager);
        //取消切换时的过渡动画
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 默认切换的时候，会有一个过渡动画，设为false后，取消动画，直接显示
                viewPager.setCurrentItem(tab.getPosition(), false);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
