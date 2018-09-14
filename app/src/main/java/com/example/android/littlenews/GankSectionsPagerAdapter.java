package com.example.android.littlenews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.HashMap;

public class GankSectionsPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private FragmentManager fragmentManager;
//    private HashMap<String, GankFragment> gankList;
    private final int navigationItemNumber = 1;

    public GankSectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        this.fragmentManager = fm;
//        initFragments();
    }

//    private void initFragments() {
//        gankList = new HashMap<>();
//        for (int i = 0; i < ChannelConfig.ganks.length; i++) {
//            gankList.put(String.valueOf(i), GankFragment.newInstance(i));
//        }
//    }



    @Override
    public Fragment getItem(int position) {
        Log.i("SectionsPagerAdapter", "getItem: 获得了GankFragment");
        return GankFragment.newInstance(position+1);

    }

    @Override
    public int getCount() {
        Log.i("GankPagerAdapter", "getCount_1: "+fragmentManager.getFragments());
        return ChannelConfig.ganks.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("SectionsPagerAdapter", "getPageTitle: ");
        return ChannelConfig.ganks[position];
    }


}
