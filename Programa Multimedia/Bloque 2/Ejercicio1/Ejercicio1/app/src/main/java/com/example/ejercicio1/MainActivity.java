package com.example.ejercicio1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private TextView contadorTextView;
    private Button botonContar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // 1. PRIMERO: Cargar el diseño XML obligatoriamente
        setContentView(R.layout.activity_main);

        // 2. SEGUNDO: Aplicar los insets a la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 3. TERCERO: Asociar los objetos de Java con los IDs correctos del XML
        contadorTextView = findViewById(R.id.Numerotxt);
        botonContar = findViewById(R.id.button_cambia_numero);

        // 4. CUARTO: Programar la lógica del botón para incrementar el contador
        botonContar.setOnClickListener(v -> {
            contador++;
            contadorTextView.setText(Integer.toString(contador));
        });
    }
}