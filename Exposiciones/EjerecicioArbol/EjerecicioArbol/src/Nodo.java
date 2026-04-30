package Exposiciones.EjerecicioArbol.EjerecicioArbol.src;


public class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;

    /**
     * Constructor del nodo
     * 
     * @param valor el valor que almacenará el nodo
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}
