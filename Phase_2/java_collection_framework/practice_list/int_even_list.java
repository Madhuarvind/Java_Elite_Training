package Phase_2.java_collection_framework.practice_list;
import java.util.*;
public class int_even_list {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> it=new ArrayList<>();
        it.add(12);
        it.add(34);
        it.add(65);
        it.add(82);
        it.add(87);
        it.add(11);
        it.add(32);
        it.add(29);
        it.add(24);
        it.add(21);

        System.out.println("The integer values are :"+it);
        it.removeIf(num -> num % 2 == 0);
        System.out.println("The integer values After removing even numbers :"+it);
    }
}