package exposiciones.estructuras_no_lineales;
public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario arbol = new ArbolBinario();

        // Construcción del árbol
        arbol.construirArbol();

        // Mostrar recorridos
        System.out.println("Recorrido Preorden:");
        arbol.preorden(arbol.raiz);

        System.out.println("\n\nRecorrido Inorden:");
        arbol.inorden(arbol.raiz);

        System.out.println("\n\nRecorrido Postorden:");
        arbol.postorden(arbol.raiz);
    }
}
