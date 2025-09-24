package Phase_1.operators;
import java.util.Scanner;

public class maxnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;

        System.out.print("A: ");
        a = sc.nextInt();

        System.out.print("B: ");
        b = sc.nextInt();

        if (a > b) {
            System.out.println("A is Bigger");
        } else if (a < b) {
            System.out.println("B is Bigger");
        } else {
            System.out.println("A and B are Equal");
        }

        sc.close();
    }
}