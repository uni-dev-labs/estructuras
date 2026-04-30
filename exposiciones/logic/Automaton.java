// =======================
// File: Automaton.java
// =======================

package exposiciones.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exposiciones.entities.State;
import exposiciones.entities.Transition;

public class Automaton {

    private Map<State, List<Transition>> afd;

    private State q0;
    private State q1;

    public Automaton() {

        // Create states
        q0 = new State("q0", true);
        q1 = new State("q1", false);

        // Create automaton map
        afd = new HashMap<>();

        afd.put(q0, new ArrayList<>());
        afd.put(q1, new ArrayList<>());

        // q0 transitions
        afd.get(q0).add(new Transition('0', q1));
        afd.get(q0).add(new Transition('1', q0));

        // q1 transitions
        afd.get(q1).add(new Transition('0', q0));
        afd.get(q1).add(new Transition('1', q1));
    }

    public boolean evaluateString(char[] characters) throws Exception {

        // Initial state
        State current = q0;

        // Traverse string
        for (char c : characters) {

            // Get transitions of current state
            List<Transition> transitions = afd.get(current);

            boolean found = false;

            // Search valid transition
            for (Transition transition : transitions) {

                if (transition.getConnection() == c) {

                    // Change state
                    current = transition.getState();

                    found = true;

                    break;
                }
            }

            // Invalid character
            if (!found) {

                throw new Exception(
                        "There is a character that does not belong to binary numbers");
            }
        }

        // Return if final state is accepted
        return current.isEnd();
    }
}