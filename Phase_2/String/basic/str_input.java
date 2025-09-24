package String.basic;
import java.util.Scanner;
public class str_input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name:");
        String name=sc.next();
        System.out.println("Your name is: "+name);    
    }
}

