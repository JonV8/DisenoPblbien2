package com.example.peperoni.disenopbl.fragment;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.peperoni.disenopbl.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentServicios#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentServicios extends Fragment {

    private static final String nombreServicio = "nom_servicio";

    public FragmentServicios() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment FragmentServicios.
     */
    public static FragmentServicios newInstance(String movieTitle) {
        FragmentServicios fragmentServicios = new FragmentServicios();
        Bundle args = new Bundle();
        args.putString(nombreServicio, movieTitle);
        fragmentServicios.setArguments(args);

        return fragmentServicios;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servicios, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String nombreSer = getArguments().getString(nombreServicio);
        ((TextView) view.findViewById(R.id.nombreser)).setText(nombreSer);
    }
}
