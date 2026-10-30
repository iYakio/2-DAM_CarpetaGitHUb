package com.example.ejercicio4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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

        // 1.- Crear objetos y variables
        private Button botonIr;
        private EditText campoNombre, campoApellido;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // 2.- Asociar objetos Java a XML
            botonIr = findViewById(R.id.button_iniciar_sesion);
            campoNombre = findViewById(R.id.Txt_Nombre);
            campoApellido = findViewById(R.id.Txt_Apellido);
        }

        //3.Eventos, lógica
        botonIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = campoNombre.getText().toString();
                String apellido = campoApellido.getText().toString();

                // Intent para pasar de pantalla
                Intent abrirPantalla = new Intent(MainActivity.this, MainActivity2.class);

                // Método 1 de paso de datos: PUTEXTRA

                abrirPantalla.putExtra("nombre", nombre);
                abrirPantalla.putExtra("apellidos", apellido);


                // Método 2 de paso de datos: clase static
                /*
                Almacen.setNombre(nombre);
                Almacen.setApellido(apellido);

                // Método 3 de paso de datos: SharedPreferences (XML)
                SharedPreferences prefs = getSharedPreferences("Datos", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nombre", nombre);
                editor.putString("apellido", apellido);
                editor.apply();
                */

                // Tras pasar datos, lanzamos Activity
                startActivity(abrirPantalla);
            }
        });


    }
}