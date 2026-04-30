package exposiciones.ejercicio1.EjercicioADF;

public class AutomataParCeros {

    private boolean estadoQ0; // true = q0 (par), false = q1 (impar)

    public AutomataParCeros() {
        this.estadoQ0 = true; // estado inicial q0
    }

    public void procesarCadena(String cadena) {

        for (int i = 0; i < cadena.length(); i++) {
            char simbolo = cadena.charAt(i);

            switch (simbolo) {
                case '0':
                    estadoQ0 = !estadoQ0; // cambia de estado
                    break;

                case '1':
                    // no cambia de estado
                    break;

                default:
                    throw new IllegalArgumentException("Carácter inválido: " + simbolo);
            }
        }
    }

    public boolean esValida() {
        return estadoQ0; // true = par de 0
    }
}

