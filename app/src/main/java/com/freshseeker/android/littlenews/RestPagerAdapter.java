package com.freshseeker.android.littlenews;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RestPagerAdapter extends FragmentPagerAdapter {

    RestPagerAdapter(FragmentManager fm) {
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
