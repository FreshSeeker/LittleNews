package com.freshseeker.android.littlenews.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.freshseeker.android.littlenews.fragment.RestFragment;
import com.freshseeker.android.littlenews.config.ChannelConfig;

public class RestPagerAdapter extends FragmentPagerAdapter {

    public RestPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return RestFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return ChannelConfig.rest.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ChannelConfig.rest[position];
    }
}
