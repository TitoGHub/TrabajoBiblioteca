package com.example.trabajobiblioteca.modelo;

import com.example.trabajobiblioteca.clases.libros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class metodosLibros {

    public static ArrayList<libros> leerLibros(){
        Connection conexion = conector.conectarConBaseDeDatos();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from libro";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            ArrayList<libros> libros = new ArrayList<libros>();

            while(resultado.next())
            {
                int column1 = resultado.getInt(1);

                String column2 = resultado.getString(2);

                String column3 = resultado.getString(3);

                String column4 = resultado.getString(4);

                int column5 = resultado.getInt(5);

                int column6 = resultado.getInt(6);


                libros lb = new libros(column1, column2, column3, column4, column5, column6);
                libros.add(lb);


            }
            return libros;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean insertarLibro(libros lb) {
        Connection conexion = conector.conectarConBaseDeDatos();
        if(conexion == null){
            return false;
        }
        try {
            Statement sentencia= conexion.createStatement();
            int val = 0;
            do {

                String ordenSQL = "INSERT INTO libro(idlibro_ISBN, genero, autor, fecha, numPaginas, tipoLibro) VALUES (?,?,?,?,?,?);";
                PreparedStatement sentencia2 = conexion.prepareStatement(ordenSQL);
                sentencia2.setInt(1, lb.getIdLibro());
                sentencia2.setString(2, lb.getGenero());
                sentencia2.setString(3, lb.getAutor());
                sentencia2.setString(4, lb.getFecha());
                sentencia2.setInt(5, lb.getNumPaginas());
                sentencia2.setInt(6, lb.getIdTipoLibro());
                try {
                    sentencia2.executeUpdate();
                    break;
                } catch (SQLIntegrityConstraintViolationException e) {
                    System.out.println("Ya existe el id");
                    System.out.println("Vuelva a intentarlo");
                    System.out.println(" ");

                }
            }while(true);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean eliminarLibro(int libroEliminar) {
        Connection conexion = conector.conectarConBaseDeDatos();
        if(conexion == null){
            return false;
        }
        try {
            Statement sentencia = conexion.createStatement();

            String ordenSQL = "DELETE FROM libro WHERE (idlibro_ISBN = ?);";
            PreparedStatement sentencia2 = conexion.prepareStatement(ordenSQL);
            sentencia2.setInt(1, libroEliminar);

            sentencia2.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

