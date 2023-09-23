package controller;
import view.View;
import model.*;

import java.util.Map;

public class Controller{
    private View view;
    private boolean exist;
    private Arbol arbol;
    private Biblioteca biblioteca;
    public Controller(){
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
            exist=false;
        } else {
            view.showMessage("El codigo ya esta registrado");
            exist=true;
        }
    }
    public void addData(){
        if (!arbol.existe(view.getCodigo())) {
            arbol.insertar(view.getCodigo());
            exist=false;
        } else {
            view.showMessage("El codigo ya esta registrado");
            exist=true;
        }
        Libro libro = new Libro(view.getTitulo(), view.getCodigo(), view.getVolumen(), view.getEditorial(),
                new Autor(view.getNombre(), view.getApellido(), view.getBio()), new Sede(view.getSede(), view.getFacultad()),1);
        biblioteca.agregarLibro(view.getCodigo(), libro);
        if(libro.alMenosUnoIgual(biblioteca.obtenerCatalogo())==false){
            int value = libro.buscarLibroIgualExcepto(biblioteca.obtenerCatalogo());
            biblioteca.obtenerLibro(value).setCantidad(libro.getCantidad()+1);
            biblioteca.eliminarLibro(view.getCodigo());
        }
        biblioteca.mostrarTodosLosLibros();
    }

    public boolean existCode(){
        return exist;
    }

    public static void main(String[] args) {
        new Controller().showInterface();
    }
}
