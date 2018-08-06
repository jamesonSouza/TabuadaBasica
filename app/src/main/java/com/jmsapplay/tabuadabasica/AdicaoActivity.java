
package com.jmsapplay.tabuadabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AdicaoActivity extends AppCompatActivity {

    Integer valor1, valor2, resultado;
    TextView txtValor1, txtValor2, txtResultado;
    EditText editAdicao;
    ListView listadicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicao);

        txtValor1 = findViewById(R.id.txtValor1);
        txtValor2 = findViewById(R.id.txtValor2);
        txtResultado = findViewById(R.id.txtResultado);
        editAdicao = findViewById(R.id.editAdicao);
        listadicao = findViewById(R.id.listaAdicao);

        LacoAdicao();
    }

    private void LacoAdicao(){

        //valor1 = Integer.parseInt(txtValor1.getText().toString());
        //valor2 = Integer.parseInt(txtValor2.getText().toString());
       // resultado = Integer.parseInt(txtResultado.getText().toString());

        for (valor1 =1; valor1 <=10;valor1++ ){

            for (valor2 =1; valor2 <=10; valor2++){

                listadicao.setFilterText(String.valueOf(valor1+valor2));
               // editAdicao.setText(String.valueOf(valor1+valor2 ));

               /* txtValor1.setText(String.valueOf(valor1));
                txtValor2.setText(String.valueOf(valor2));
                txtResultado.setText(String.valueOf(valor1+valor2));*/


            }
        }



    }




}
