package com.example.evaluable2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class JuegoActivity extends AppCompatActivity {
    private final String[] preguntas = {
            "¿Cuál es considerado por gran parte de la crítica y los jugadores como el mejor remake de un videojuego hasta la fecha",
            "¿Cuál es considerado actualmente por la comunidad como el jefe (BOSS) más difícil de toda la historia de FromSoftware?",
            "¿Qué legendaria compañía japonesa de videojuegos colaboró con Disney en 2002 para crear Kingdom Hearts?",
            "¿Cuál es el videojuego que más copias ha vendido en toda la historia?",
            "¿Cuál de estos cuatro titanes es considerado el mejor personaje y más influyente de todos los tiempos?"
    };

    private final String[][] respuestas = {
            {"A) Final Fantasy VII Remake", "B) Resident Evil 2 Remake", "C) Demon's Souls (PS5)", "D) Silent Hill 2 Remake"},
            {"A) Malenia, la Espada de Miquella (Elden Ring)", "B) Consorte Prometido Radahn (Elden Ring: Shadow of the Erdtree)", "C) Isshin, el Santo de la Espada (Sekiro: Shadows Die Twice)", "D) Huérfano de Kos (Bloodborne)"},
            {"A) Capcom", "B) Nintendo", "C) Square Enix", "D) Bandai Namco"},
            {"A) Grand Theft Auto V", "B) Tetris", "C) Minecraft", "D) Wii Sports"},
            {"A) Mario", "B) Link", "C) Sonic the Hedgehog", "D) Pac-Man"}
    };

    // Índice (0 a 3) de la respuesta correcta de cada pregunta
    private final int[] correctas = {1, 1, 2, 2, 0};

    // Un GIF distinto para cada pregunta
    private final int[] gifs = {
            R.raw.resident_evil_2,
            R.raw.promised_radahn,
            R.raw.sora,
            R.raw.pelea_gatos,
            R.raw.mario_flipando
    };

    private int actual = 0;
    private int puntos = 0;
    private final int PUNTOS_POR_ACIERTO = 10 / preguntas.length; // 2 con 5 preguntas
    private String nombre;

    private TextView txtProgreso, txtPuntos, txtPregunta;
    private ProgressBar progressBar;
    private ImageView ivGif;
    private final Button[] botones = new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        nombre = getIntent().getStringExtra("nombre");

        txtProgreso = findViewById(R.id.txtProgreso);
        txtPuntos = findViewById(R.id.txtPuntos);
        txtPregunta = findViewById(R.id.txtPregunta);
        progressBar = findViewById(R.id.progressBar);

        botones[0] = findViewById(R.id.btnRespuesta1);
        botones[1] = findViewById(R.id.btnRespuesta2);
        botones[2] = findViewById(R.id.btnRespuesta3);
        botones[3] = findViewById(R.id.btnRespuesta4);

        progressBar.setMax(preguntas.length);

        for (int i = 0; i < 4; i++) {
            final int indice = i;
            botones[i].setOnClickListener(v -> responder(indice));
        }

        mostrarPregunta();
    }

    private void mostrarPregunta() {
        txtProgreso.setText("Pregunta " + (actual + 1) + " de " + preguntas.length);
        txtPuntos.setText("Puntos: " + puntos);
        progressBar.setProgress(actual + 1);
        txtPregunta.setText(preguntas[actual]);
        for (int i = 0; i < 4; i++) {
            botones[i].setText(respuestas[actual][i]);
            botones[i].setEnabled(true);
        }
    }

    private void responder(int elegida) {
        for (Button b : botones) b.setEnabled(false); // evita doble pulsación

        if (elegida == correctas[actual]) {
            puntos += PUNTOS_POR_ACIERTO;
            txtPuntos.setText("Puntos: " + puntos);

            // Diálogo flotante en mitad de la pantalla con el GIF
            Dialog dialogo = new Dialog(this);
            dialogo.setContentView(R.layout.dialog_gif);
            dialogo.setCancelable(false); // no se cierra al tocar fuera ni con atrás
            if (dialogo.getWindow() != null) {
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            ImageView ivDialogo = dialogo.findViewById(R.id.ivGifDialogo);
            Glide.with(this).asGif().load(gifs[actual]).into(ivDialogo);
            dialogo.show();

            // A los 10 segundos se cierra el diálogo y se pasa a la siguiente pregunta
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (dialogo.isShowing()) dialogo.dismiss();
                siguiente();
            }, 10000);
        } else {
            siguiente();
        }
    }

    private void siguiente() {
        actual++;
        if (actual < preguntas.length) {
            mostrarPregunta();
        } else {
            Intent i = new Intent(this, ResultadoActivity.class);
            i.putExtra("nombre", nombre);
            i.putExtra("puntos", puntos);
            startActivity(i);
            finish(); // no se puede volver a la partida
        }
    }

    }
