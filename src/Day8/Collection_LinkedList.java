package Day8;

import java.util.LinkedList;

public class Collection_LinkedList {

    public static void main(String[] args) {
        // Create a LinkedList of Double (wrapper class for double)
        LinkedList<Double> marks = new LinkedList<>();

        // Autoboxing: double → Double
        marks.add(85.5);
        marks.add(90.0);
        marks.add(78.25);

        System.out.println("Marks List: " + marks);

        for (Double mark : marks) {
            System.out.println(mark);
        }

    }
}