package exercises.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppGrafos {
    public static void main(String[] args) throws Exception {

        Map<Estado,List<Transicion>> afd = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        Estado estadoPar = new Estado("estadoPar", true);
        Estado estadoImpar = new Estado("estadoImpar", false);
        
        
        afd.put(estadoPar, new ArrayList<>());
        afd.get(estadoPar).add(new Transicion('0', estadoImpar));
        afd.get(estadoPar).add(new Transicion('1', estadoPar));
        
        afd.put(estadoImpar, new ArrayList<>());
        afd.get(estadoImpar).add(new Transicion('0', estadoPar));
        afd.get(estadoImpar).add(new Transicion('1', estadoImpar));

        char[] numbers = sc.next().toCharArray();
        Estado actual = estadoPar;
        for (char cha : numbers) {
            List<Transicion> trans = afd.get(actual);
            boolean caracterValido =true;
            for (Transicion transicion : trans) {
                if(transicion.getConecxion() == cha){
                    actual= transicion.getEstado();
                    caracterValido =false;
                    break;
                }               
            }
            if (caracterValido) {
                throw new Exception("hay una un caracter que no forma parte de los caracteres de los binarios");
            }

        }
        System.out.println(actual.isEnd());
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