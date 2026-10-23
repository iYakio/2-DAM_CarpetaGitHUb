package com.example.ejercicio2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1.Crear objetos y variables

    private TextView textViewHelloWorld;
    private Button btnToast, btnMasTamano, btnMenosTamano, btnColorRandom, btnLog;
    private CheckBox checkbox;
    private ConstraintLayout fondo;

    @SuppressLint("MissingInflatedId")
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

        // 2.Asociar cada objeto de Java con su ID correspondiente
        textViewHelloWorld = findViewById(R.id.TextView_Modificado);
        btnMasTamano = findViewById(R.id.button_Mas_Tamano);
        btnMenosTamano = findViewById(R.id.button_Menos_Tamano);
        fondo = findViewById(R.id.main);
        checkbox = findViewById(R.id.checkBox);
        btnToast = findViewById(R.id.buttonToast);
        btnColorRandom = findViewById(R.id.button_ColorRandom);
        btnLog = findViewById(R.id.buttonToast);



        // 3. Eventos
        btnToast.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick (View v){
              Toast.makeText(MainActivity.this, "Hola!", Toast.LENGTH_SHORT).show();
              textViewHelloWorld.setText(("¡Toast mostrado!"));
          }
        });

        btnColorRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomColor = Color.rgb((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
                textViewHelloWorld.setTextColor(randomColor);
            }
        });

        btnMasTamano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHelloWorld.setTextSize(TypedValue.COMPLEX_UNIT_PX, textViewHelloWorld.getTextSize()+20);

            }
        });

        btnMenosTamano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewHelloWorld.setTextSize(TypedValue.COMPLEX_UNIT_PX, textViewHelloWorld.getTextSize()-20);

            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MiAppTag", "El usuario hizo clic en el botón LOG");
                textViewHelloWorld.setText("Logcat escrito");
            }
        });

        checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textViewHelloWorld.setText("CheckBox activado");
            } else {
                textViewHelloWorld.setText("Hello World!");
            }
        });

    }
}