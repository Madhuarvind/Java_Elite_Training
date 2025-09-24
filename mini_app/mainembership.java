package mini_app;
import java.util.Scanner;

public class mainembership {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char moreCustomer;

        do {
            sc.nextLine(); // Clear buffer
            // 1. Product input
            System.out.print("Enter product name: ");
            String product = sc.nextLine();

            // 2. Amount input
            System.out.print("Enter the amount for " + product + ": ₹");
            double amount = sc.nextDouble();

            // 3. Display membership options
            System.out.println("Select membership type:");
            System.out.println("1. Gold");
            System.out.println("2. Silver");
            System.out.println("3. None");
            System.out.print("Enter your choice (1/2/3): ");
            int membershipChoice = sc.nextInt();

            String membership = "";
            double discountPercent = 0;

            // 4. Logic based on selection
            switch (membershipChoice) {
                case 1:
                    membership = "Gold";
                    if (amount >= 5000) {
                        discountPercent = 20;
                    } else {
                        discountPercent = 15;
                    }
                    break;
                case 2:
                    membership = "Silver";
                    if (amount >= 5000) {
                        discountPercent = 10;
                    } else {
                        discountPercent = 5;
                    }
                    break;
                case 3:
                    membership = "None";
                    discountPercent = 0;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to 'None'");
                    membership = "None";
                    discountPercent = 0;
            }

            // 5. Calculate discount
            double discountAmount = (amount * discountPercent) / 100;
            double finalAmount = amount - discountAmount;

            // 6. Output summary
            System.out.println("\n=== Bill Summary ===");
            System.out.println("Product: " + product);
            System.out.println("Membership Type: " + membership);
            System.out.println("Purchase Amount: ₹" + amount);
            System.out.println("Discount: ₹" + discountAmount + " (" + discountPercent + "%)");
            System.out.println("Final Payable Amount: ₹" + finalAmount);

            // 7. Continue?
            System.out.print("\nDo you want to process another customer? (Y/N): ");
            moreCustomer = sc.next().charAt(0);
            

        } while (moreCustomer == 'Y' || moreCustomer == 'y');

        System.out.println("Thank you for using the system!");
        sc.close();
    }
}

