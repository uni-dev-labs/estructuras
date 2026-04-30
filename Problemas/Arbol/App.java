package Problemas.Arbol;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario arbol = new ArbolBinario();

        int[] valores = { 10, 5, 15, 3, 7 };
        for (int v : valores) {
            arbol.raiz = arbol.insertar(arbol.raiz, v);
        }

        System.out.print("Preorden: ");
        arbol.preorden(arbol.raiz);
        System.out.println("");

        System.out.print("Inorden: ");
        arbol.inorden(arbol.raiz);
        System.out.println("");

        System.out.print("Postorden: ");
        arbol.postorden(arbol.raiz);
    }
}
