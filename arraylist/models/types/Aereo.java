package arraylist.models.types;

import arraylist.models.Transporte;

public class Aereo extends Transporte {
    private double envergadura;
    private int altura_max;

    public Aereo() {}

    public Aereo(String nombre, String medio, int capacidad, double envergadura, int altura_max) {
        super(nombre, medio, capacidad);
        this.envergadura = envergadura;
        this.altura_max = altura_max;
    }

    public double getEnvergadura() {
        return envergadura;
    }
    public int getAltura_max() {
        return altura_max;
    }
    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }
    public void setAltura_max(int altura_max) {
        this.altura_max = altura_max;
    }
}
