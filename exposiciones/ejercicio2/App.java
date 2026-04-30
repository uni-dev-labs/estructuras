package exposiciones.ejercicio2;

public class App {
        public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        // Insertar valores: 10, 5, 15, 3, 7
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);

        System.out.println("Recorrido Preorden:");
        arbol.preorden(arbol.raiz);

        System.out.println("\nRecorrido Inorden:");
        arbol.inorden(arbol.raiz);

        System.out.println("\nRecorrido Postorden:");
        arbol.postorden(arbol.raiz);
    }
}
