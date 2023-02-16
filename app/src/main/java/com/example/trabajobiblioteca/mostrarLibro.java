package com.example.trabajobiblioteca;

import static com.example.trabajobiblioteca.modelo.conector.COLUMNAS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.modelo.metodosLibros;

import java.util.ArrayList;
import java.util.List;

public class mostrarLibro extends AppCompatActivity {

    private RecyclerView rvLibros;
    private libroAdapter lAdapter;
    private List<libros> Libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_libro);
        rvLibros = findViewById(R.id.rvLibros);

        lAdapter = new libroAdapter(this);
        Libros = metodosLibros.leerLibros();
        if(Libros != null){
            lAdapter.setListaLibros((ArrayList<libros>) Libros);
        }

        rvLibros.setAdapter(lAdapter);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            rvLibros.setLayoutManager(new LinearLayoutManager(this));
        } else {
            rvLibros.setLayoutManager(new GridLayoutManager(this, COLUMNAS));
        }
    }
}