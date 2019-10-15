package com.seekerzhouk.android.littlenews.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.seekerzhouk.android.littlenews.fragment.GankFragment;
import com.seekerzhouk.android.littlenews.config.ChannelConfig;

public class GankPagerAdapter extends FragmentPagerAdapter {

    public GankPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return GankFragment.newInstance(position+1);

    }

    @Override
    public int getCount() {
        return ChannelConfig.ganks.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ChannelConfig.ganks[position];
    }


}
