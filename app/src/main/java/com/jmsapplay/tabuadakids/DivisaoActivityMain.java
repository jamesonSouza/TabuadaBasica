package com.jmsapplay.tabuadakids;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class DivisaoActivityMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listaDeMenu, listaAdicao;
    Integer valor1, valor2, resultado;
    TextView txtValor1, txtValor2, txtResultado;
    EditText editAdicao;
    ListView listadicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicao_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        listadicao = findViewById(R.id.listaAdicao);
        LacoAdicao(12, 12);
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
        getMenuInflater().inflate(R.menu.adicao_activity_main, menu);
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


            finish();
            Intent  voltar = new Intent( this, MainActivity.class);
            startActivity(voltar);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        int find = 0;

        if (id == R.id.m00) {
            LacoAdicao(0, 0);

        } else if (id == R.id.m1) {
            LacoAdicao(1 ,1);

        } else if (id == R.id.m2) {
            LacoAdicao(2,2);

        } else if (id == R.id.m3) {
            LacoAdicao(3,3);
        } else if (id == R.id.m4) {
            LacoAdicao(4,4);

        } else if (id == R.id.m5) {
            LacoAdicao(5,5);

        } else if (id == R.id.m6) {
            LacoAdicao(6,6);

        } else if (id == R.id.m7) {
            LacoAdicao(7,7);

        } else if (id == R.id.m8) {
            LacoAdicao(8,8);

        } else if (id == R.id.m9) {
            LacoAdicao(9,9);

        } else if (id == R.id.m10) {
            LacoAdicao(10,10);

        }else if (id==R.id.mt){
            LacoAdicao(12,12);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void LacoAdicao(int _find, int _find1) {

        List<String> lista = new ArrayList<>();


        if (_find == 12 && _find1 ==12 ) {



            for(valor1 = 1 ;valor1 <=10;valor1++){

                lista.add("Tabuada do " + valor1);

                for(valor2 = 1; valor2<=10; valor2++){

                    lista.add(String.valueOf(valor1*valor2) + "   /   " +String.valueOf(valor1)+ "   =   " + String.valueOf(valor2));
                    ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), R.layout.simples_lista_texto, lista);
                    listadicao.setAdapter(adpter);


                }
            }

        } else {
            for (valor1 = _find1; valor1 <= _find; valor1++) {
                if(valor1==0){
                    valor1 ++;
                }
                lista.add("Tabuada do " + valor1);
                listadicao.setBackgroundColor(Color.rgb(247, 93, 93));

                    for(valor2 = 1; valor2<=10; valor2++){
                        lista.add(String.valueOf(valor1*valor2) + "   /   " +String.valueOf(valor1)+ "   =   " + String.valueOf(valor2));
                        ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), R.layout.simples_lista_texto, lista);
                        listadicao.setAdapter(adpter);


                    }
            }
        }
    }
    protected void onResume() {
        super.onResume();

        bannerADS();
    }
    public  void bannerADS(){
        AdView adView;
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
}
