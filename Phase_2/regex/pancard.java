package Phase_2.regex;
import java.util.*;
public class pancard {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Pan number:");
        String aadhar=sc.nextLine().toUpperCase();
        String aadhar_regex="^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
        if(aadhar.matches(aadhar_regex)){
            System.out.println("Valid Pan number");
        } else {
            System.out.println("Invalid Pan number");
        }
    }
}
