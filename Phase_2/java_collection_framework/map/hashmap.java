
package Phase_2.java_collection_framework.map;
import java.util.*;
public class hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> mpp=new HashMap<>();
        mpp.put("Mango",160);
        mpp.put("Apple",190);
        mpp.put("Orange",110);
        mpp.put("Banana",60);
        System.out.println("Fruits Mpp:"+mpp);
        System.out.println("The Price of Mango:"+mpp.get("Mango"));
        mpp.remove("Banana");
        System.out.println("After removing the Banana:"+mpp);
        System.out.println("Contains Apple:"+mpp.containsKey("Apple"));
        System.out.println("Contains Price 190:"+mpp.containsValue(190));
        System.out.println("All Fruits");
        for(String key:mpp.keySet()){
            System.out.println(mpp.get(key));
        }
    }
}
