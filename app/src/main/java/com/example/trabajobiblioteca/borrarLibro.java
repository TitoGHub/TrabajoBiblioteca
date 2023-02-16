package com.example.trabajobiblioteca;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.modelo.metodosLibros;

import java.util.ArrayList;

public class borrarLibro extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spBorrar;
    ArrayList<libros> Libros;
    ArrayAdapter<libros> aLibros;
    libros libroSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_libro);

        spBorrar = (Spinner) findViewById(R.id.spnBorrar);
        Libros = metodosLibros.leerLibros();
        //-----------------------
        for (libros lb : Libros) {
            System.out.println(lb.toString());
            Log.i("Libro: ", lb.toString());
        }
        //-----------------------
        spBorrar.setOnItemSelectedListener(this);
        //-----------------------
        aLibros = new ArrayAdapter<libros>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Libros);
        spBorrar.setAdapter(aLibros);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        libroSelec = (libros) spBorrar.getItemAtPosition(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void asignarAdaptadorSpinnerProductos(ArrayList<libros> Libros) {
        aLibros = new ArrayAdapter<libros>(this, R.layout.librorv, Libros);
        spBorrar.setAdapter(aLibros);
    }


}
