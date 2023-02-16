package com.example.trabajobiblioteca.run;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.clases.tipoLibro;
import com.example.trabajobiblioteca.modelo.metodosLibros;
import com.example.trabajobiblioteca.modelo.metodosTipos;

import java.util.ArrayList;
import java.util.concurrent.Callable;

    public class obtenerTipo implements Callable<ArrayList<tipoLibro>> {
        @Override
        public ArrayList<tipoLibro> call() throws Exception {

            ArrayList<tipoLibro> tipos = metodosTipos.leerTipos();
            return tipos;
        }
}
