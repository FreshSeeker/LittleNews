package com.example.android.littlenews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.HashMap;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return ChannelConfig.channels.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ChannelConfig.channels[position];
    }
}
