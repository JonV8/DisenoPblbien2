package com.example.peperoni.disenopbl.fragventas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.peperoni.disenopbl.R;

/**
 * Created by dam2-jon on 30/10/2017.
 */

public class TabConsolas extends Fragment {
        private static final String TAG = "TabConsolas";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabconsolas_fragment,container,false);

        return view;
    }
}
