package Problemas.Grafos;

public class Condicion {

    public static boolean esValido(String cadena) {
        int contador0 = 0;
        int contador1 = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (c == '0') {
                contador0++;
            } else if (c == '1') {
                contador1++;
            } else {
                return false;
            }
        }

        boolean paresDe0 = (contador0 % 2 == 0);
        boolean paresDe1 = (contador1 % 2 == 0);

        return paresDe0 || paresDe1;
    }
}
