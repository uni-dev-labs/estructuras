package exposiciones.grafos;

import java.util.HashMap;
import java.util.Map;

public class AFP {
    static class Estado {
        String nombre;
        Map<Character, Estado> transiciones;

        public Estado(String nombre) {
            this.nombre = nombre;
            this.transiciones = new HashMap<>();
        }

        public void agregarTransicion(char simbolo, Estado destino) {
            transiciones.put(simbolo, destino);
        }

        public Estado mover(char simbolo) {
            return transiciones.get(simbolo);
        }
    }
}
