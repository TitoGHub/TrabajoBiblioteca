package com.example.trabajobiblioteca.controlador;


import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.clases.tipoLibro;
import com.example.trabajobiblioteca.run.borrarLibros;
import com.example.trabajobiblioteca.run.borrarTipo;
import com.example.trabajobiblioteca.run.insertarLibros;
import com.example.trabajobiblioteca.run.insertarTipo;
import com.example.trabajobiblioteca.run.obtenerLibros;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class controlador {
    public static boolean insertarLibros(libros lb) {

        FutureTask t = new FutureTask(new insertarLibros(lb));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;

        try {
            insercionOK = (boolean) t.get();
            es.shutdown();

            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }



    public static boolean insertarTipo(tipoLibro tl) {

        FutureTask t = new FutureTask(new insertarTipo(tl));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;

        try {
            insercionOK = (boolean) t.get();
            es.shutdown();

            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }


    public static ArrayList<libros> obtenerLibros(){
        ArrayList<libros> librosObt = null;
        FutureTask t = new FutureTask(new obtenerLibros());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            librosObt = (ArrayList<libros>) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return librosObt;
    }


    public static ArrayList<tipoLibro> obtenerTipos(){
        ArrayList<tipoLibro> tiposObt = null;
        FutureTask t = new FutureTask(new obtenerLibros());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            tiposObt = (ArrayList<tipoLibro>) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tiposObt;
    }


    public static boolean borrarLibro(libros lb){

        FutureTask t = new FutureTask(new borrarLibros(lb));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }


    public static boolean borrarTipo(tipoLibro tl){

        FutureTask t = new FutureTask(new borrarTipo(tl));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }


}
