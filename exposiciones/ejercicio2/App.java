package exposiciones.ejercicio2;

public class App {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(3);
        root.insert(7);

        System.out.println("Preorden:");
        preorder(root);
        System.out.println();

        System.out.println("Inorden:");
        inorder(root);
        System.out.println();

        System.out.println("Postorden:");
        postorder(root);
        System.out.println();
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }
}
