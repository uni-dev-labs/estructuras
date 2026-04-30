public class Automata {

    private String estado;

    public Automata() {
        this.estado = "PAR";
    }

    public boolean validarCadena(String cadena) {
        estado = "PAR";

        for (int i = 0; i < cadena.length(); i++) {
            char simbolo = cadena.charAt(i);

            if (simbolo != '0' && simbolo != '1') {
                estado = "INVALIDO";
                return false;
            }

            if (simbolo == '0') {
                cambiarEstado();
            }
        }

        return estado.equals("PAR");
    }

    private void cambiarEstado() {
        if (estado.equals("PAR")) {
            estado = "IMPAR";
        } else {
            estado = "PAR";
        }
    }

    public String getEstado() {
        return estado;
    }
}