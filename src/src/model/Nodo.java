package model;
public class Nodo {
    private int codigo;
    private Nodo izquierda,derecha;
    public Nodo(int codigo){
        this.codigo=codigo;
        this.izquierda=this.derecha=null;
    }
    public int getCodigo(){
        return codigo;
    }
    public Nodo getIzquierda() {
        return izquierda;
    }
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }
    public Nodo getDerecha() {
        return derecha;
    }
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public void imprimirCodigo() {
        System.out.println(this.getCodigo());
    }
}
