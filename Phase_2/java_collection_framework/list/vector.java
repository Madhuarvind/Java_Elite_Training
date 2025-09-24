package Phase_2.java_collection_framework.list;
import java.util.*;
public class vector {
    public static void main(String[] args){
        Vector<String> fruits=new Vector<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        System.out.println("Fruits:"+fruits);
        System.out.println(" Second fruit:"+fruits.get(2));
        fruits.remove("Mango");
        System.out.println("After remove:"+fruits);
        System.out.println("Fruits size:"+fruits.size());
        System.out.println("All fruits");
        for(String fr:fruits){
            System.out.println(fr);
        }
    }
}
