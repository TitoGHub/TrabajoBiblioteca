package com.example.trabajobiblioteca.clases;

import java.io.Serializable;
import java.util.Objects;

public class tipoLibro implements Serializable {
    private int idTipoLibro;
    private String tipo;
    private String localizacion;

    public tipoLibro(int idTipoLibro, String tipo, String localizacion) {
        this.idTipoLibro = idTipoLibro;
        this.tipo = tipo;
        this.localizacion = localizacion;
    }

    public int getIdTipoLibro() {
        return idTipoLibro;
    }

    public void setIdTipoLibro(int idTipoLibro) {
        this.idTipoLibro = idTipoLibro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tipoLibro tipoLibro = (tipoLibro) o;
        return idTipoLibro == tipoLibro.idTipoLibro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoLibro);
    }
}
