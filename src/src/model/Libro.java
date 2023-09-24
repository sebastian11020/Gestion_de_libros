package model;

import java.util.Map;

public class Libro {
    private String titulo;
    private int cantidad;
    private int ISBN;
    private int volumen;
    private String editorial;
    private Autor autor;
    private Sede sede;
    public Libro(String titulo, int ISBN, int volumen, String editorial, Autor autor,
                 Sede sede, int cantidad) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.volumen = volumen;
        this.editorial = editorial;
        this.autor = autor;
        this.sede = sede;
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}