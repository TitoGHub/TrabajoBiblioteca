package com.example.trabajobiblioteca.modelo;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conector {

    public static final String HOSTDB = "localhost";
    public static final String NOMBREDB = "bdbiblioteca";
    public static final String USUARIODB = "root";
    public static final String CLAVEDB = "admin";
    public static final String PUERTOMYSQL = "3306";
    public static final int COLUMNAS = 3;
    public static final String URLMYSQL = "jdbc:mysql://"+ HOSTDB +":"+PUERTOMYSQL + "/" + NOMBREDB ;

    //----------------------------------------------------------....
    public static Connection conectarConBaseDeDatos() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection conexion = DriverManager.getConnection(URLMYSQL, USUARIODB, CLAVEDB);
            return conexion;
        } catch (SQLException e) {
            System.out.println("No se ha conectado con la base de datos");
            return null;
        }
    }
}
