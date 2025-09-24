package Phase_2.regex;
import java.util.*;
public class regex_digits {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the string value:");
        String str=sc.nextLine();
        System.out.println(str.matches("\\d+"));
        System.out.print("Enter the string2 value:");
        String str2=sc.nextLine();
        System.out.println(str2.matches("[A-Za-z]+"));
        System.out.print("Enter the phone number:");
        String phone=sc.nextLine();
        String phone_regex="^[6-9][0-9]{9}$";
        if(phone.matches(phone_regex)){
            System.out.println("valid mobile number");
        } else {
            System.out.println("Invalid mobile number");
        }


        System.out.print("Enter the email:");
        String email=sc.nextLine();
        String email_regex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if(email.matches(email_regex)){
            System.out.println("valid email id");
        } else {
            System.out.println("Invalid email id");
        }

        System.out.print("Enter the password:");
        String password=sc.nextLine();
        String password_regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*+=-]).{8,}$";

        if(email.matches(password_regex)){
            System.out.println("Strong password");
        } else {
            System.out.println("Password is not strong");
        }
    }
}
