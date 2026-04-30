package Grafos.src;

public class State {

    private String name;
    private boolean end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public State(String name, boolean end) {
        this.name = name;
        this.end = end;
    }
}
