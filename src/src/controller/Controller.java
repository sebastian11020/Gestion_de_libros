package controller;
import view.View;
import model.*;

import java.util.Map;

public class Controller{
    private View view;
    private boolean exist;
    private Arbol arbol;
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
                new Sede(view.getSede(), view.getFacultad()),1);
        biblioteca.agregarLibro(view.getCodigo(), libro);
        if(!libro.alMenosUnoIgual(biblioteca.obtenerCatalogo())){
            int value = libro.buscarLibroIgual(biblioteca.obtenerCatalogo());
            biblioteca.obtenerLibro(value).setCantidad(libro.getCantidad()+1);
            biblioteca.eliminarLibro(view.getCodigo());
        }
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
                    autor1.getDescripcion(),sede.getSede_libro(),sede.getCampus_libro() );
        }
    }

    public void deleteData(){

    }

    public boolean existCode(){
        return exist;
    }

    public static void main(String[] args) {
        new Controller().showInterface();
    }
}
