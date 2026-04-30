package exposiciones.ejercicio1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        
        System.out.println("===== ARBOL BINARIO=====");
        System.out.println("¿Cuantos valores deseas ingresar?");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Ingresar valor " + (i+1) + ": ");
            int valor = sc.nextInt();
            arbol.insertar(valor);
        }
        //mostrar recorridos
        System.out.println("\nRecorrido Preorden: ");
        arbol.preorden(arbol.raiz);
        System.out.println("\nRecorrido Inorden");
        arbol.inorden(arbol.raiz);
        System.out.println("\nRecorrido Postorden");
        arbol.postorden(arbol.raiz);
        sc.close();
    }
}
