package Phase_2.java_collection_framework.stack;
import java.util.*;
public class odd_even {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if((num & 1) == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}
