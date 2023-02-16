package com.example.trabajobiblioteca;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.modelo.metodosLibros;

public class nuevoLibro extends AppCompatActivity {

    private EditText etxtNuevoLId;
    private EditText etxtNuevoLGen;
    private EditText etxtNuevoLAutor;
    private EditText etxtNuevoLFecha;
    private EditText etxtNuevoLNumPag;
    private EditText etxtNuevoLIdTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevolibro);

        etxtNuevoLId = (EditText) findViewById(R.id.etxtNuevoLId);
        etxtNuevoLGen = (EditText) findViewById(R.id.etxtNuevoLGen);
        etxtNuevoLAutor = (EditText) findViewById(R.id.etxtNuevoLAutor);
        etxtNuevoLFecha = (EditText) findViewById(R.id.etxtNuevoLFecha);
        etxtNuevoLNumPag = (EditText) findViewById(R.id.etxtNuevoLNumPag);
        etxtNuevoLIdTipo = (EditText) findViewById(R.id.etxtNuevoLIdTipo);
    }

    public void insertarLibro(View view) {
        int id = Integer.valueOf(String.valueOf(etxtNuevoLId.getText()));
        String genero = String.valueOf(etxtNuevoLGen);
        String autor = String.valueOf(etxtNuevoLGen);
        String fecha = String.valueOf(etxtNuevoLGen);
        int NumPag = Integer.valueOf(String.valueOf(etxtNuevoLGen));
        int idTipo = Integer.valueOf(String.valueOf(etxtNuevoLIdTipo.getText()));


        boolean error = false;
        if (id == 0){
            etxtNuevoLId.setError("Esta casilla no puede estar vacia");
            error = true;
        }
        if (genero.isEmpty()){
            etxtNuevoLGen.setError("Esta casilla no puede estar vacia");
            error = true;
        }
        if (autor.isEmpty()){
            etxtNuevoLAutor.setError("Esta casilla no puede estar vacia");
            error = true;
        }
        if (fecha.isEmpty()){
            etxtNuevoLFecha.setError("Esta casilla no puede estar vacia");
            error = true;
        }
        if (NumPag == 0){
            etxtNuevoLNumPag.setError("Esta casilla no puede estar vacia");
            error = true;
        }
        if (idTipo == 0){
            etxtNuevoLIdTipo.setError("Esta casilla no puede estar vacia");
            error = true;
        }
        if(error){
            return;
        }

        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("Son correctos los datos y desea ingresar el libro?");
        alerta1.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                libros lb = new libros(id, genero, autor, fecha, NumPag, idTipo);
                boolean insercionOK = metodosLibros.insertarLibro(lb);
                mostrarToast(insercionOK);

            }
        });
        alerta1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        alerta1.show();
    }


    public void mostrarToast(boolean insercionOK){
        if(insercionOK){
            Toast.makeText(this,"Libro guardado correctamente.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"No se pudo guardar el libro.", Toast.LENGTH_SHORT).show();

        }
    }
}