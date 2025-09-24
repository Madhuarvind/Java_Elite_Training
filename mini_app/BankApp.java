package mini_app;
import java.util.Scanner;

// Base Class
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class AccountHolder extends Person {
    String accNumber;
    double balance;

    AccountHolder(String name, int age, String accNumber, double balance) {
        super(name, age);
        this.accNumber = accNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void displayAccount() {
        super.displayPerson();
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: " + balance);
    }
}


class SavingsAccount extends AccountHolder {
    double interestRate;

    SavingsAccount(String name, int age, String accNumber, double balance, double interestRate) {
        super(name, age, accNumber, balance);
        this.interestRate = interestRate;
    }

    void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest Earned: " + interest);
        balance += interest;
    }

    @Override
    void displayAccount() {
        System.out.println("----- Savings Account Details -----");
        super.displayAccount();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends AccountHolder {
    double overdraftLimit;

    CurrentAccount(String name, int age, String accNumber, double balance, double overdraftLimit) {
        super(name, age, accNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
        }
    }

    @Override
    void displayAccount() {
        System.out.println("----- Current Account Details -----");
        super.displayAccount();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Account Type:\n1. Savings Account\n2. Current Account");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Account Number: ");
        String accNumber = sc.next();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (choice == 1) {
            System.out.print("Enter Interest Rate: ");
            double rate = sc.nextDouble();
            SavingsAccount sa = new SavingsAccount(name, age, accNumber, balance, rate);
            sa.displayAccount();
            sa.calculateInterest();
            sa.deposit(500);
            sa.withdraw(300);
            sa.displayAccount();
        } else if (choice == 2) {
            System.out.print("Enter Overdraft Limit: ");
            double limit = sc.nextDouble();
            CurrentAccount ca = new CurrentAccount(name, age, accNumber, balance, limit);
            ca.displayAccount();
            ca.deposit(1000);
            ca.withdraw(1500);
            ca.displayAccount();
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
