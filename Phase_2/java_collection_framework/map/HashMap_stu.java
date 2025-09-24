package Phase_2.java_collection_framework.map;
import java.util.*;
public class HashMap_stu{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,String> Student=new HashMap<>();
        System.out.print("Enter the number of students:");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter the Roll Number "+(i+1)+":");
            Integer roll=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the Student Name "+(i+1)+":");
            String name=sc.nextLine();
            Student.put(roll,name);
        }
        System.out.println("============================");
        System.out.println("Student List(Roll-->Name)");
        for(Map.Entry<Integer,String> entry:Student.entrySet()){
            System.out.println("Roll no : "+entry.getKey()+"  |  Name : "+entry.getValue());
        }
        System.out.println("============================");
        System.out.print("Enter the key to search:");
        int key=sc.nextInt();
        if(Student.containsKey(key)){
            System.out.print("Student Found:"+Student.get(key));
        } else{
            System.out.println("Not found");
        }
        sc.close();
    }
}