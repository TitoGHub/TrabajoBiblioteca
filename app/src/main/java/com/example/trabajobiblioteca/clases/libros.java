package com.example.trabajobiblioteca.clases;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class libros implements Serializable {
        private int idLibro;
        private String genero;
        private String autor;
        private String fecha;
        private int numPaginas;
        private int idTipoLibro;

        public libros(int idLibro, String genero, String autor, String fecha, int numPaginas, int idTipoLibro) {
                this.idLibro = idLibro;
                this.genero = genero;
                this.autor = autor;
                this.fecha = fecha;
                this.numPaginas = numPaginas;
                this.idTipoLibro = idTipoLibro;
        }

        public int getIdLibro() {
                return idLibro;
        }

        public void setIdLibro(int idLibro) {
                this.idLibro = idLibro;
        }

        public String getGenero() {
                return genero;
        }

        public void setGenero(String genero) {
                this.genero = genero;
        }

        public String getAutor() {
                return autor;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public String getFecha() {
                return fecha;
        }

        public void setFecha(String fecha) {
                this.fecha = fecha;
        }

        public int getNumPaginas() {
                return numPaginas;
        }

        public void setNumPaginas(int numPaginas) {
                this.numPaginas = numPaginas;
        }

        public int getIdTipoLibro() {
                return idTipoLibro;
        }

        public void setIdTipoLibro(int idTipoLibro) {
                this.idTipoLibro = idTipoLibro;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                libros libros = (libros) o;
                return idLibro == libros.idLibro;
        }

        @Override
        public int hashCode() {
                return Objects.hash(idLibro);
        }
}
