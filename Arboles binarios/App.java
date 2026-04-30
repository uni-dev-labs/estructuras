
public class App {
    public static void main(String[] args) {

        Nodo raiz = new Nodo(10);

        raiz.izq = new Nodo(5);
        raiz.der = new Nodo(15);

        raiz.izq.izq = new Nodo(3);
        raiz.izq.der = new Nodo(7);

        System.out.println("Preorden:");
        preorden(raiz);

        System.out.println("\nInorden:");
        inorden(raiz);

        System.out.println("\nPostorden:");
        postorden(raiz);
    }

    public static void preorden(Nodo n) {
        if (n != null) {
            System.out.print(n.valor + " ");
            preorden(n.izq);
            preorden(n.der);
        }
    }

    public static void inorden(Nodo n) {
        if (n != null) {
            inorden(n.izq);
            System.out.print(n.valor + " ");
            inorden(n.der);
        }
    }

    public static void postorden(Nodo n) {
        if (n != null) {
            postorden(n.izq);
            postorden(n.der);
            System.out.print(n.valor + " ");
        }
    }
}

class Nodo {
    int valor;
    Nodo izq;
    Nodo der;

    public Nodo(int valor) {
        this.valor = valor;
    }
}