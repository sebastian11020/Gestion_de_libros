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
}
