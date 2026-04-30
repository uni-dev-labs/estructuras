package exposiciones.grafos;

public class App {
    public static void main(String[] args) throws Exception {
        AFP.Estado estado1 = new AFP.Estado("Estado1");
        AFP.Estado estado2 = new AFP.Estado("Estado2");
        AFP.Estado estado3 = new AFP.Estado("Estado3");

        estado1.agregarTransicion('a', estado2);
        estado1.agregarTransicion('b', estado3);
        estado2.agregarTransicion('a', estado1);
        estado2.agregarTransicion('b', estado3);
        estado3.agregarTransicion('a', estado1);
        estado3.agregarTransicion('b', estado2);
        for (char simbolo : new char[]{'a', 'b'}) {
            System.out.println("Desde " + estado1.nombre + " con '" + simbolo + "' va a " + estado1.mover(simbolo).nombre);
            System.out.println("Desde " + estado2.nombre + " con '" + simbolo + "' va a " + estado2.mover(simbolo).nombre);
            System.out.println("Desde " + estado3.nombre + " con '" + simbolo + "' va a " + estado3.mover(simbolo).nombre);
        }
    if (estado1.mover('a') == estado2) {
        System.out.println("La transición de estado1 con 'a' es correcta.");
    } else {
        System.out.println("La transición de estado1 con 'a' es incorrecta.");
    }

}
}