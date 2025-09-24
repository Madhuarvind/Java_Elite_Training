package String;
import java.util.*;
public class string {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string 1:");
        String string1=sc.nextLine();
        System.out.println("Enter the string 2:");
        String string2=sc.nextLine();
        System.out.println("The value of string1 is:"+string1);
        System.out.println("The value of string2 is:"+string2);
        System.out.println("Hashcode of string1:"+string1.hashCode());
        System.out.println("Hashcode of string2:"+string2.hashCode());
        System.out.println("Equal:"+string1.equals(string2));
        System.out.println("Equals Ignore Cases:"+string1.equalsIgnoreCase(string2));
        System.out.println("Length of string1:"+string1.length());
        System.out.println("Length of string2:"+string2.length());
        System.out.println("CharAt:"+string1.charAt(2));
        System.out.println("Upper case:"+string1.toUpperCase());
        System.out.println("Lower case:"+string1.toLowerCase());
        System.out.println("Starts with H:"+string1.startsWith("H"));
        System.out.println("Ends with ld:"+string1.endsWith("ld"));
        System.out.println("Replace:"+string1.replace("Hello","Hi"));
        System.out.println("Substring:"+string1.substring(0, 5));
        System.out.println("Empty:"+string2.isEmpty());
        System.out.println("Index:"+string1.indexOf("H"));
    }
}

