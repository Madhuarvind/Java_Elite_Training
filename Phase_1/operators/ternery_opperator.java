package Phase_1.operators;


import java.util.Scanner;
public class ternery_opperator{
    
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first number:");  
        int num1 = scanner.nextInt();
        System.out.println("Enter second number:"); 
        int num2 = scanner.nextInt();
        String result = (num1 >= num2) ? "Number 1 is bigger" : "Number 2 is bigger";
        System.out.println(result);
     scanner.close();
    }
}
