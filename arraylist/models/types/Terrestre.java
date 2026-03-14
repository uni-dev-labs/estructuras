package arraylist.models.types;

import arraylist.models.Transporte;

public class Terrestre extends Transporte {

    private int numero_ruedas;
    private String tipo;

    public Terrestre(){}

    public Terrestre(String nombre, String medio, String tipo, int capacidad, int numero_ruedas) {
        super(nombre, medio, capacidad);
        this.tipo = tipo;
        this.numero_ruedas = numero_ruedas;
    }

    public int getNumero_ruedas() {
        return numero_ruedas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNumero_ruedas(int numero_ruedas) {
        this.numero_ruedas = numero_ruedas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +  " Tipo: " + tipo + " Ruedas: " + numero_ruedas;
    }
}