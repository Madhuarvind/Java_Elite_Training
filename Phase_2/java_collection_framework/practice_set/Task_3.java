package Phase_2.java_collection_framework.practice_set;
import java.util.*;
public class Task_3 {
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    LinkedHashSet<Integer> set=new LinkedHashSet<>();
    System.out.print("Enter the number of Student:");
    int num=sc.nextInt();
    sc.nextLine();
    for(int i=0;i<num;i++){
        System.out.print("Enter the roll number "+(i+1)+":");
        int nums=sc.nextInt();
        set.add(nums);
    }
    System.out.print("Hash set:"+set);
  }  
}


