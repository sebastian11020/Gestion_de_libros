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
            this.raiz = insertar(this.raiz, dato);
        }
    }

    private int altura(Nodo n) {
        if (n == null) {
            return 0;
        }
        return Math.max(altura(n.getIzquierda()), altura(n.getDerecha())) + 1;
    }

    private Nodo insertar(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato < nodo.getCodigo()) {
            nodo.setIzquierda(insertar(nodo.getIzquierda(), dato));
        } else if (dato > nodo.getCodigo()) {
            nodo.setDerecha(insertar(nodo.getDerecha(), dato));
        } else {
            return nodo;
        }


        nodo.setAltura(Math.max(altura(nodo.getIzquierda()), altura(nodo.getDerecha())) + 1);


        int balance = altura(nodo.getIzquierda()) - altura(nodo.getDerecha());


        if (balance > 1 && dato < nodo.getIzquierda().getCodigo()) {
            return rotarDerecha(nodo);
        }


        if (balance < -1 && dato > nodo.getDerecha().getCodigo()) {
            return rotarIzquierda(nodo);
        }


        if (balance > 1 && dato > nodo.getIzquierda().getCodigo()) {
            nodo.setIzquierda(rotarIzquierda(nodo.getIzquierda()));
            return rotarDerecha(nodo);
        }


        if (balance < -1 && dato < nodo.getDerecha().getCodigo()) {
            nodo.setDerecha(rotarDerecha(nodo.getDerecha()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.getIzquierda();
        Nodo T2 = x.getDerecha();

        x.setDerecha(y);
        y.setIzquierda(T2);

        y.setAltura(Math.max(altura(y.getIzquierda()), altura(y.getDerecha())) + 1);
        x.setAltura(Math.max(altura(x.getIzquierda()), altura(x.getDerecha())) + 1);

        return x;
    }

    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.getDerecha();
        Nodo T2 = y.getIzquierda();

        y.setIzquierda(x);
        x.setDerecha(T2);

        x.setAltura(Math.max(altura(x.getIzquierda()), altura(x.getDerecha())) + 1);
        y.setAltura(Math.max(altura(y.getIzquierda()), altura(y.getDerecha())) + 1);

        return y;
    }

    public boolean estaBalanceado() {
        return estaBalanceado(this.raiz);
    }

    private boolean estaBalanceado(Nodo nodo) {
        if (nodo == null) {
            return true;
        }

        int balance = altura(nodo.getIzquierda()) - altura(nodo.getDerecha());

        return Math.abs(balance) <= 1 && estaBalanceado(nodo.getIzquierda()) && estaBalanceado(nodo.getDerecha());
    }
    private void inorden(Nodo n,Biblioteca biblioteca) {
        if (n != null) {
            inorden(n.getIzquierda(),biblioteca);
            biblioteca.mostrarDatosLibro(n.getCodigo());
            inorden(n.getDerecha(),biblioteca);
        }
    }
    public void inorden(Biblioteca biblioteca) {
        this.inorden(this.raiz,biblioteca);
    }
}
