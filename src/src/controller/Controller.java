package controller;
import view.View;
import model.*;

import java.util.Map;

public class Controller{
    private View view;
    private boolean exist;
    private Arbol arbol;

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    private Biblioteca biblioteca;

    private Biblioteca biblioAux;
    public Controller(){
        this.biblioAux = new Biblioteca();
        this.view= new View();
        this.arbol=new Arbol();
        this.biblioteca= new Biblioteca();
        view.setController(this);
    }

    public void showInterface(){
        view.showFrameMenu();
    }
    public void addCode(){
        if (!arbol.existe(view.getCodigo())) {
            arbol.insertar(view.getCodigo());
            exist=false;
        } else {
            view.showMessage("El codigo ya esta registrado");
            exist=true;
        }
    }

    public void addData(){
        Libro libro = new Libro(view.getTitulo(), view.getCodigo(), view.getVolumen(), view.getEditorial(),
                new Autor(view.getNombre(), view.getApellido(), view.getBio()),
                new Sede(view.getSede(), view.getFacultad()), view.getCopias());
        biblioteca.agregarLibro(view.getCodigo(), libro);
    }
    public void mostrarTodo(){
        arbol.inorden(biblioteca);
        Map<Integer,Libro> map = biblioteca.getInorden();
        for (Map.Entry<Integer, Libro> entry : map.entrySet()) {
            int codigo = entry.getKey();
            Libro libro = entry.getValue();
            Autor autor1 = libro.getAutor();
            Sede sede = libro.getSede();
            String autorLibro;
            StringBuilder autor = new StringBuilder();
            autor.append(autor1.getNombre()).append(" ").append(autor1.getApellido());
            autorLibro= String.valueOf(autor);
            view.addDateTable(libro.getISBN(), libro.getTitulo(), libro.getVolumen(), view.getEditorial(),autorLibro,
                    autor1.getDescripcion(),sede.getSede_libro(),sede.getCampus_libro(),libro.getCantidad() );
        }
    }

    public void deleteData(int isbn, String sede) {
        for (Map.Entry<Integer, Libro> entry : biblioteca.obtenerCatalogo().entrySet()) {
            int clave = entry.getKey();
            Libro libro = entry.getValue();
            if (libro.getISBN() == isbn && libro.getSede().getSede_libro().equals(sede)) {
                int cantidadActual = libro.getCantidad();
                if (cantidadActual > 0) {
                    libro.setCantidad(cantidadActual - 1);
                }
                if (libro.getCantidad() <= 0) {
                    biblioteca.eliminarLibro(clave);
                    view.showMessage("Libro eliminado con éxito");
                } else {
                    view.showMessage("Se eliminó una copia del libro");
                }
                return;
            }
        }
        view.showMessage("No se encontró un libro con el ISBN y sede especificados.");
    }
    public void buscar() {
        Map<Integer, Libro> map = biblioteca.getLibro(view.getCodigo());
        Libro libroEncontrado = null;
        for (Map.Entry<Integer, Libro> entry : map.entrySet()) {
            if (entry.getKey() == view.getCodigo()) {
                libroEncontrado = entry.getValue();
                break;
            }
        }
        if (libroEncontrado != null) {
            System.out.println(libroEncontrado.getTitulo());
            Autor autor1 = libroEncontrado.getAutor();
            Sede sede = libroEncontrado.getSede();
            String autorLibro;
            StringBuilder autor = new StringBuilder();
            autor.append(autor1.getNombre()).append(" ").append(autor1.getApellido());
            autorLibro = String.valueOf(autor);
            view.addDateTableSearch(libroEncontrado.getISBN(), libroEncontrado.getTitulo(), libroEncontrado.getVolumen(), view.getEditorial(), autorLibro,
                    autor1.getDescripcion(), sede.getSede_libro(), sede.getCampus_libro(), libroEncontrado.getCantidad());
        } else {
            view.showMessage("Libro no encontrado");
        }
    }

    public boolean searchISBN(int codigo){
        if(biblioteca.obtenerLibro(codigo)==null){
            if(biblioAux.obtenerLibro(codigo)==null){
                return false;
            }
            return true;
        }
        return true;
    }
    public boolean searchTitle(String titulo){
        if(biblioteca.buscarLibroPorTitulo(titulo,biblioteca.obtenerCatalogo())==null){
            if(biblioAux.buscarLibroPorTitulo(titulo,biblioAux.obtenerCatalogo())==null){
                return false;
            }
            return true;
        }
        return true;
    }
    public boolean searchSede(String sede){
        if(biblioteca.buscarLibroPorSede(sede,biblioteca.obtenerCatalogo())==null){
            if(biblioAux.buscarLibroPorSede(sede,biblioAux.obtenerCatalogo())==null){
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean existCode(){
        return exist;
    }

    public static void main(String[] args) {
        new Controller().showInterface();
    }
}