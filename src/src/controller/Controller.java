package controller;
import view.View;
import model.*;

public class Controller {
    private View view;
    private Arbol arbol;
    private Biblioteca biblioteca;
    public Controller(){
        this.view= new View();
        this.arbol=new Arbol();
        this.biblioteca= new Biblioteca();
    }
    public void showInterface(){
        view.showFrameMenu();
        addCode();
    }
    public void addCode(){
        if(!arbol.existe(view.getCodigo())){
            arbol.insertar(view.getCodigo());
        }else{
            view.showMessage("El codigo ya esta registrado");
        }
    }

    public static void main(String[] args) {
        new Controller().showInterface();
    }
}
