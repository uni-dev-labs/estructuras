package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Grafos {
    public static void main(String[] args) throws Exception {
        Estado q0 = new Estado("q0", true);
        Estado q1 = new Estado("q1", false);
        Map<Estado, List<Transicion>> afd = new HashMap<>();
        afd.put(q0, new ArrayList<>());
        afd.put(q1, new ArrayList<>());
        afd.get(q0).add(new Transicion('0', q1));
        afd.get(q0).add(new Transicion('1', q0));
        afd.get(q1).add(new Transicion('0', q0));
        afd.get(q1).add(new Transicion('1', q1));
        Scanner scanner = new Scanner(System.in);
        char[] ch = scanner.next().toCharArray();
        scanner.close();
        Estado actual = q0;
        for (char c : ch) {
            List<Transicion> trans = afd.get(actual);
            boolean no = true;
            for (Transicion p : trans) {
                if (p.getConecxion() == c) {
                    actual = p.getEstado();
                    no = false;
                    break;
                }
            }
            if (no) {
                throw new Exception("hay una un caracter que no forma parte de los caracteres de los binarios");
            }

        }
        System.out.println(actual.isEnd());
    }
}

class Estado {
    private String nombre;
    private boolean end;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Estado(String nombre, boolean end) {
        this.nombre = nombre;
        this.end = end;
    }
}

class Transicion {
    private char conecxion;
    private Estado Estado;

    public char getConecxion() {
        return conecxion;
    }

    public void setConecxion(char conecxion) {
        this.conecxion = conecxion;
    }

    public Estado getEstado() {
        return Estado;
    }

    public void setEstado(Estado estado) {
        Estado = estado;
    }

    public Transicion(char conecxion, Estado estado) {
        this.conecxion = conecxion;
        Estado = estado;
    }

}