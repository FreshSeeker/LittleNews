package com.example.android.littlenews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.HashMap;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private FragmentManager fragmentManager;
//    private HashMap<String, NewsFragment> newsList;
    private final int navigationItemNumber = 0;

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        this.fragmentManager = fm;
//        initFragments();
    }

//    private void initFragments() {
//        newsList = new HashMap<>();
//        for (int i = 0; i < ChannelConfig.channels.length; i++) {
//            newsList.put(String.valueOf(i), NewsFragment.newInstance(i));
//        }
//    }

    @Override
    public Fragment getItem(int position) {
//        Log.i("SectionsPagerAdapter", "getItem: 获得了NewsFragment"+position);

        return NewsFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
//        Log.i("SectionsPagerAdapter", "getCount_0: ");
        return ChannelConfig.channels.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        Log.d("SectionsPagerAdapter", "getPageTitle: ");
        return ChannelConfig.channels[position];
    }
}
