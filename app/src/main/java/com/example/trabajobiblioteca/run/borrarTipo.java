package com.example.trabajobiblioteca.run;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.clases.tipoLibro;
import com.example.trabajobiblioteca.modelo.metodosLibros;
import com.example.trabajobiblioteca.modelo.metodosTipos;

import java.util.concurrent.Callable;

public class borrarTipo implements Callable<Boolean> {

    private tipoLibro tl = null;

    public borrarTipo(tipoLibro tl) { this.tl = tl;}
    @Override
    public Boolean call() throws Exception {
        try{
            boolean borradoOK = metodosTipos.eliminarTipo(tl.getIdTipoLibro());
            return borradoOK;
        }
        catch(Exception e){
            return false;
        }
    }
}
