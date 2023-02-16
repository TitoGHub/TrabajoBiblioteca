package com.example.trabajobiblioteca.run;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.modelo.metodosLibros;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class obtenerLibros implements Callable<ArrayList<libros>> {
    @Override
    public ArrayList<libros> call() throws Exception {

        ArrayList<libros> libros = metodosLibros.leerLibros();
        return libros;
    }
}
