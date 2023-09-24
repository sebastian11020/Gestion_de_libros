package model;
public class Nodo {
    private int codigo;
    private Nodo izquierda,derecha;
    private int altura;
    public Nodo(int codigo){
        this.codigo=codigo;
        this.izquierda=this.derecha=null;
        this.altura = 1;
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
    public int getAltura() { return altura;}
    public void setAltura(int altura) {this.altura = altura;}

    public void setDato(int dato) {
        this.codigo = dato;
    }

    public void imprimirCodigo() {
        System.out.println(this.getCodigo());
    }
}
