package Arboles.src;

public class App {
    public static void main(String[] args) throws Exception {
        TreeBinary tree = new TreeBinary();

        int[] values = { 10, 5, 15, 3, 7 };
        for (int v : values) {
            tree.insertar(v);
        }

        System.out.print("Preorder: ");
        tree.preorden(tree.raiz);

        System.out.print("\nInorder: ");
        tree.inorden(tree.raiz);

        System.out.print("\nPostorder: ");
        tree.postorden(tree.raiz);
    }
}
