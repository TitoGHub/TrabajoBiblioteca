package com.example.trabajobiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class manejoLibros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manejolibros);
    }

    public void insertarLibro(View view){
        Intent intent = new Intent(this, nuevoLibro.class);
        startActivity(intent);
    }

    public void mostrarLibro(View view){
        Intent intent = new Intent(this, mostrarLibro.class);
        startActivity(intent);
    }

    public void borrarLibro(View view){
        Intent intent = new Intent(this, borrarLibro.class);
        startActivity(intent);
    }


}