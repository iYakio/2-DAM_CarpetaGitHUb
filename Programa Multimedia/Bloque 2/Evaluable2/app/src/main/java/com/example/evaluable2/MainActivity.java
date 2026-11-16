package com.example.evaluable2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText textField_Nombre = findViewById(R.id.textField_Tu_Nombre);
        Button btnJugar = findViewById(R.id.btnJugar);
        Button btnVerRanking = findViewById(R.id.btnVerRanking);

        btnJugar.setOnClickListener(v -> {
            String nombre = textField_Nombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                textField_Nombre.setError("Debes de escribir un nombre");
                return;
            }
            Intent i = new Intent(this, JuegoActivity.class);
            i.putExtra("nombre", nombre);
            startActivity(i);
        });

        btnVerRanking.setOnClickListener(v ->
                startActivity(new Intent(this, RankingActivity.class)));
    }
}