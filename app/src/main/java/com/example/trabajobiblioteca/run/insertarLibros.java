package com.example.trabajobiblioteca.run;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.modelo.metodosLibros;

import java.util.concurrent.Callable;

public class insertarLibros implements Callable<Boolean> {

    private libros lb = null;
    public insertarLibros(libros lb) { this.lb = lb;}

    @Override
    public Boolean call() throws Exception {
        try {
            boolean insercionOK = metodosLibros.insertarLibro(lb);
            return insercionOK;
        }
        catch(Exception e){
            return false;
        }
    }
}
