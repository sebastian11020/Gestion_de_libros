package controller;
import view.View;
import model.Arbol;
public class Controller {
    private View view;
    private Arbol arbol;
    public Controller(){
        this.view= new View();
        this.arbol=new Arbol();
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
