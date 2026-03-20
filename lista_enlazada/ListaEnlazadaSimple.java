package lista_enlazada;

import lista_enlazada.models.Node;
import lista_enlazada.models.Transaccion;

//Está compuesta por nodos (`Node`) que guardan: un valor entero y una referencia al siguiente nodo
//Solo conocemos el primer nodo de la lista (`head`).

public class ListaEnlazadaSimple {
  private Node head;

  //Constructor: crea una lista vacía.
  public ListaEnlazadaSimple() {
    this.head = null;
  }


  //Indica si la lista está vacía.
  public boolean estaVacia() {
    return head == null;
  }

  //Devuelve la cantidad de nodos (tamaño) de la lista.
  public int size() {
    int contador = 0;
    Node actual = head;

    // Recorremos todos los nodos y contamos
    while (actual != null) {
      contador++;
      actual = actual.getNext();
    }

    return contador;
  }


  // Inserta un nuevo elemento al inicio de la lista.
  public void insertarAlInicio(int value) {
    Node nuevo_nodo = new Node(value);
    nuevo_nodo.setNext(head); // El nuevo nodo apunta al que antes era el primero
    head = nuevo_nodo; // Ahora el nuevo nodo es la cabeza de la lista
  }

  // Inserta un nuevo elemento al final de la lista.
  public void insertarAlFinal(int value) {
    Node nuevo_nodo = new Node(value);

    // Caso lista vacía: el nuevo nodo es la cabeza
    if (head == null) {
      head = nuevo_nodo;
      return;
    }

    // Recorremos hasta el último nodo (aquel cuyo next es null)
    Node actual = head;
    while (actual.getNext() != null) {
      actual = actual.getNext();
    }

    actual.setNext(nuevo_nodo); // El último nodo ahora apunta al nuevo
  }

  /**
   * Inserta un nuevo elemento en una posición específica.
   *
   * - posición 0  -> inserta al inicio
   * - posición == size() -> inserta al final
   * - en otro caso -> inserta en medio
   *
   * Si la posición es inválida (negativa o mayor que size()) se lanza excepción.
   */
  public void insertarEnPosicion(int value, int posicion) {
    if (posicion < 0 || posicion > size()) throw new IndexOutOfBoundsException("Posición inválida: " + posicion);

    // Insertar al inicio
    if (posicion == 0) {
      insertarAlInicio(value);
      return;
    }

    // Recorremos hasta el nodo ANTERIOR a la posición deseada
    int indiceActual = 0;
    Node nodo_actual = head;
    while (indiceActual < posicion - 1) {
      nodo_actual = nodo_actual.getNext();
      indiceActual++;
    }

    // `actual` es el nodo previo donde queremos insertar
    Node nuevo_nodo = new Node(value);
    nuevo_nodo.setNext(nodo_actual.getNext()); // el nuevo apunta al que estaba en esa posición
    nodo_actual.setNext(nuevo_nodo);           // el anterior ahora apunta al nuevo
  }

  
  //Elimina el primer nodo que tenga el valor indicado. Si el valor no existe, la lista queda igual.
  public void eliminarPorValor(int value) {
    
    if (head == null) return; // Lista vacía: no hay nada que eliminar
    

    if (head.getValue() == value) { // Caso especial: el valor está en la cabeza
      head = head.getNext(); // "saltamos" el primer nodo
      return;
    }

    // Recorremos buscando el nodo ANTERIOR al que tiene el valor
    Node actual = head;
    while (actual.getNext() != null && actual.getNext().getValue() != value) {
      actual = actual.getNext();
    }

    // Si encontramos el valor, saltamos el nodo que lo contiene
    if (actual.getNext() != null) {
      actual.setNext(actual.getNext().getNext());
    }
  }

 
  //Elimina el nodo que está en la posición indicada.
  // - posición 0  -> elimina la cabeza
  // - otra posición -> elimina en medio/final
  // Si la posición es inválida se lanza excepción.
  public void eliminarEnPosicion(int posicion) {
    if (posicion < 0 || posicion >= size()) throw new IndexOutOfBoundsException("Posición inválida: " + posicion);
    // Caso especial: eliminar la cabeza
    if (posicion == 0) {
      head = head.getNext();
      return;
    }

    // Recorremos hasta el nodo ANTERIOR al que queremos eliminar
    int indiceActual = 0;
    Node actual = head;
    while (indiceActual < posicion - 1) {
      actual = actual.getNext();
      indiceActual++;
    }

    // Saltamos el nodo en la posición indicada
    if (actual.getNext() != null) {
      actual.setNext(actual.getNext().getNext());
    }
  }

  
  
  //Elimina todos los elementos de la lista. Simplemente quitamos la referencia a la cabeza.
  public void limpiar() {
    head = null;
  }

  //Devuelve true si la lista contiene el valor indicado.
  public boolean contiene(int value) {
    return buscar(value) != -1;
  }

  //Busca la primera ocurrencia de un valor y devuelve su posición. 
  // Si no se encuentra, devuelve -1.
  public int buscar(int value) {
    int posicion = 0;
    Node actual = head;

    while (actual != null) {
      if (actual.getValue() == value) {
        return posicion;
      }
      actual = actual.getNext();
      posicion++;
    }

    return -1; // valor no encontrado
  }

  //Devuelve el valor almacenado en la posición indicada. 
  // Si la posición es inválida, se lanza excepción.
  public int obtenerEnPosicion(int posicion) {
    if (posicion < 0 || posicion >= size())  throw new IndexOutOfBoundsException("Posición inválida: " + posicion);

    int indiceActual = 0;
    Node actual = head;

    while (indiceActual < posicion) {
      actual = actual.getNext();
      indiceActual++;
    }

    return actual.getValue();
  }


  public void imprimir() {
    System.out.print("[");

    Node actual = head;
    while (actual != null) {
      System.out.print(actual.getValue());

      // Si NO es el último, imprimimos la flecha
      if (actual.getNext() != null) {
        System.out.print(" -> ");
      }

      actual = actual.getNext();
    }

    System.out.println("]");
  }
}
