package Phase_2.java_collection_framework.set;
import java.util.*;
public class Hashset {
    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();
        set.add("Mango");
        set.add("Apple");
        set.add("Banana");
        System.out.println("Fruit set:"+set);
        set.remove("Banana");
        System.out.println("After removing:"+set);
        System.out.println("Has Mango?"+set.contains("Mango"));
        System.out.println("All Fruits");
        for(String fruits: set){
            System.out.println(fruits);
        }
    }
}
