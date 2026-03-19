package lista_enlazada;

public class Main {
    public static void main(String[] args) {
        // Creamos una lista vacía
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        Menu.iniciarMenu();

        System.out.println("¿Lista vacía? " + lista.estaVacia());
        lista.imprimir();

        // Insertamos algunos elementos
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlInicio(5);
        lista.insertarAlInicio(53);

        System.out.print("Lista después de inserciones: ");
        lista.imprimir();
        // System.out.println("Tamaño: " + lista.size());

        // Insertar en posición específica
        lista.insertarEnPosicion(15, 2); // posición 2: 5 -> 10 -> 15 -> 20 -> 30
        System.out.print("Lista después de insertar 15 en posición 2: ");
        lista.imprimir();

        // Buscar valores
        System.out.println("Posición del valor 20: " + lista.buscar(20));
        System.out.println("¿La lista contiene 100? " + lista.contiene(100));

        // Eliminar por valor
        lista.eliminarPorValor(10); // elimina el nodo con valor 10
        System.out.print("Lista después de eliminar el valor 10: ");
        lista.imprimir();

        // Eliminar por posición
        lista.eliminarEnPosicion(0); // elimina la cabeza
        System.out.print("Lista después de eliminar la posición 0: ");
        lista.imprimir();

        // Obtener valor en posición
        System.out.println("Valor en posición 1: " + lista.obtenerEnPosicion(1));

        // Limpiar lista
        lista.limpiar();
        System.out.print("Lista después de limpiar: ");
        lista.imprimir();
        System.out.println("¿Lista vacía? " + lista.estaVacia());
    }
}
