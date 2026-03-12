package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

import arraylist.models.Transporte;
import arraylist.models.types.Aereo;
import arraylist.models.types.Maritimo;
import arraylist.models.types.Terrestre;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        ArrayList<Transporte> arrayList = new ArrayList<Transporte>();
        int opt;
        do {
            System.out.println("1.crear transporte");
            System.out.println("2.buscar tranporte");
            System.out.println("3.modificar trannporte");
            System.out.println("4.eliminar");
            opt = Integer.parseInt(scanner.next());
            switch (opt) {
                case 1:
                    System.out.println("crear traporte");
                    Transporte transporte = memu2();
                    arrayList.add(transporte);
                    break;
                case 2:
                    System.out.println("nombre objeto");
                    Transporte transporte2 = Main.obtenerObjetoPorNombre(scanner.next(), arrayList);
                    System.out.println(transporte2);
                    break;
                case 3:
                    System.out.println("nombre objeto");
                    Transporte transporte3 = Main.obtenerObjetoPorNombre(scanner.next(), arrayList);
                    cambio(transporte3);

                    break;
                case 4:
                    System.out.println("nombre del transporte");
                    String name = scanner.next();
                    Transporte transporte4 = Main.obtenerObjetoPorNombre(name, arrayList);
                    arrayList.remove(transporte4);

                    break;
                case 0:
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("invalido");
                    break;
            }
        } while (opt != 0);
        scanner.close();
    }

    public static Transporte memu2() {
        Transporte t;
        System.out.println("1.Aereo");
        System.out.println("2.Maritimo");
        System.out.println("3.Terrestre");
        int x = Integer.parseInt(scanner.next());
        System.out.println("nombre");
        String nombre = scanner.next();
        System.out.println("medio");
        String medio = scanner.next();
        System.out.println("capacidad");
        int capacidad = Integer.parseInt(scanner.next());

        switch (x) {
            case 1:
                System.out.println("altura_max");
                int altura_max = Integer.parseInt(scanner.next());
                System.out.println("envergadura");
                double envergadura = Double.parseDouble(scanner.next());
                t = new Aereo(nombre, medio, capacidad, envergadura, altura_max);
                break;
            case 2:
                System.out.println("eslora");
                double eslora = Double.parseDouble(scanner.next());
                System.out.println("calado");
                int calado = Integer.parseInt(scanner.next());
                t = new Maritimo(nombre, medio, capacidad, eslora, calado);
                break;
            case 3:
                System.out.println("numero ruedas");
                int numero_ruedas = Integer.parseInt(scanner.next());
                System.out.println("tipo");
                String tipo = scanner.next();
                t = new Terrestre(nombre, medio, tipo, capacidad, numero_ruedas);
                break;
            default:
                System.out.println("opcion invalida");
                t = null;
                break;
        }
        return t;
    }

    public static void cambio(Transporte transporte) {
        System.out.println("nombre");
        String nombre = scanner.next();
        System.out.println("medio");
        String medio = scanner.next();
        System.out.println("capacidad");
        int capacidad = Integer.parseInt(scanner.next());
        if (transporte instanceof Aereo aereo) {
            System.out.println("altura max");
            int altura_max = Integer.parseInt(scanner.next());
            System.out.println("envergadura");
            double envergadura = Double.parseDouble(scanner.next());
            aereo.setCapacidad(capacidad);
            aereo.setNombre(nombre);
            aereo.setMedio(medio);
            aereo.setAltura_max(altura_max);
            aereo.setEnvergadura(envergadura);
        } else if (transporte instanceof Maritimo maritimo) {
            System.out.println("eslora");
            double eslora = Double.parseDouble(scanner.next());
            System.out.println("calado");
            int calado = Integer.parseInt(scanner.next());
            maritimo.setNombre(nombre);
            maritimo.setMedio(medio);
            maritimo.setCapacidad(capacidad);
            maritimo.setEslora(eslora);
            maritimo.setCalado(calado);
        } else if (transporte instanceof Terrestre terrestre) {
            System.out.println("numero ruedas");
            int numero_ruedas = Integer.parseInt(scanner.next());
            System.out.println("tipo");
            String tipo = scanner.next();
            terrestre.setNombre(nombre);
            terrestre.setMedio(medio);
            terrestre.setCapacidad(capacidad);
            terrestre.setNumero_ruedas(numero_ruedas);
            terrestre.setTipo(tipo);
        }

    }
}