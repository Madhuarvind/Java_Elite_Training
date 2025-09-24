
package mini_app;
import java.util.Scanner;

class Taxi {
    int id;
    boolean isAvailable = true;
    int currentLocation = 0;
    double totalEarnings = 0;

    Taxi(int id) {
        this.id = id;
    }

    void bookTaxi(int pickup, int drop) {
        int distance = Math.abs(drop - pickup);
        double fare = 50 + distance * 10;
        totalEarnings += fare;
        currentLocation = drop;
        isAvailable = false;

        System.out.println("Taxi " + id + " booked from " + pickup + " to " + drop);
        System.out.println("Fare: ₹" + fare);
    }

    void releaseTaxi() {
        isAvailable = true;
        System.out.println("Taxi " + id + " is now available.");
    }

    void showDetails() {
        System.out.println("Taxi ID: " + id +
                           ", Status: " + (isAvailable ? "Available" : "Busy") +
                           ", Location: " + currentLocation +
                           ", Earnings: ₹" + totalEarnings);
    }
}

public class TaxiBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Taxi[] taxis = new Taxi[4];

        for (int i = 0; i < 4; i++) {
            taxis[i] = new Taxi(i + 1);
        }

        int choice;
        do {
            System.out.println("\n🚖 Taxi Booking System Menu:");
            System.out.println("1. Book Taxi");
            System.out.println("2. Release Taxi (Complete Ride)");
            System.out.println("3. Show Taxi Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Pickup Location (1-100): ");
                    int pickup = sc.nextInt();
                    System.out.print("Enter Drop Location (1-100): ");
                    int drop = sc.nextInt();

                    Taxi chosen = null;
                    int minDistance = Integer.MAX_VALUE;

                    for (Taxi taxi : taxis) {
                        if (taxi.isAvailable) {
                            int dist = Math.abs(taxi.currentLocation - pickup);
                            if (dist < minDistance) {
                                minDistance = dist;
                                chosen = taxi;
                            }
                        }
                    }

                    if (chosen != null) {
                        chosen.bookTaxi(pickup, drop);
                    } else {
                        System.out.println("No taxis available right now!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Taxi ID to release: ");
                    int releaseId = sc.nextInt();
                    if (releaseId >= 1 && releaseId <= 4) {
                        taxis[releaseId - 1].releaseTaxi();
                    } else {
                        System.out.println("Invalid Taxi ID!");
                    }
                    break;

                case 3:
                    System.out.println("\n🚖 Taxi Status:");
                    for (Taxi taxi : taxis) {
                        taxi.showDetails();
                    }
                    break;

                case 4:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
