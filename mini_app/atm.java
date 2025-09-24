package mini_app;
import java.util.Scanner;
class atm {
    private double Balance;

    // Constructor
    public atm() {
        Balance = 0.0;
    }

    public void CheckBalance(){
        System.out.println("Your current Balance is:"+Balance);
    }

    public void Deposite(double amount){
        if(amount>0){
            Balance+=amount;
            System.out.println("Deposited"+amount+ "successfully");
            System.out.println("Your current balance after deposite:"+Balance);
        } else {
            System.out.println("Invalid amount");
        }
    }
    public void Withdraw(double amount) {
        if (amount > 0 && amount <= Balance) {
            Balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
            System.out.println("Remaining balance: ₹" + Balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            atm obj= new atm();

            int userchoice;

            final int correctpin=1234;
            int pinattempts=0;
            boolean authen=false;
            while(pinattempts<3){
                System.out.print("Enter your pin:");
                int enteredpin=sc.nextInt();
                    if(enteredpin==correctpin){
                        authen=true;
                        break;
                    } else{
                    pinattempts++;
                        System.out.println("Incorrect pin.Attempts left attempts:"+(3-pinattempts));
                        }
                }
            if(! authen){
                System.out.println("Too many incorrect attempts. Exiting...");
                return;
            }
        do{
        System.out.println("----------- Welcome to ATM---------");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposite");
        System.out.println("3.Withdraw Money");
        System.out.println("4.Exit");
        System.out.println("------------------------------------");
        System.out.println("Enter your choice");
        userchoice=sc.nextInt();
        switch(userchoice){
            case 1:
                obj.CheckBalance();
                break;
            case 2:
                System.out.print("Enter the amount to deposite:");
                double deposite=sc.nextDouble();
                obj.Deposite(deposite);
                break;
            case 3:
                System.out.print("Enter you amount to withdraw:");
                double withdraw=sc.nextDouble();
                obj.Withdraw(withdraw);
                break;
            case 4:
                 System.out.println("Thank you for visiting the atm");
                 break;
            default:
                System.out.print("Invalid choice,Tru again later");
        }
    } while(userchoice !=4);
    sc.close();
    }
}