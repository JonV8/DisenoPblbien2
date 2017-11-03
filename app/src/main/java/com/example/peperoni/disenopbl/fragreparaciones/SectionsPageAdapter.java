package com.example.peperoni.disenopbl.fragreparaciones;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dam2-jon on 30/10/2017.
 */

public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment>mFragmenList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public void addFragment(Fragment fragment, String title){
        mFragmenList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmenList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmenList.size();
    }
}
