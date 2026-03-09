package arraylist.models;

public class Transporte {
    private String nombre;
    private String medio;
    private int capacidad;
    
    public Transporte() {}

    public Transporte(String nombre, String medio, int capacidad) {
        this.nombre = nombre;
        this.medio = medio;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }
    public String getMedio() {
        return medio;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMedio(String medio) {
        this.medio = medio;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
