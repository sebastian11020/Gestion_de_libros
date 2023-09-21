package model;

public class Arbol {
    private Nodo raiz;
    public Arbol() {
    }
    public boolean existe(int busqueda) {
        return existe(this.raiz, busqueda);
    }
    private boolean existe(Nodo n, int busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getCodigo() == busqueda) {
            return true;
        } else if (busqueda < n.getCodigo()) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }
    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            this.insertar(this.raiz, dato);
        }
    }
    private void insertar(Nodo padre, int dato) {
        if (dato > padre.getCodigo()) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(dato));
            } else {
                this.insertar(padre.getDerecha(), dato);
            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(dato));
            } else {
                this.insertar(padre.getIzquierda(), dato);
            }
        }
    }
}
