public class App {
    public static void main(String[] args) throws Exception {

        Arbol arbol = new Arbol();
        arbol.crearArbol();

        System.out.println("Recorrido en preorden: ");
        arbol.preorden(arbol.raiz);

        System.out.println("Recorido inorden: ");
        arbol.inorden(arbol.raiz);

        System.out.println("Recorido en postorden: ");
        arbol.postorden(arbol.raiz);
    }
}
