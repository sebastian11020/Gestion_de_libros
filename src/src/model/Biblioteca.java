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
        }
    }
    public Map<Integer,Libro> getLibro(int clave){
        Map<Integer,Libro> libroMap = new HashMap<>();
        Libro libro = obtenerLibro(clave);
        if (libro != null) {
            libroMap.put(clave,libro);
        }
        return libroMap;
    }
    public Map<Integer,Libro> getInorden(){
        return inorden;
    }

    
}
