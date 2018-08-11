package com.jmsapplay.tabuadabasica;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity  {


    Button btnAdicao, btnSubtracao, btnMultiplicacao, btnDivisao, btnPersona;
    private InterstitialAd  interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        btnAdicao= findViewById(R.id.btnAdicao);
        btnSubtracao= findViewById(R.id.btnSubtracao);
        btnMultiplicacao= findViewById(R.id.btnMultiplicacao);
        btnDivisao= findViewById(R.id.btnDivisao);
        btnPersona = findViewById(R.id.btnPersona);

        MobileAds.initialize(this, "ca-app-pub-9275202133724780~8565107078");

        interstitialAd = new InterstitialAd(this);
        //ca-app-pub-3940256099942544/1033173712
        interstitialAd.setAdUnitId("ca-app-pub-9275202133724780/4038295437");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }


        });


        btnAdicao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




                interstitialAd.loadAd(new AdRequest.Builder().build());
                Intent proximaAct = new Intent( MainActivity.this, AdicaoActivityMain.class);
                startActivity(proximaAct);


            }
        });


        bannerADS();
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();
                interstitialAd.loadAd(new AdRequest.Builder().build());
                Intent proximaAct = new Intent( MainActivity.this, SubtracaoActivityMain.class);
                startActivity(proximaAct);
            }
        });

        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();
                interstitialAd.loadAd(new AdRequest.Builder().build());
                Intent proximaAct = new Intent( MainActivity.this, MultiplicacaoActivityMain.class);
                startActivity(proximaAct);

            }
        });

        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();
                interstitialAd.loadAd(new AdRequest.Builder().build());
                Intent proximaAct = new Intent( MainActivity.this, DivisaoActivityMain.class);
                startActivity(proximaAct);
            }
        });
        btnPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();
                interstitialAd.loadAd(new AdRequest.Builder().build());
                Intent proximaAct = new Intent( MainActivity.this, PersonaActivity.class);
                startActivity(proximaAct);
            }
        });
        showInterstitial();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSair:
                finish();
                Toast.makeText(this, "Obrigado por usar!", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnSobre:
                Toast.makeText(this, "Sobre", Toast.LENGTH_LONG).show();
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        bannerADS();
      //  interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public  void bannerADS(){
          AdView adView;
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {

            interstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }

}
