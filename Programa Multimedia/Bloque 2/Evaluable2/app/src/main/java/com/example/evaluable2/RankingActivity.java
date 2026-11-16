package com.example.evaluable2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ListView lvRanking = findViewById(R.id.listView_Ranking);
        ArrayList<String> datos = new BasedeDatos(this).obtenerRanking();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, datos) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView t = (TextView) super.getView(position, convertView, parent);
                t.setTextColor(getResources().getColor(R.color.Blanco_letras, getTheme()));
                return t;
            }
        };

        lvRanking.setAdapter(adapter);
    }
}