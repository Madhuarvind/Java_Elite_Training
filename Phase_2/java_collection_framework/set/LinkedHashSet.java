package Phase_2.java_collection_framework.set;
import java.util.*;
public class LinkedHashSet {
    public static void main(String[] args) {
        java.util.LinkedHashSet<String> fruits = new java.util.LinkedHashSet<>();
        // Adding elements (duplicates will be ignored)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple");   // duplicate, ignored
        fruits.add("Orange");
        fruits.add("Banana");  // duplicate, ignored

        System.out.println("Fruits: " + fruits);

        // Check if a fruit exists
        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        System.out.println("Contains Grapes? " + fruits.contains("Grapes"));

        // Removing element
        fruits.remove("Mango");
        System.out.println("After remove: " + fruits);

        // Size of the set
        System.out.println("Fruits size: " + fruits.size());

        // Iterating through elements
        System.out.println("All fruits:");
        for (String fr : fruits) {
            System.out.println(fr);
        }

        // Clearing the set
        fruits.clear();
        System.out.println("After clear: " + fruits);
    }
}
