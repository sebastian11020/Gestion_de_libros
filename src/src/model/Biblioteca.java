package model;
import java.util.HashMap;
import java.util.Map;
public class Biblioteca {
    private Map<Integer, Libro> catalogo;
    private Map<Integer,Libro> inorden;
    private String titulo;
    private int codigo;
    private int volumen;
    private String editorial;
    private String nombre;
    private String apellido;
    private String descripsion;
    private String sede;
    private String facultad;
    private int copias;
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
        } else {
            System.out.println("El libro con clave " + clave + " no existe en la biblioteca.");
        }
    }
    public Map<Integer,Libro> getInorden(){
        return inorden;
    }
}
