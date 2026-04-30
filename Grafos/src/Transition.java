package Grafos.src;

public class Transition {
    private char conection;
    private State state;

    public char getConection() {
        return conection;
    }

    public void setConection(char conection) {
        this.conection = conection;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Transition(char conection, State state) {
        this.conection = conection;
        this.state = state;
    }

}
