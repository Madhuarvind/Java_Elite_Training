package Phase_1.oops.polymorphism;
import java.util.*;
class vehicle{
    void rent(){
        System.out.println("Renting a vehicle");
    }
    int calculaterent(int days){
        return days*0;
    }

    double calculaterent(int days,double discount){
        double total=calculaterent(days);
        return total -(total*discount/100);
    }
}

class car extends vehicle{
    void rent(){
        System.out.println("Renting a car:");
    }

    int calculaterent(int days){
        return days*1200;
    }
}

class bike extends vehicle{
    void rent(){
        System.out.println("Renting a bike:");
    }

     public int calculaterent(int days){
        return days*1000;
    }
}

class truck extends vehicle{
    void rent(){
        System.out.println("Renting a truck:");
    }

        int  calculaterent(int days){
        return days*2500;
    }
}

public class poly {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Select the vehical type:");
        System.out.println("1.Renting a bike");
        System.out.println("2.Renting a bike");
        System.out.println("3.Renting a Truck");
        int choice = sc.nextInt();
        System.out.print("Enter number of days: ");
        int days = sc.nextInt();
        vehicle vh = null;

        switch(choice){
            case 1:
             vh=new car();
             break;
            case 2:
             vh=new bike();
             break;
            case 3:
             vh=new truck();
             break;
            default:
            System.out.println("Invalid choce");
            return;
        }
        vh.rent(); // Calls overridden method
        double totalCost = vh.calculaterent(days);
        System.out.println("Total Rent: ₹" + totalCost);

        // Example of method overloading
        System.out.print("Enter discount percentage: ");
        double discount = sc.nextDouble();
        double discountedCost = vh.calculaterent(days, discount);
        System.out.println("Total Rent after discount: ₹" + discountedCost); 

    }
}
