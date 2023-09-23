package model;
import java.util.HashMap;
import java.util.Map;
public class Biblioteca {
    private Map<Integer, Libro> catalogo;

    public Biblioteca() {
        catalogo = new HashMap<>();
    }
    public void agregarLibro(Integer clave, Libro libro) {
        catalogo.put(clave, libro);
    }
    public Libro obtenerLibro(Integer clave) {
        return catalogo.get(clave);
    }
    public void eliminarLibro(Integer clave) {
        catalogo.remove(clave);
    }
    public Map<Integer, Libro> obtenerCatalogo() {
        return catalogo;
    }
    public void mostrarDatosLibro(Integer clave) {
        Libro libro = obtenerLibro(clave);
        if (libro != null) {
            System.out.println("Datos del Libro:");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("ISBN: " + libro.getISBN());
            System.out.println("Volumen: " + libro.getVolumen());
            System.out.println("Editorial: " + libro.getEditorial());
            Autor autor = libro.getAutor();
            System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellido());
            System.out.println("Descripción del Autor: " + autor.getDescripcion());
            Sede sede = libro.getSede();
            System.out.println("Sede del Libro: " + sede.getSede_libro());
            System.out.println("Campus del Libro: " + sede.getCampus_libro());
            System.out.println("Cantidad de Copias Disponibles: " + libro.getCantidad());
        } else {
            System.out.println("El libro con clave " + clave + " no existe en la biblioteca.");
        }
    }
    public void mostrarTodosLosLibros() {
        System.out.println("Lista de Todos los Libros en la Biblioteca:");
        for (Map.Entry<Integer, Libro> entry : catalogo.entrySet()) {
            System.out.println("\nClave: " + entry.getKey());
            mostrarDatosLibro(entry.getKey());
        }
    }
}
