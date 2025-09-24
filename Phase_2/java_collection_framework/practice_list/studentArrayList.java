package Phase_2.java_collection_framework.practice_list;
import java.util.*;
public class studentArrayList {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> Student=new ArrayList<>();
        System.out.print("Enter the value of n :");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
        System.out.print("Enter your name "+(i+1)+":");
        String name=sc.nextLine();
        Student.add(name);
        }
        System.out.println("--------------------------------");
        System.out.println("All Student List Original");
        System.out.println("Student:"+Student);
        Collections.reverse(Student);
        System.out.println("--------------------------------");
        System.out.println("All Student List after reversed");
        System.out.println("Student:"+Student);
        System.out.println("--------------------------------");
    }
}
