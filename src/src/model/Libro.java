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

    public boolean alMenosUnoIgual(Map<Integer, Libro> otrosLibros) {
        if (otrosLibros == null || otrosLibros.isEmpty()) {
            return false;
        }
        for (Libro otroLibro : otrosLibros.values()) {
            if (sonIgualesExceptoISBN(otroLibro)) {
                return true;
            }
        }
        return false;
    }
    public int buscarLibroIgual(Map<Integer, Libro> otrosLibros) {
        if (otrosLibros == null || otrosLibros.isEmpty()) {
            return -1;
        }
        for (Map.Entry<Integer, Libro> entry : otrosLibros.entrySet()) {
            Libro otroLibro = entry.getValue();
            if (sonIgualesExceptoISBN(otroLibro)) {
                return entry.getKey();
            }
        }
        return -1;
    }
    public boolean sonIgualesExceptoISBN(Libro otroLibro) {
        if (this == otroLibro) {
            return true;
        }
        if (otroLibro == null) {
            return false;
        }
        if (getClass() != otroLibro.getClass()) {
            return false;
        }
        if (volumen != otroLibro.volumen) {
            return false;
        }
        if (titulo == null) {
            if (otroLibro.titulo != null) {
                return false;
            }
        } else if (!titulo.equals(otroLibro.titulo)) {
            return false;
        }
        if (editorial == null) {
            if (otroLibro.editorial != null) {
                return false;
            }
        } else if (!editorial.equals(otroLibro.editorial)) {
            return false;
        }
        if (autor == null) {
            if (otroLibro.autor != null) {
                return false;
            }
        } else if (!autor.sonIguales(otroLibro.autor)) {
            return false;
        }
        if (sede == null) {
            if (otroLibro.sede != null) {
                return false;
            }
        } else if (!sede.sonIguales(otroLibro.sede)) {
            return false;
        }
        return true;
    }


}