package com.example.peperoni.disenopbl.fragapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.peperoni.disenopbl.MainActivity;
import com.example.peperoni.disenopbl.PasarDatos;
import com.example.peperoni.disenopbl.R;
import com.example.peperoni.disenopbl.fragventas.FragmentoVentas;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kristian on 30/10/2017.
 */

public class FragLogin extends Fragment {
    private Button btnAcceder, btnRegistrar;
    private TextView txtUsuario, txtPassword;
    private String usuario;
    private RequestQueue colaPeticiones;
    private StringRequest strPeticion;
    private PasarDatos interfaz;

    public FragLogin() {
        super();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View miVista = inflater.inflate(R.layout.fragmentologin, container, false);
        asociarControles(miVista);
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar(miVista);
            }
        });
        return miVista;
    }


    private void asociarControles(View miVista) {
        btnAcceder = (Button) miVista.findViewById(R.id.btnAcceder);
        btnRegistrar = (Button) miVista.findViewById(R.id.btnRegistrar);
        txtUsuario = (TextView) miVista.findViewById(R.id.txtUsuario);
        txtPassword = (TextView) miVista.findViewById(R.id.txtPassword);
        interfaz = (PasarDatos) getContext();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void entrar(final View miVista) {
        String url = "http://192.168.6.188/wsPBL/logueo.php";
        colaPeticiones = Volley.newRequestQueue(miVista.getContext());
        strPeticion=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equalsIgnoreCase("true")) {
                            usuario= txtUsuario.getText().toString().toLowerCase();
                            Toast.makeText(miVista.getContext(), "Acceso CORRECTO", Toast.LENGTH_SHORT).show();

                            interfaz.nombreUsuario(usuario);

                            pasarFragmento();
                        }else {
                            Toast.makeText(miVista.getContext(), "Acceso INCORRECTO",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(miVista.getContext(), "Error en el acceso al servicio...",
                                Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("usuario", txtUsuario.getText().toString().toLowerCase());
                params.put("password", txtPassword.getText().toString());
                return params;
            }
        }
        ;
        colaPeticiones.add(strPeticion);
    }

    private void pasarFragmento() {

        Fragment Fragcatalogo = new FragCatalogo();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor, new FragmentoVentas());
        transaction.addToBackStack(null);
        transaction.commit();
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
