package Phase_2.java_collection_framework.practice_list;
import java.util.*;
public class Linkedlist_book {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        LinkedList<String> book=new LinkedList<>();
        System.out.print("Enter the number of book :");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter the book name "+(i+1)+": ");
            String name=sc.nextLine();
            book.add(name);
        }

        System.out.print("All book name :");
        for(String bk:book){
            System.out.println(bk);
        }
        System.out.print("Enter the name to check :");
        String search=sc.nextLine();
        System.out.println("Book found :"+book.contains(search));
    }
}
