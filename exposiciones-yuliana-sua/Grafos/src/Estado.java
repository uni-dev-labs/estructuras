
import java.util.HashMap;
import java.util.Map;

class Estado {

    String nombre;
    boolean esFinal;
    Map<Character, Estado> transiciones;

    public Estado(String nombre, boolean esFinal) {
        this.nombre = nombre;
        this.esFinal = esFinal;
        this.transiciones = new HashMap<>();
    }

    public void agregarTransicion(char simbolo, Estado destino) {
        transiciones.put(simbolo, destino);
    }

    public Estado siguienteEstado(char simbolo) {
        return transiciones.get(simbolo);
    }
}
