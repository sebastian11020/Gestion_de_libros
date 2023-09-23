package controller;
import view.View;
import model.*;

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
        Libro libro = new Libro(view.getTitulo(), view.getCodigo(), view.getVolumen(), view.getEditorial(),
                new Autor(view.getNombre(), view.getApellido(), view.getBio()), new Sede(view.getSede(), view.getFacultad()));
        biblioteca.agregarLibro(view.getCodigo(), libro);
        biblioteca.mostrarTodosLosLibros();
    }

    public boolean existCode(){
        return exist;
    }

    public static void main(String[] args) {
        new Controller().showInterface();
    }
}
