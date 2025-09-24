package Phase_2.java_collection_framework;

import java.util.Iterator;
import java.util.TreeSet;

public class treeset {
    public static void main(String[] args) {
        TreeSet<Integer> obj=new TreeSet<>();
        obj.add(123);
        obj.add(45);
        obj.add(67);
        obj.add(89);
        obj.add(12);
        obj.add(34);
        obj.add(56);
        obj.add(78);
        obj.add(90);
        obj.add(101);

        Iterator<Integer> it=obj.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        /*  Object[] arr=obj.toArray();
        for(Object val : arr){
            System.out.println(val);
        }  */
        System.out.println("First value is :"+obj.first());
        System.out.println("Last value is :"+obj.last());
        System.out.println(obj.ceiling(14));
        System.out.println("Higher value after 100 :"+obj.higher(100));
        System.out.println("Lower value before 100 :"+obj.lower(100));
    }
}
