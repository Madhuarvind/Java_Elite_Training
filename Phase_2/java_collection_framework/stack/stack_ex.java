package Phase_2.java_collection_framework.stack;
import java.util.*;
public class stack_ex {
    public static void main(String[] args) {
        Stack<Integer> obj = new Stack<>();
        obj.push(58);
        obj.push(34);
        obj.push(33);
        obj.push(67);
        obj.push(27);
        obj.add(0, 15);
        obj.add(4, 84);
        
        System.out.println("The original stack is:" + obj);
        System.out.print("The top element :" + obj.peek());
        obj.pop();
        System.out.println("The last element after the pop:" + obj.peek());
        System.out.println(obj);
        obj.remove(0);
        System.out.println("The stack after removing:" + obj);
        System.out.println("The first element:" + obj.firstElement());
        System.out.println("The last element:" + obj.lastElement());
        System.out.println("The size is:" + obj.size());
        
        System.out.println("\nIterating using enhanced for-loop:");
        for (Integer it : obj) {
            System.out.print(it + " ");
        }

        System.out.println("\n\nIterating using Iterator:");
        Iterator<Integer> iterator = obj.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}