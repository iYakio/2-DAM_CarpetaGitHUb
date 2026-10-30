package com.example.ejercicio3tlfemailurl;

import android.content.Intent;
import android.net.Uri;
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
    private Button boton_Mail;
    private Button boton_Tlf;
    private Button boton_Url;
    private EditText textoTelefono;
    private EditText textoMail;
    private EditText textoUrl;
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

        boton_Tlf = findViewById(R.id.button_Tlf);
        boton_Mail = findViewById(R.id.button_Mail);
        boton_Url = findViewById(R.id.button_Url);

        textoTelefono = findViewById(R.id.TextPhone);
        textoMail = findViewById(R.id.TextEmail);
        textoUrl = findViewById(R.id.TextoUrl);

        // Botón Teléfono (ACTION_DIAL)
        boton_Tlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tlfIntent = new Intent(Intent.ACTION_DIAL);
                tlfIntent.setData(Uri.parse("tel: " + textoTelefono.getText()));
                startActivity(tlfIntent);
           }
        });

        boton_Url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlIntent = new Intent(Intent.ACTION_VIEW);
                urlIntent.setData(Uri.parse(textoUrl.getText().toString()));
                startActivity(urlIntent);
            }
        });

        boton_Mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
                mailIntent.setData(Uri.parse("mailto: " +  textoMail.getText()));
                startActivity(mailIntent);
            }
        });

    }
}