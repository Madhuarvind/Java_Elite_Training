
package Phase_2.java_collection_framework.list;
import java.util.*;
public class LinkedList {
    public static void main(String[] args) {
        java.util.LinkedList<String> fruits = new java.util.LinkedList<>();
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple");   // duplicate allowed
        fruits.add("Orange");
        fruits.add("Banana");

        System.out.println("Fruits: " + fruits);

        // Accessing element by index
        System.out.println("Second fruit: " + fruits.get(2));

        // Removing element
        fruits.remove("Mango");
        System.out.println("After remove: " + fruits);

        // Size of the list
        System.out.println("Fruits size: " + fruits.size());

        // Iterating
        System.out.println("All fruits:");
        for (String fr : fruits) {
            System.out.println(fr);
        }

        // Extra LinkedList-specific methods
        fruits.addFirst("Grapes");
        fruits.addLast("Pineapple");
        System.out.println("After adding first & last: " + fruits);

        fruits.removeFirst();
        fruits.removeLast();
        System.out.println("After removing first & last: " + fruits);
    }
}
