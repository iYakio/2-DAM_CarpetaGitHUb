package com.example.proyecto_spotify_2dam_multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View tarjeta5 = findViewById(R.id.CardCancion5);
        ImageView img5 = tarjeta5.findViewById(R.id.imageWMU);
        TextView titulo5 = tarjeta5.findViewById(R.id.Cancion_1txt);
        TextView artista5 = tarjeta5.findViewById(R.id.Arista_1txt);

        img5.setImageResource(R.drawable.without_you);
        titulo5.setText("Without you");
        artista5.setText("Avicii ( 3:04 )");


        View tarjeta6 = findViewById(R.id.CardCancion6);
        ImageView img6 = tarjeta6.findViewById(R.id.imageWMU);
        TextView titulo6 = tarjeta6.findViewById(R.id.Cancion_1txt);
        TextView artista6 = tarjeta6.findViewById(R.id.Arista_1txt);

        img6.setImageResource(R.drawable.waiting_for_love);
        titulo6.setText("Waiting for Love");
        artista6.setText("Avicii ( 3:48 )");


        View tarjeta7 = findViewById(R.id.CardCancion7);
        ImageView img7 = tarjeta7.findViewById(R.id.imageWMU);
        TextView titulo7 = tarjeta7.findViewById(R.id.Cancion_1txt);
        TextView artista7 = tarjeta7.findViewById(R.id.Arista_1txt);

        img7.setImageResource(R.drawable.levels);
        titulo7.setText("Levels");
        artista7.setText("Avicii ( 3:20 )");


        View tarjeta8 = findViewById(R.id.CardCancion8);
        ImageView img8 = tarjeta8.findViewById(R.id.imageWMU);
        TextView titulo8 = tarjeta8.findViewById(R.id.Cancion_1txt);
        TextView artista8 = tarjeta8.findViewById(R.id.Arista_1txt);

        img8.setImageResource(R.drawable.addicted_to_you);
        titulo8.setText("Addicted to you");
        artista8.setText("Avicii ( 2:26 )");




    }
}