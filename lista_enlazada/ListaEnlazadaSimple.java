package lista_enlazada;

import lista_enlazada.models.NodeTransaccion;
import lista_enlazada.models.Transaccion;

//Está compuesta por nodos (`NodeTransaccion`) que guardan: un valor entero y una referencia al siguiente nodo
//Solo conocemos el primer nodo de la lista (`head`).

public class ListaEnlazadaSimple {
  private NodeTransaccion head;

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
    NodeTransaccion actual = head;

    // Recorremos todos los nodos y contamos
    while (actual != null) {
      contador++;
      actual = actual.getNext();
    }

    return contador;
  }


  // Inserta un nuevo elemento al inicio de la lista.
  public void insertarAlInicio(Transaccion transaccion) {
    NodeTransaccion nuevo_nodo = new NodeTransaccion(transaccion);
    nuevo_nodo.setNext(head); // El nuevo nodo apunta al que antes era el primero
    head = nuevo_nodo; // Ahora el nuevo nodo es la cabeza de la lista
  }

  // Inserta un nuevo elemento al final de la lista.
  public void insertarAlFinal(Transaccion transaccion) {
    NodeTransaccion nuevo_nodo = new NodeTransaccion(transaccion);

    // Caso lista vacía: el nuevo nodo es la cabeza
    if (head == null) {
      head = nuevo_nodo;
      return;
    }

    // Recorremos hasta el último nodo (aquel cuyo next es null)
    NodeTransaccion actual = head;
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
  public void insertarEnPosicion(Transaccion transaccion, int posicion) {
    if (posicion < 0 || posicion > size()) throw new IndexOutOfBoundsException("Posición inválida: " + posicion);

    // Insertar al inicio
    if (posicion == 0) {
      insertarAlInicio(transaccion);
      return;
    }

    // Recorremos hasta el nodo ANTERIOR a la posición deseada
    int indiceActual = 0;
    NodeTransaccion nodo_actual = head;
    while (indiceActual < posicion - 1) {
      nodo_actual = nodo_actual.getNext();
      indiceActual++;
    }

    // `actual` es el nodo previo donde queremos insertar
    NodeTransaccion nuevo_nodo = new NodeTransaccion(transaccion);
    nuevo_nodo.setNext(nodo_actual.getNext()); // el nuevo apunta al que estaba en esa posición
    nodo_actual.setNext(nuevo_nodo);           // el anterior ahora apunta al nuevo
  }

  
  //Elimina el primer nodo que tenga el valor indicado. Si el valor no existe, la lista queda igual.
  public void eliminarPorId(Long idTransaccion) {
    
    if (head == null) return; // Lista vacía: no hay nada que eliminar
    

    if (head.getTransaccion().getIdTransaccion() == idTransaccion) { // Caso especial: el valor está en la cabeza
      head = head.getNext(); // "saltamos" el primer nodo
      return;
    }

    // Recorremos buscando el nodo ANTERIOR al que tiene el valor
    NodeTransaccion actual = head;
    while (actual.getNext() != null && actual.getNext().getTransaccion().getIdTransaccion() != idTransaccion) {
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
    NodeTransaccion actual = head;
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
  public boolean contiene(Long idTransaccion) {
    return buscar(idTransaccion) != -1;
  }

  //Busca la primera ocurrencia de un valor y devuelve su posición. 
  // Si no se encuentra, devuelve -1.
  public int buscar(Long idTransaccion) {
    int posicion = 0;
    NodeTransaccion actual = head;

    while (actual != null) {
      if (actual.getTransaccion().getIdTransaccion() == idTransaccion) {
        return posicion;
      }
      actual = actual.getNext();
      posicion++;
    }

    return -1; // valor no encontrado
  }

  //Devuelve el valor almacenado en la posición indicada. 
  // Si la posición es inválida, se lanza excepción.
  public Transaccion obtenerEnPosicion(int posicion) {
    //este if no deberia ir en el menu pare ver si se ejecuta el programa o no
    if (posicion < 0 || posicion >= size()) throw new IndexOutOfBoundsException("Posición inválida: " + posicion);

    int indiceActual = 0;
    NodeTransaccion actual = head;

    while (indiceActual < posicion) {
      actual = actual.getNext();
      indiceActual++;
    }

    return actual.getTransaccion();
  }


  public void imprimir() {
    System.out.print("[");

    NodeTransaccion actual = head;
    while (actual != null) {
      System.out.print(actual.getTransaccion());

      // Si NO es el último, imprimimos la flecha
      if (actual.getNext() != null) {
        System.out.print(" -> ");
      }

      actual = actual.getNext();
    }

    System.out.println("]");
  }

}