package com.example.peperoni.disenopbl;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peperoni.disenopbl.Alquiler.FragAlquiler;
import com.example.peperoni.disenopbl.adapter.CustomExpandableListAdapter;
import com.example.peperoni.disenopbl.datasource.ExpandableListDataSource;
import com.example.peperoni.disenopbl.fragapp.FragCatalogo;
import com.example.peperoni.disenopbl.fragapp.FragGaleria;
import com.example.peperoni.disenopbl.fragapp.FragLogin;
import com.example.peperoni.disenopbl.fragapp.FragNosotros;
import com.example.peperoni.disenopbl.fragapp.FragUbicacion;
import com.example.peperoni.disenopbl.fragment.navigation.FragmentNavigationManager;
import com.example.peperoni.disenopbl.fragment.navigation.NavigationManager;
import com.example.peperoni.disenopbl.fragreparaciones.FragmentoReparaciones;
import com.example.peperoni.disenopbl.fragventas.FragmentoVentas;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, PasarDatos {

    private Button ubicacion;
    public  TextView nUsu;
    private String usu;
    private Boolean visible = true;
    private Group grupo;


    private String mActivityTitle;
    private String[] items;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private View vistaCabecera;
    NavigationView navigationView;

    private ExpandableListView mExpandableListView;
    private ExpandableListAdapter mExpandableListAdapter;
    private List<String> mExpandableListTitle;
    private NavigationManager mNavigationManager;

    private Map<String, List<String>> mExpandableListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        /*aqui el expandible*/
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        mNavigationManager = FragmentNavigationManager.obtain(this);

        initItems();

        /*LayoutInflater inflater = getLayoutInflater();
        View listHeaderView = inflater.inflate(R.layout.nav_header_main, null, false);
        mExpandableListView.addHeaderView(listHeaderView);*/

        mExpandableListData = ExpandableListDataSource.getData(this);
        mExpandableListTitle = new ArrayList(mExpandableListData.keySet());

        addDrawerItems();

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int id, long idss) {
                if (id == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new FragmentoVentas()).commit();
                }else if (id ==1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new FragmentoReparaciones()).commit();
                } else if(id == 2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new FragAlquiler()).commit();
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        vistaCabecera = navigationView.getHeaderView(0);
        nUsu= vistaCabecera.findViewById(R.id.usesion);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new FragCatalogo()).commit();
        mExpandableListView.setVisibility(View.INVISIBLE);

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
        }else if(id == R.id.nav_registrar){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new FragLogin()).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void nombreUsuario(String nombre) {
        nUsu.setText(nombre);
        mostrarMenus();
    }

    private void mostrarMenus() {
        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //grupo= (Group) findViewById(R.id.grupo);
        mExpandableListView.setVisibility(View.VISIBLE);
        // navigationView.getMenu().setGroupVisible(R.id.grupo, true);

    }

    private void selectFirstItemAsDefault() {
        if (mNavigationManager != null) {
            String firstActionMovie = getResources().getStringArray(R.array.services)[0];
            mNavigationManager.showFragmentServicio(firstActionMovie);
            getSupportActionBar().setTitle(firstActionMovie);
        }
    }

    private void initItems() {
        items = getResources().getStringArray(R.array.desplegables);
    }

    private void addDrawerItems() {
        mExpandableListAdapter = new CustomExpandableListAdapter(this, mExpandableListTitle, mExpandableListData);
        mExpandableListView.setAdapter(mExpandableListAdapter);

        mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                getSupportActionBar().setTitle(mExpandableListTitle.get(groupPosition).toString());
            }
        });

        mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                getSupportActionBar().setTitle(R.string.desplegable);
            }
        });


      /*  mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                    Toast.makeText(getApplicationContext(),""+groupPosition,Toast.LENGTH_LONG);


                return false;
            }
        });*/
    }




}
