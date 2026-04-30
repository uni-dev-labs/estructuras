package pilas;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push() — agrega elementos al tope
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Pila inicial:       " + stack);

        // size() — cantidad de elementos
        System.out.println("size():             " + stack.size());

        // peek() — consulta el tope sin eliminarlo
        System.out.println("peek():             " + stack.peek());

        // search() — posición desde el tope (base 1), -1 si no existe
        System.out.println("search(30):         " + stack.search(30));
        System.out.println("search(99):         " + stack.search(99));

        // empty() — true si la pila no tiene elementos
        System.out.println("empty():            " + stack.empty());

        // pop() — elimina y retorna el tope
        System.out.println("pop():              " + stack.pop());
        System.out.println("Pila tras pop():    " + stack);
    }
}