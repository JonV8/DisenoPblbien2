package com.example.peperoni.disenopbl.fragment.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.peperoni.disenopbl.BuildConfig;

import com.example.peperoni.disenopbl.R;
import com.example.peperoni.disenopbl.fragment.FragmentServicios;

/**
 * @author msahakyan
 */

public class FragmentNavigationManager implements NavigationManager {

    private static FragmentNavigationManager sInstance;

    private FragmentManager mFragmentManager;


    public static FragmentNavigationManager obtain(Context activity) {
        if (sInstance == null) {
            sInstance = new FragmentNavigationManager();
        }
        //sInstance.configure((ExpandibleMenu) activity);
        return sInstance;
    }



    @Override
    public void showFragmentServicio(String title) {
        showFragment(FragmentServicios.newInstance(title), false);
    }

    private void showFragment(Fragment fragment, boolean allowStateLoss) {
        FragmentManager fm = mFragmentManager;

        @SuppressLint("CommitTransaction")
        FragmentTransaction ft = fm.beginTransaction()
                .replace(R.id.container, fragment);

        ft.addToBackStack(null);

        if (allowStateLoss || !BuildConfig.DEBUG) {
            ft.commitAllowingStateLoss();
        } else {
            ft.commit();
        }

        fm.executePendingTransactions();
    }
}
