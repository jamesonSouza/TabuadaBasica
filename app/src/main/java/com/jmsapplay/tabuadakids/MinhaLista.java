package com.jmsapplay.tabuadakids;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MinhaLista extends BaseAdapter {

      String[] lista;
      Activity act;
    
    String pasta = "fonts/";
    String fontTTFChack= "Chack_Risco.ttf";

      public MinhaLista(List<String> lista, Activity act){
          this.lista = lista.toArray(new String[0]);
          this.act = act;

      }

    @Override
    public int getCount() {

        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view =
          act.getLayoutInflater().inflate(R.layout.simples_lista_texto, parent,false);

        Typeface typeface = Typeface.createFromAsset( act.getAssets(),pasta + fontTTFChack );


        TextView post = (TextView)view.findViewById(R.id.simples_lista);
        post.setTypeface(typeface);


        post.setText(lista[position]);

        return view;

    }
}
