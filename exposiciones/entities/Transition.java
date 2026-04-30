package exposiciones.entities;

public class Transition {

    private char connection;
    private State state;

    public Transition(char connection, State state) {
        this.connection = connection;
        this.state = state;
    }

    public char getConnection() {
        return connection;
    }

    public void setConnection(char connection) {
        this.connection = connection;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
