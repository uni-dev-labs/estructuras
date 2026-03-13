package arraylist;

import java.util.ArrayList;

public class MainString {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Juan");
        names.add("Maria");
        names.add("Pedro");
        names.add("Ana");
        names.add("Juan");
        names.add("Maria");

        
        System.out.println("ArrayList: " + names);

        names.remove(4);
        System.out.println("ArrayList: " + names);
        
        System.out.println("Size 1: " + names.size());

        names.set(2, "manuel");
        System.out.println("ArrayList 2: " + names);

        System.out.println("Size: 2: " + names.size());

        names.clear();
        System.out.println("ArrayList 3: " + names);
    }
}
