// write a program to reverse a each word in the string.
package String;
import java.util.*;
public class reverse_word {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of string:");
        String str=sc.nextLine();
        String[] word=str.split(" ");
        for( String words:word){
            System.out.print(new StringBuilder(words).reverse().toString()+" ");
        }
    }
}
