package com.example.trabajobiblioteca.run;

import com.example.trabajobiblioteca.clases.tipoLibro;
import com.example.trabajobiblioteca.modelo.metodosTipos;

import java.util.concurrent.Callable;

public class insertarTipo implements Callable<Boolean> {
    private tipoLibro tl = null;

    public insertarTipo(tipoLibro tl) {this.tl = tl;}

    @Override
    public Boolean call() throws Exception {
        try {
            boolean insercionOK = metodosTipos.insertarTipo(tl);
            return insercionOK;
        }
        catch(Exception e){
            return false;
        }
    }
}
