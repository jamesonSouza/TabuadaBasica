package com.jmsapplay.tabuadakids;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;

public class GameMainActivity extends AppCompatActivity {

    Button btnVerificar, btnVoltar ;

    TextView txtConta, txtFrase, txtScore, txtAcertoresposta, txtErros, txtPorcentagem;
    EditText editResponda;

    String pasta = "fonts/";
    String fontTTFChack= "Chack_Risco.ttf";

    Integer valor1, valor2, resultado, resposta;
    int erros, acertos;
    float porcentagem;
    private InterstitialAd  interstitialAd;

Random gerador = new Random();

    String[] fraseAcerto = new String[]{"Muito bem!","Nossa incrível!","Meus parabéns!","Continue assim!","Eita! Que impressionante"};
    String[] fraseErro = new String[]{"Não desista!","Vai conseguir na próxima!","Mais uma, vai!","Consegue sim, que isso!","Na próxima é acerto!"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MobileAds.initialize(this, "ca-app-pub-9275202133724780~8565107078");

        interstitialAd = new InterstitialAd(this);
        //ca-app-pub-3940256099942544/1033173712
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        txtConta = findViewById(R.id.txtQuestao);
        txtFrase = findViewById(R.id.txtFrase);
        txtScore = findViewById(R.id.txtEscore);
        txtAcertoresposta = findViewById(R.id.txtCorretaResposta);
        txtErros = findViewById(R.id.txtErros);
        txtPorcentagem = findViewById(R.id.txtPorcentagem);
        btnVoltar = findViewById(R.id.btnVoltar);

        editResponda= findViewById(R.id.editResposta);
        btnVerificar = findViewById(R.id.btnVerificar);

        Typeface typeface = Typeface.createFromAsset(getAssets(), pasta+fontTTFChack);

        txtAcertoresposta.setTypeface(typeface);
        txtPorcentagem.setTypeface(typeface);
        txtErros.setTypeface(typeface);
        txtConta.setTypeface(typeface);
        txtScore.setTypeface(typeface);
        txtFrase.setTypeface(typeface);
        btnVerificar.setTypeface(typeface);
        editResponda.setTypeface(typeface);

        List<String> textAcertoString= Arrays.asList(fraseAcerto);

        Collections.shuffle(textAcertoString);
        PlayGame();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameMainActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


String valorRandom = fraseAcerto[gerador.nextInt(fraseAcerto.length)];
String valorErroRandom = fraseErro[gerador.nextInt(fraseAcerto.length)];



              try {  //ADICIONA O VALOR DO CAMPO EDITRESPOSTA A VARIAVEL RESPOSTA
                  resposta = Integer.parseInt(editResponda.getText().toString());

                  if (editResponda.getText().length() < 0) {
                      Toast.makeText(getApplicationContext(),"Campo vazio!", Toast.LENGTH_SHORT).show();
                      editResponda.requestFocus();
                  } else if (resposta != resultado) {


                      txtFrase.setText(valorErroRandom);

                      editResponda.setText("");
                      editResponda.requestFocus();
                      Erros();

                  } else {

                      txtFrase.setText(valorRandom);
                      editResponda.setText("");
                      editResponda.requestFocus();
                      txtAcertoresposta.setText((String.valueOf(valor1) + " x " + String.valueOf(valor2) + " = ") + String.valueOf(resposta));

                      PlayGame();
                      Acerto();
                   //
                  }
                  Porcentagem();
              }catch (Exception e){

                  editResponda.requestFocus();
                  Log.i("Erro-->", String.valueOf(e));

              }

            }
        });

    }



    private void PlayGame(){
        valor1 = gerador.nextInt(10);
        valor2 = gerador.nextInt(10);
        resultado = valor1* valor2;

        txtConta.setText(String.valueOf(valor1)+ " x " + String.valueOf(valor2)+ " = ");

    }

    private void Acerto(){

        acertos++;
        txtScore.setText("Acertos: "+ acertos);
    }  private void Erros(){

        erros++;
        txtErros.setText("Erros: " + erros);
    }

    private void Porcentagem(){

        porcentagem = ((acertos- erros)/erros)*100;

        txtPorcentagem.setText(porcentagem + " %");


    }

    @Override
    protected void onResume() {
        super.onResume();
        bannerADS();
        showInterstitial();
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
