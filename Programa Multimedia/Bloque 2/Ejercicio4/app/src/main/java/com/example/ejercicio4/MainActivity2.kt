package com.example.ejercicio4

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Declaración de vistas locales en Kotlin
        val botonVolver: Button = findViewById(R.id.button_volver)
        val textoNombre: TextView = findViewById(R.id.Txt_Nombre2)
        val textoApellido: TextView = findViewById(R.id.Txt_Apellido2)

        // Opción A: Recoger datos si los pasaste por Intent (putExtra)
        val nombreIntent = intent.getStringExtra("nombre")
        val apellidoIntent = intent.getStringExtra("apellidos")

        textoNombre.text = nombreIntent
        textoApellido.text = apellidoIntent

        /*
        // Opción B: Si decidiste usar SharedPreferences
        val prefs: SharedPreferences = getSharedPreferences("Datos", MODE_PRIVATE)
        textoNombre.text = prefs.getString("nombre", "")
        textoApellido.text = prefs.getString("apellido", "")
        */

        // Ejemplo de acción para el botón volver
        botonVolver.setOnClickListener {
            finish() // Cierra esta actividad y regresa a la anterior
        }
    }
}