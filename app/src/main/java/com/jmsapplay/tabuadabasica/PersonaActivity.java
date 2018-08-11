package com.jmsapplay.tabuadabasica;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Integer conversor;
    EditText editValor1, editValor2;
    ListView listPersona;
Button btnCusAd, btnCusSub, btnMult, btnDiv;
    Integer valor1 , valor2, resultado, pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listPersona = findViewById(R.id.listPersona);

        editValor1= findViewById(R.id.editValor1);
        editValor2= findViewById(R.id.editValor2);
        btnCusAd = findViewById(R.id.btnAdicao);
        btnCusSub = findViewById(R.id.btnSub);
        btnMult= findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });






        btnCusAd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                try {
                    valor1 = Integer.parseInt( editValor1.getText().toString());
                    valor2 = Integer.parseInt( editValor2.getText().toString());
                    if (editValor1.getText().toString().length() > 0 && editValor2.getText().toString().length() > 0) {
                        calcularTabuada(valor1, valor2);

                    } else {
                        editValor1.setError("!");
                        editValor1.requestFocus();
                        editValor2.setError("!");

                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Os campos devem ser preenchidos!",Toast.LENGTH_LONG).show();
                }





            }
        });

        btnCusSub.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                try {
                    valor1 = Integer.parseInt( editValor1.getText().toString());
                    valor2 = Integer.parseInt( editValor2.getText().toString());
                    if (editValor1.getText().toString().length() > 0 && editValor2.getText().toString().length() > 0) {
                        calcularTabuadaSub(valor1,valor2);

                    } else {
                        editValor1.setError("!");
                        editValor1.requestFocus();
                        editValor2.setError("!");

                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Os campos devem ser preenchidos!",Toast.LENGTH_LONG).show();
                }





            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                try {
                    valor1 = Integer.parseInt( editValor1.getText().toString());
                    valor2 = Integer.parseInt( editValor2.getText().toString());
                    if (editValor1.getText().toString().length() > 0 && editValor2.getText().toString().length() > 0) {
                        calcularTabuadaMult(valor1,valor2);

                    } else {
                        editValor1.setError("!");
                        editValor1.requestFocus();
                        editValor2.setError("!");

                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Os campos devem ser preenchidos!" ,Toast.LENGTH_LONG).show();
                }





            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                try {
                    valor1 = Integer.parseInt( editValor1.getText().toString());
                    valor2 = Integer.parseInt( editValor2.getText().toString());
                    if (editValor1.getText().toString().length() > 0 && editValor2.getText().toString().length() > 0) {
                        calcularTabuadaDiv(valor1,valor2);

                    } else {
                        editValor1.setError("!");
                        editValor1.requestFocus();
                        editValor2.setError("!");

                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Os campos devem ser preenchidos!" ,Toast.LENGTH_LONG).show();
                }





            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {






    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void calcularTabuada(int val1 , int val2){
        List<String> list = new ArrayList<>();



            for (valor1 = val1; valor1 <= val2; valor1++) {

                //  list.add("Tabuada do " + valor1);
                for (valor2 = val1; valor2 <= val2; valor2++) {

                    resultado = valor1 + valor2;

                    list.add(String.valueOf(valor1) + "  +  " + String.valueOf(valor2) + "  =  " + String.valueOf(resultado));
                    ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_selectable_list_item, list);
                    listPersona.setAdapter(adpter);
                }
            }





    }
    private void calcularTabuadaSub(int val1 , int val2){
        List<String> list = new ArrayList<>();



        for (valor1 = val1; valor1 <= val2; valor1++) {

            //  list.add("Tabuada do " + valor1);
            for (valor2 = val1; valor2 <= val2; valor2++) {


                list.add(String.valueOf(valor1 + valor2) + "  -  " + String.valueOf(valor1) + "  =  " + String.valueOf(valor2));
                // lista.add(String.valueOf(valor1) + " - " + String.valueOf(valor2) + " = " + String.valueOf(resultado));
                ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_selectable_list_item, list);
                listPersona.setAdapter(adpter);
            }
        }

}

    private void calcularTabuadaMult(int val1 , int val2){
        List<String> list = new ArrayList<>();



        for (valor1 = val1; valor1 <= val2; valor1++) {

            //  list.add("Tabuada do " + valor1);
            for (valor2 = val1; valor2 <= val2; valor2++) {



                resultado = valor1 * valor2;

                list.add(String.valueOf(valor1) + "  x  " + String.valueOf(valor2) + "  =  " + String.valueOf(resultado));
                ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_selectable_list_item, list);
                listPersona.setAdapter(adpter);
            }
        }

    }

    private void calcularTabuadaDiv(int val1 , int val2) {
        List<String> list = new ArrayList<>();


        for (valor1 = val1; valor1 <= val2; valor1++) {

            //  list.add("Tabuada do " + valor1);
            for (valor2 = val1; valor2 <= 10; valor2++) {


                for (valor2 = 1; valor2 <= 10; valor2++) {
                    list.add(String.valueOf(valor1 * valor2) + "   /   " + String.valueOf(valor1) + "   =   " + String.valueOf(valor2));
                    ArrayAdapter<String> adpter = new ArrayAdapter<String>(getApplicationContext(), R.layout.simples_lista_texto, list);
                    listPersona.setAdapter(adpter);
                }
            }

        }
    }


}
