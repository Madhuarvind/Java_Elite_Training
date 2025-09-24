package Phase_2.java_collection_framework.list;
import java.util.*;
public class arrayList_stu {
    public static void main(String[] args) {
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
        System.out.println("Student List:"+Student);
    }
}
