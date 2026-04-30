package Grafos.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        State q0 = new State("q0", true);
        State q1 = new State("q1", false);
        Map<State, List<Transition>> afd = new HashMap<>();
        afd.put(q0, new ArrayList<>());
        afd.put(q1, new ArrayList<>());
        afd.get(q0).add(new Transition('0', q1));
        afd.get(q0).add(new Transition('1', q0));
        afd.get(q1).add(new Transition('0', q0));
        afd.get(q1).add(new Transition('1', q1));
        Scanner scanner = new Scanner(System.in);
        char[] ch = scanner.next().toCharArray();
        scanner.close();
        State actual = q0;
        for (char c : ch) {
            List<Transition> trans = afd.get(actual);
            boolean no = true;
            for (Transition p : trans) {
                if (p.getConection() == c) {
                    actual = p.getState();
                    no = false;
                    break;
                }
            }
            if (no) {
                throw new Exception("There is a character that is not in the language");
            }

        }
        System.out.println(actual.isEnd());
    }
}