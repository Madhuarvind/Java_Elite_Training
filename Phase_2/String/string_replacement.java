package String;
import java.util.*;
public class string_replacement {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the string");
    String str=sc.nextLine();
    System.out.println("Enter the word to be replaced");
    String word=sc.nextLine();
    System.out.println("Enter the word to replace with");
    String newword=sc.nextLine();
    String newstr=str.replace(word,newword);
    System.out.println("String after replacement: "+newstr);
    }    
}
