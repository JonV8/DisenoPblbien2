package com.example.peperoni.disenopbl.fragreparaciones;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peperoni.disenopbl.R;

public class FragmentoReparaciones extends Fragment {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    public FragmentoReparaciones() {

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter((getChildFragmentManager()));
        adapter.addFragment(new TabConsolas(), "Consolas");
        adapter.addFragment(new TabSmartphones(), "Smartphones y Tablets");
        viewPager.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mivista=inflater.inflate(R.layout.activity_main_reparaciones,container,false);

        mSectionsPageAdapter = new SectionsPageAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) mivista.findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) mivista.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        return mivista;
    }
}
