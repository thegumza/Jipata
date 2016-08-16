package com.jipata.thegumza.jipata.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jipata.thegumza.jipata.fragment.RubberFragment;
import com.jipata.thegumza.jipata.fragment.SmokeRubberFragment;

/**
 * Created by Thegumza on 8/15/2016.
 */
public class RubberPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"ยางแผ่นดิบ (USS)", "ยางแผ่นรมควัน (RSS)"};
    private Context context;

    public RubberPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RubberFragment.newInstance();
            case 1:
                return SmokeRubberFragment.newInstance();
            default: return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}