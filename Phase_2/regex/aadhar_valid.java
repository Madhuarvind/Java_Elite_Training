package Phase_2.regex;
import java.util.*;
public class aadhar_valid{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Aadhar number:");
        String aadhar=sc.nextLine();
        String aadhar_regex="^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
        if(aadhar.matches(aadhar_regex)){
            System.out.println("Valid aadhar numbere");
        } else {
            System.out.println("Invalid aadhar number");
        }
    }
}