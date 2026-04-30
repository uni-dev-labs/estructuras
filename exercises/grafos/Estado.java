package exercises.grafos;

public class Estado {
    private String caracterValidombre;
    private boolean end;

    public String getcaracterValidombre() {
        return caracterValidombre;
    }

    public void setcaracterValidombre(String caracterValidombre) {
        this.caracterValidombre = caracterValidombre;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Estado(String caracterValidombre, boolean end) {
        this.caracterValidombre = caracterValidombre;
        this.end = end;
    }
}
