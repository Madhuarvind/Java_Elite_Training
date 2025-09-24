package Phase_1.operators;
import java.util.Scanner;
class fare {

    public static void main(String args[]){
        Scanner s1 = new Scanner(System.in);

        int totalfare = 0;

        System.out.println("Enter the No of passengers : ");
        int p = s1.nextInt();

        for (int i=1; i<=p; i++){
            System.out.println("Enter the age of passenger " + i + "is : ");
            int a = s1.nextInt();

            int fare = 0;
            if(a<=5){
                fare = 0;
            } else if (a>=6 && a<=18) {
                fare = 10;
            } else if (a>=19 && a<=60) {
                fare = 20;
            } else if (a>60) {
                fare = 15;
            }

            System.out.println("Amount for your tickect is " + i +" Rs. " + fare);
            totalfare+=fare;
        }
        System.out.println("Total fare is " + totalfare);
    }
}