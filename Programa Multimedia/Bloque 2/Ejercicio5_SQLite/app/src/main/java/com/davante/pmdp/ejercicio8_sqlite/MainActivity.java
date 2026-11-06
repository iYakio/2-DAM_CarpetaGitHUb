package com.davante.pmdp.ejercicio8_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private Button botonGuardar;
    private Button botonComprobar;
    private Button botonCancelar;
    private TextView resultado;
    private ListView lista;

    private DatabaseHelper dbHelper; //Instancia de la bbdd

    // La lista que pinta el ListView. El adaptador guarda una referencia a ESTA lista:
    // si se cambia su contenido, hay que avisarle con notifyDataSetChanged()
    private final List<Profesor> profesores = new ArrayList<>();
    private ArrayAdapter<Profesor> adaptador;

    // -1 = estamos dando de alta; otro valor = id del profesor que se está editando
    private int idSeleccionado = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editTextNombre);
        apellido = findViewById(R.id.editTextApellido);
        botonGuardar = findViewById(R.id.buttonGuardar);
        botonComprobar = findViewById(R.id.buttonComprobar);
        botonCancelar = findViewById(R.id.buttonCancelar);
        resultado = findViewById(R.id.textViewResultado);
        lista = findViewById(R.id.listViewProfesores);

        // Inicializar el helper de base de datos
        dbHelper = new DatabaseHelper(this);

        // Adaptador: une la lista de objetos con el ListView.
        // simple_list_item_1 es un layout de fila que ya trae Android (un solo TextView)
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, profesores);
        lista.setAdapter(adaptador);
        cargarLista();


        // ==== Paso 1: comprobar si existe (el ejercicio original) ====
        botonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tNombre = nombre.getText().toString().trim();
                String tApellido = apellido.getText().toString().trim();

                if (dbHelper.existeProfesor(tNombre, tApellido)) {
                    resultado.setText("Es profesor de Medac");
                } else {
                    resultado.setText("No existe ese profesor");
                }
            }
        });


        // ==== Pasos 3 y 5: alta o modificación, según haya uno seleccionado ====
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tNombre = nombre.getText().toString().trim();
                String tApellido = apellido.getText().toString().trim();

                if (tNombre.isEmpty() || tApellido.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Rellena nombre y apellido", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (idSeleccionado == -1) {
                    dbHelper.insertar(tNombre, tApellido);
                    Toast.makeText(MainActivity.this, "Profesor añadido", Toast.LENGTH_SHORT).show();
                } else {
                    dbHelper.actualizar(idSeleccionado, tNombre, tApellido);
                    Toast.makeText(MainActivity.this, "Profesor modificado", Toast.LENGTH_SHORT).show();
                }

                limpiarFormulario();
                cargarLista();
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarFormulario();
            }
        });


        // ==== Paso 5: pulsar una fila la carga en el formulario para editarla ====
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Profesor p = profesores.get(position);
                idSeleccionado = p.getId();
                nombre.setText(p.getNombre());
                apellido.setText(p.getApellido());
                botonGuardar.setText("Guardar cambios");
                botonCancelar.setVisibility(View.VISIBLE);
            }
        });


        // ==== Paso 4: mantener pulsada una fila pide confirmación y la borra ====
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Profesor p = profesores.get(position);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Borrar profesor")
                        .setMessage("¿Seguro que quieres borrar a " + p + "?")
                        .setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper.borrar(p.getId());
                                // Si justo se estaba editando ese, se sale del modo edición
                                if (p.getId() == idSeleccionado) {
                                    limpiarFormulario();
                                }
                                cargarLista();
                            }
                        })
                        .setNegativeButton("Cancelar", null) // null = solo cierra el diálogo
                        .show();

                // true = "evento consumido": así no se lanza también el clic normal
                return true;
            }
        });
    }


    // ==== Paso 2: volcar la tabla en la lista ====
    private void cargarLista() {
        profesores.clear();
        profesores.addAll(dbHelper.obtenerTodos());
        adaptador.notifyDataSetChanged(); // sin esto, la pantalla no se entera del cambio
    }

    private void limpiarFormulario() {
        idSeleccionado = -1;
        nombre.setText("");
        apellido.setText("");
        botonGuardar.setText("Añadir");
        botonCancelar.setVisibility(View.GONE);
    }

}
