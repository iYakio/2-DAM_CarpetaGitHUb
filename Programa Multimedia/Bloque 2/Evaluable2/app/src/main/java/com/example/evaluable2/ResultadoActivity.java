package com.example.evaluable2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String nombre = getIntent().getStringExtra("nombre");
        int puntos = getIntent().getIntExtra("puntos", 0);

        TextView txtNombre = findViewById(R.id.txtNombre);
        TextView txtPuntuacion = findViewById(R.id.txtPuntuacion);

        txtNombre.setText("Partida de " + nombre);
        txtPuntuacion.setText(puntos + " / 10");

        // Se guarda al abrirse, sin pulsar nada

        try {
            new BasedeDatos(this).guardarPartida(nombre, puntos);
        } catch (Exception e) {
            System.out.println("Error con la base de datos");
        }

        // Sonido de fin de partida
        MediaPlayer mp = MediaPlayer.create(this, R.raw.final_de_partida);
        mp.setOnCompletionListener(MediaPlayer::release);
        mp.start();

        findViewById(R.id.btnVerRanking_Resultado).setOnClickListener(v ->
                startActivity(new Intent(this, RankingActivity.class)));

        findViewById(R.id.btnVolverInicio).setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        });
    }


    }
