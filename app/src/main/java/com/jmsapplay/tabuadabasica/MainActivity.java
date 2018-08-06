package com.jmsapplay.tabuadabasica;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {


    Button btnAdicao, btnSubtracao, btnMultiplicacao, btnDivisao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAdicao= findViewById(R.id.btnAdicao);
        btnSubtracao= findViewById(R.id.btnSubtracao);
        btnMultiplicacao= findViewById(R.id.btnMultiplicacao);
        btnDivisao= findViewById(R.id.btnDivisao);


        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaAct = new Intent( MainActivity.this, AdicaoActivity.class);
                startActivity(proximaAct);


            }
        });

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
}
