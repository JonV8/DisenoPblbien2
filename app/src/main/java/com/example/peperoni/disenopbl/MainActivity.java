package com.example.peperoni.disenopbl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.peperoni.disenopbl.fragapp.FragGaleria;
import com.example.peperoni.disenopbl.fragapp.FragLogin;
import com.example.peperoni.disenopbl.fragapp.FragNosotros;
import com.example.peperoni.disenopbl.fragapp.FragUbicacion;
import com.example.peperoni.disenopbl.fragreparaciones.FragmentoReparaciones;
import com.example.peperoni.disenopbl.fragventas.FragmentoVentas;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Bundle b = new Bundle();

        int id = item.getItemId();




        if (id == R.id.nav_gallery) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new FragGaleria()).commit();
        } else if (id == R.id.nav_nosotros) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, FragNosotros.newInstance(b)).commit();
        } else if (id == R.id.nav_gps) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new MapsActivity()).commit();
        } else if (id == R.id.nav_ventas) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new FragmentoVentas()).commit();
        }else if(id == R.id.nav_registrar){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new FragLogin()).commit();
        }else if (id == R.id.nav_repair) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new FragmentoReparaciones()).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
