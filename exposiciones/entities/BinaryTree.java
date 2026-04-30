// =======================
// File: BinaryTree.java
// =======================
package exposiciones.entities;

public class BinaryTree {

    private Node root;

    // ================= INSERT =================

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {

            current.setLeft(
                    insertRecursive(current.getLeft(), value));

        } else if (value > current.getValue()) {

            current.setRight(
                    insertRecursive(current.getRight(), value));
        }

        return current;
    }

    // ================= PREORDER =================

    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node node) {

        if (node != null) {

            System.out.print(node.getValue() + " ");

            preOrderRecursive(node.getLeft());

            preOrderRecursive(node.getRight());
        }
    }

    // ================= INORDER =================

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node node) {

        if (node != null) {

            inOrderRecursive(node.getLeft());

            System.out.print(node.getValue() + " ");

            inOrderRecursive(node.getRight());
        }
    }

    // ================= POSTORDER =================

    public void postOrder() {
        postOrderRecursive(root);
    }

    private void postOrderRecursive(Node node) {

        if (node != null) {

            postOrderRecursive(node.getLeft());

            postOrderRecursive(node.getRight());

            System.out.print(node.getValue() + " ");
        }
    }
}