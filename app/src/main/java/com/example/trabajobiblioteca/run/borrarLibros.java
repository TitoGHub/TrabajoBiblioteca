package com.example.trabajobiblioteca.run;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.modelo.metodosLibros;

import java.util.concurrent.Callable;

public class borrarLibros implements Callable<Boolean> {

    private libros lb = null;

    public borrarLibros(libros lb) { this.lb = lb;}
    @Override
    public Boolean call() throws Exception {
        try{
            boolean borradoOK = metodosLibros.eliminarLibro(lb.getIdLibro());
            return borradoOK;
        }
        catch(Exception e){
            return false;
        }
    }
}
