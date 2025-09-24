package Phase_1.operators;
import java.util.Scanner;
public class age {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your age:");
        int age=sc.nextInt();
        System.out.println("Your age is:"+age);

        System.out.print("Enter your name:");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Your name is:"+name);

        System.out.print("Enter your weight:");
        float weight=sc.nextFloat();
        System.out.println("Your weight is:"+weight);

        System.out.print("Enter your height:");
        float height=sc.nextFloat();
        System.out.println("Your height is:"+height);

        float mark1=92;
        float mark2=98;
        float mark3=99;
        float total=mark1+mark2+mark3;
        System.out.print("Total mark is :"+total);

        int num1=15;
        int num2=12;

        int sum=num1+num2;
        System.out.println("Sum is :"+sum);
        
                System.out.println(num1=num2);
    }
}
