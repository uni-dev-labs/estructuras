
public class Automatic {

    Estado estadoInicial;

    public Automatic(Estado estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public boolean validarCadena(String cadena) {
        Estado actual = estadoInicial;

        for (char c : cadena.toCharArray()) {

            if (c != '0' && c != '1') {
                System.out.println("Símbolo inválido: " + c);
                return false;
            }

            actual = actual.siguienteEstado(c);

            if (actual == null) {
                return false;
            }
        }

        return actual.esFinal;
    }
}
