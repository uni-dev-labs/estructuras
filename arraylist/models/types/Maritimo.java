package arraylist.models.types;

import arraylist.models.Transporte;

public class Maritimo extends Transporte{
    
    private double  eslora;
    private int     calado;
    
    public Maritimo() {}
    
    public Maritimo(String nombre, String medio, int capacidad, double eslora, int calado) {
        super(nombre, medio, capacidad);
        this.eslora = eslora;
        this.calado = calado;
    }
    public double getEslora() {
        return eslora;
    }
    public int getCalado() {
        return calado;
    }
    public void setEslora(double eslora) {
        this.eslora = eslora;
    }
    public void setCalado(int calado) {
        this.calado = calado;
    }
}