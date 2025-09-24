package String;
import java.util.*;
public class trim_function {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s=sc.nextLine();
        System.out.println("The string value is:"+s);
        String result=s.replaceAll(" ","");
        System.out.println("The string after removing spaces is:"+result);
        String words[]=s.trim().split("\\s+");
        System.out.println("The words after removing spaces are:"+words.length);

    }
}
