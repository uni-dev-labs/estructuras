public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);

        System.out.println("Recorrido Preorden:");
        arbol.preorden();

        System.out.println("Recorrido Inorden:");
        arbol.inorden();

        System.out.println("Recorrido Postorden:");
        arbol.postorden();
    }
}