package Exposiciones.EjerecicioArbol.EjerecicioArbol.src;

public class App {
    public static void main(String[] args) throws Exception {

        ArbolBinario arbol = new ArbolBinario();

        System.out.println("=== Árbol Binario Simple ===\n");
        System.out.println("Insertando valores: 10, 5, 15, 3, 7\n");

        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);

        // Mostrar la estructura visual del árbol
        arbol.mostrar();

        System.out.println("\nRecorridos del árbol:");
        System.out.println("--------------------");
        arbol.preorden();
        arbol.inorden();
        arbol.postorden();
    }
}
