package exposiciones.ejercicio2;

public class Node {

    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }

    void insert(int newValue) {
        if (newValue < value) {
            if (left == null) {
                left = new Node(newValue);
            } else {
                left.insert(newValue);
            }
        } else {
            if (right == null) {
                right = new Node(newValue);
            } else {
                right.insert(newValue);
            }
        }
    }
}
