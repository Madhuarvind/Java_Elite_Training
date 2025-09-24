package Phase_2.java_collection_framework.practice_map;
import java.util.*;
public class Task_1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,String> Student=new HashMap<>();
        System.out.print("Enter the number of students:");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter the Student Name "+(i+1)+":");
            String name=sc.nextLine();
            System.out.print("Enter the Student mark "+(i+1)+":");
            String mark=sc.nextLine();
            Student.put(name,mark);
        }
        System.out.println("============================");
        System.out.println("Student List(Roll-->Name)");
        Iterator<Map.Entry<String, String>> iterator = Student.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("Name : " + entry.getKey() + "  |  Mark : " + entry.getValue());
        }
        System.out.println("============================");
    }
}