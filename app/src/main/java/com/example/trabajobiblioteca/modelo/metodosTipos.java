package com.example.trabajobiblioteca.modelo;

import static com.example.trabajobiblioteca.modelo.conector.conectarConBaseDeDatos;

import com.example.trabajobiblioteca.clases.libros;
import com.example.trabajobiblioteca.clases.tipoLibro;
import com.example.trabajobiblioteca.controlador.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class metodosTipos {

    public static ArrayList<tipoLibro> leerTipos(){
        Connection conexion = conector.conectarConBaseDeDatos();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from tipoLibro";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            ArrayList<tipoLibro> tipoLibro = new ArrayList<tipoLibro>();

            while(resultado.next())
            {
                int column1 = resultado.getInt(1);

                String column2 = resultado.getString(2);

                String column3 = resultado.getString(3);



                tipoLibro tb = new tipoLibro(column1, column2, column3);
                tipoLibro.add(tb);


            }
            return tipoLibro;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean insertarTipo(tipoLibro tl) {
        Connection conexion = conector.conectarConBaseDeDatos();
        if(conexion == null){
            return false;
        }
        try {
            Statement sentencia= conexion.createStatement();
            int val = 0;
            do {
                 String ordenSQL = "INSERT INTO tipoLibro(idTipoLibro, Tipo, Localizacion) VALUES (?,?,?);";
                PreparedStatement sentencia2 = conexion.prepareStatement(ordenSQL);
                sentencia2.setInt(1, tl.getIdTipoLibro());
                sentencia2.setString(2, tl.getTipo());
                sentencia2.setString(3, tl.getLocalizacion());

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

    public static boolean eliminarTipo(int tipoEliminar) {
        Connection conexion = conector.conectarConBaseDeDatos();
        if(conexion == null){
            return false;
        }
        try {

            Statement sentencia = conexion.createStatement();

            String ordenSQL = "DELETE FROM tipoLibro WHERE (idTipoLibro = ?);";
            PreparedStatement sentencia2 = conexion.prepareStatement(ordenSQL);
            sentencia2.setInt(1, tipoEliminar);

            sentencia2.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
