  package lista_enlazada.models;
  
  import java.util.LinkedList;
  import java.util.Scanner;  
  import arraylist.models.types.Aereo;
  import arraylist.models.types.Maritimo;
  import arraylist.models.types.Terrestre;
  
  public class Menu {
  
      public static void iniciarMenu(
              LinkedList<Terrestre> terrestres,
              LinkedList<Maritimo> maritimos,
              LinkedList<Aereo> aereos) {
   
          Scanner sc = new Scanner(System.in);
          int opcion;
   
          do {
  
              System.out.println("\n====== MENU CRUD TRANSPORTES ======");
              System.out.println("1. Agregar transporte");
              System.out.println("2. Mostrar transportes");
              System.out.println("3. Actualizar transporte");
              System.out.println("4. Eliminar transporte");
              System.out.println("5. Salir");
               System.out.print("Seleccione una opcion: ");
              opcion = sc.nextInt();
  
              switch (opcion) {
   
                  // ================= CREATE =================
                  case 1:
  
                      System.out.println("\nTipo de transporte:");
                      System.out.println("1. Terrestre");
                      System.out.println("2. Maritimo");
                      System.out.println("3. Aereo");
  
                      int tipo = sc.nextInt();
                      sc.nextLine();
  
                      System.out.print("Nombre: ");
                      String nombre = sc.nextLine();
  
                      System.out.print("Capacidad: ");
                      int capacidad = sc.nextInt();
  
                      if (tipo == 1) {
  
                          System.out.print("Numero de ruedas: ");
                           int ruedas = sc.nextInt();
  
                          terrestres.add(
                                   new Terrestre(nombre, "Terrestre", "carretera", capacidad, ruedas));
   
                      } else if (tipo == 2) {
  
                          System.out.print("Peso maximo: ");
                          int peso = sc.nextInt();
  
                          maritimos.add(
                                  new Maritimo(nombre, "Maritimo", peso, capacidad, 10));
  
                      } else if (tipo == 3) {
  
                          System.out.print("Altitud maxima: ");
                          int altitud = sc.nextInt();
  
                          aereos.add(
                                  new Aereo(nombre, "Aereo", altitud, capacidad, 2));
                      }
  
                      System.out.println("Transporte agregado correctamente");
                      break;
  
                  // ================= READ =================
                  case 2:
  
                      System.out.println("\n--- TRANSPORTES TERRESTRES ---");
                       for (int i = 0; i < terrestres.size(); i++) {
                          System.out.println(i + " - " + terrestres.get(i).getNombre());
                      }
  
                      System.out.println("\n--- TRANSPORTES MARITIMOS ---");
                      for (int i = 0; i < maritimos.size(); i++) {
                          System.out.println(i + " - " + maritimos.get(i).getNombre());
                      }
  
                      System.out.println("\n--- TRANSPORTES AEREOS ---");
                      for (int i = 0; i < aereos.size(); i++) {
                          System.out.println(i + " - " + aereos.get(i).getNombre());
                      }
  
                      break;
  
                  // ================= UPDATE =================
                  case 3:
  
                      System.out.println("\nTipo de transporte a actualizar:");
                      System.out.println("1. Terrestre");
                      System.out.println("2. Maritimo");
                      System.out.println("3. Aereo");
  
                      int tipoU = sc.nextInt();
                      sc.nextLine();
  
                      System.out.print("Posicion: ");
                      int pos = sc.nextInt();
                      sc.nextLine();
  
                      System.out.print("Nuevo nombre: ");
                      String nuevoNombre = sc.nextLine();
   
                      System.out.print("Nueva capacidad: ");
                      int nuevaCap = sc.nextInt();
  
                      if (tipoU == 1) {
  
                          System.out.print("Numero de ruedas: ");
                          int ruedas = sc.nextInt();
  
                            terrestres.set(pos,
                                  new Terrestre(nuevoNombre, "Terrestre", "carretera", nuevaCap, ruedas));
  
                      } else if (tipoU == 2) {
  
                          System.out.print("Peso maximo: ");
                          int peso = sc.nextInt();
  
                          maritimos.set(pos,
                                  new Maritimo(nuevoNombre, "Maritimo", peso, nuevaCap, 10));
  
                      } else if (tipoU == 3) {
  
                          System.out.print("Altitud maxima: ");
                          int altitud = sc.nextInt();
  
                          aereos.set(pos,
                                  new Aereo(nuevoNombre, "Aereo", altitud, nuevaCap, 2));
                      }
  
                      System.out.println("Transporte actualizado");
                      break;
  
                  // ================= DELETE =================
                  case 4:
  
                      System.out.println("\nTipo de transporte a eliminar:");
                      System.out.println("1. Terrestre");
                      System.out.println("2. Maritimo");
                      System.out.println("3. Aereo");
  
                      int tipoD = sc.nextInt();
  
                      System.out.print("Posicion: ");
                      int eliminar = sc.nextInt();
  
                      if (tipoD == 1) {
                          terrestres.remove(eliminar);
                      } else if (tipoD == 2) {
                          maritimos.remove(eliminar);
                      } else if (tipoD == 3) {
                          aereos.remove(eliminar);
                      }
  
                      System.out.println("Transporte eliminado");
                      break;
  
                  case 5:
                      System.out.println("Saliendo del sistema...");
                      break;
  
                  default:
                       System.out.println("Opcion invalida");
              }
   
          } while (opcion != 5);
       }
  }
