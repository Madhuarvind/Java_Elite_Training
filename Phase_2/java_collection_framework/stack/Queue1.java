package Phase_2.java_collection_framework.stack;
import java.util.*;
public class Queue1 {
    public static void main(String[] args) {
        // Queue obj=new Queue();
        // Linked list need to implemented to achive the Queue 
        Queue obj=new LinkedList();
        //Queue obj=new Queue();
        obj.add(23);
        obj.add(23);
        obj.add(23);
        obj.add(23);
        obj.add(23);
        obj.add(23);

        Object [] arr=obj.toArray();
        int len=obj.size();
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
        }
    }
}
