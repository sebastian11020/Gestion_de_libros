package model;
import java.util.HashMap;
import java.util.Map;
public class Biblioteca {
    private Map<Integer, Libro> catalogo;
    private Map<Integer,Libro> inorden;
    public Biblioteca() {
        catalogo = new HashMap<>();
        inorden=new HashMap<>();
    }
    public void agregarLibro(Integer clave, Libro libro) {
        catalogo.put(clave, libro);
    }
    public Libro obtenerLibro(Integer clave) {
        return catalogo.get(clave);
    }
    public Libro buscarLibroPorTitulo(String tituloBuscado, Map<Integer, Libro> libros) {
        if (tituloBuscado == null || libros == null || libros.isEmpty()) {
            return null;
        }
        for (Libro libro : libros.values()) {
            if (tituloBuscado.equals(libro.getTitulo())) {
                return libro;
            }
        }
        return null;
    }
    public Libro buscarLibroPorSede(String sedeBuscada, Map<Integer, Libro> libros) {
        if (sedeBuscada == null || libros == null || libros.isEmpty()) {
            return null;
        }
        for (Libro libro : libros.values()) {
            if (sedeBuscada.equals(libro.getSede())) {
                return libro;
            }
        }
        return null;
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
            inorden.put(clave,libro);
        } else {
            System.out.println("El libro con clave " + clave + " no existe en la biblioteca.");
        }
    }
    public Map<Integer,Libro> getLibro(int clave){
        Map<Integer,Libro> libroMap = new HashMap<>();
        Libro libro = obtenerLibro(clave);
        if (libro != null) {
            libroMap.put(clave,libro);
        } else {
            System.out.println("El libro con clave " + clave + " no existe en la biblioteca.");
        }
        return libroMap;
    }
    public Map<Integer,Libro> getInorden(){
        return inorden;
    }

    
}
