package com.freshseeker.android.littlenews.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.freshseeker.android.littlenews.fragment.NewsFragment;
import com.freshseeker.android.littlenews.config.ChannelConfig;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    public NewsPagerAdapter(FragmentManager fm) {
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
