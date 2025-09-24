package Phase_2.java_collection_framework.practice_set;
import java.util.*;
public class Task_2 {
  public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    TreeSet<String> set=new TreeSet<>();
    System.out.print("Enter the number:");
    int num=sc.nextInt();
    sc.nextLine();
    for(int i=0;i<num;i++){
        System.out.print("Enter the word"+(i+1)+":");
        String nums=sc.nextLine();
        set.add(nums);
    }
    System.out.print("Hash set:"+set);
  }  
}


