package Phase_2.java_collection_framework.list.ArrayList;
import java.util.*;
public class crud {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<String> Student=new ArrayList<>();

        System.out.print("Enter the number of students:");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
        System.out.print("Enter the Student Name "+(i+1)+":");
        String name=sc.nextLine();
        Student.add(name);
        }
        System.out.println("=====================");
        System.out.println("Student List After Create:"+Student);
        System.out.println("=====================");

        System.out.println("Reading all the student:");
        for(int i=0;i<Student.size();i++){
            System.out.println("Student"+(i+1)+":"+Student.get(i));
        }
        System.out.println("=====================");
        System.out.print("Enter the index to update(Starting from 0):");
        int index=sc.nextInt();
        sc.nextLine();
        if(index>=0&& index<Student.size()){
        System.out.print("Enter the new name:");
        String upname=sc.nextLine();  
        Student.set(index, upname);
        } else{
            System.out.println("Invalid index entered");
        }

        System.out.println("=====================");
        System.out.println("Student List After Update :"+Student);
        System.out.println("=====================");

        System.out.print("Enter the index to Remove(Starting from 0):");
        int idx=sc.nextInt();
        sc.nextLine();
        if(idx>=0&& idx<Student.size()){
        Student.remove(idx);
        }else{
            System.out.println("Invalid index entered");
        }

        System.out.println("=====================");
        System.out.println("Student List After Removed :"+Student);
        System.out.println("=====================");
    }
}
