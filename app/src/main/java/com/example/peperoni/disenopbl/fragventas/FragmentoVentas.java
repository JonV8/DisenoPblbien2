package com.example.peperoni.disenopbl.fragventas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peperoni.disenopbl.R;

/**
 * Created by dam2-jon on 31/10/2017.
 */

public class FragmentoVentas extends Fragment {


        private static final String TAG = "MainActivity";

        private SectionsPageAdapter mSectionsPageAdapter;

        private ViewPager mViewPager;



    public  FragmentoVentas(){

    }


    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getChildFragmentManager());
        adapter.addFragment(new TabJuegos(), "Juegos");
        adapter.addFragment(new TabConsolas(), "Consolas");
        adapter.addFragment(new TabSmartphones(), "Smartphones y Tablets");
        viewPager.setAdapter(adapter);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mivista=inflater.inflate(R.layout.activity_main_ventas,container,false);

        mSectionsPageAdapter = new SectionsPageAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) mivista.findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) mivista.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        return mivista;
    }
}


