package ejercicios;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Colas {

    private static Queue<String> cola = new LinkedList<>();
    private static int contadorTurno = 1;

    public static void cargarCola(Scanner sc) {
        System.out.print("Cuantos pacientes desea agregar: ");
        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre del paciente " + (i + 1) + ": ");
            String nombre = sc.next();
            String turno = "Turno-" + contadorTurno + " (" + nombre + ")";
            cola.add(turno);
            contadorTurno++;
        }

        System.out.println("Cola cargada: " + cola);
    }

    public static void agregar(Scanner sc) {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = sc.next();
        String turno = "Turno-" + contadorTurno + " (" + nombre + ")";
        cola.add(turno);
        contadorTurno++;
        System.out.println("Agregado: " + turno);
        System.out.println("Cola actual: " + cola);
    }

    public static void atender() {
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
        } else {
            String atendido = cola.poll();
            System.out.println("Atendiendo a: " + atendido);
            System.out.println("Cola despues de atender: " + cola);
        }
    }

    public static void siguienteTurno() {
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
        } else {
            System.out.println("Siguiente turno: " + cola.peek());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE TURNOS ===");
        cargarCola(sc);

        System.out.println("\n1. Agregar turno");
        System.out.println("2. Atender turno");
        System.out.println("3. Ver siguiente turno");
        System.out.println("0. Salir");

        int opcion = sc.nextInt();

        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    agregar(sc);
                    break;
                case 2:
                    atender();
                    break;
                case 3:
                    siguienteTurno();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            System.out.println("\n1-Agregar | 2-Atender | 3-Siguiente | 0-Salir");
            opcion = sc.nextInt();
        }

        System.out.println("Sistema cerrado.");
        sc.close();
    }
}