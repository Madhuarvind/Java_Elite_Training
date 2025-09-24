package String;
import java.util.*;
public class palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s=sc.nextLine();
        String s1=new StringBuilder(s).reverse().toString();
        if(s.equals(s1)){
            System.out.println("palindrome");
        }
        else{
            System.out.println("not palindrome");
        }
    }    
}
