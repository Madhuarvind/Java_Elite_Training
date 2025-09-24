// Write a program to count the vowels and constants in the given string.
package String;
import java.util.*;
public class vowels {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string:");
        String str=sc.nextLine().toLowerCase();
        int vowel=0,constant=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if ("aeiou".indexOf(ch)!=-1){
            System.out.println("Vowels: "+ch);
                vowel++;
            } else{
                System.out.println("constant: "+ch);
                constant++;
            }
        }
        System.out.println("Vowels: "+vowel);
        System.out.println("Constant:"+constant);
    }
}
