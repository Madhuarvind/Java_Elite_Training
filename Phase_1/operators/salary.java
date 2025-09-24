package Phase_1.operators;
import java.util.Scanner;
class Main{
    public static void main(String[]args){
        int a;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter a int value:");
        a=s.nextInt();
        
        if (a>90){
            System.out.println("A grade");
        }
        else if(a>=75){
            System.out.println("B grade");
        }
        else if(a>=50){
            System.out.println("c grade");
        }
        else{
            System.out.println("F grade");
        }
        
    }
}