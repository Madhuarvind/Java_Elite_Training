package mini_app;
import java.util.Scanner;
public class bank {
        double balance=0;
        int userchoice;
        double DepositeAmount,WithdrawAmount;

        public void deposite(double amount){
            if(amount>0){
                balance+=amount;
                System.out.println("Deposited"+amount+ "successfully");
            }
            else{
                System.out.println("Invalid amount");
            }
        }

        public void withdraw(double amount){
            if(amount>0 && amount<+balance){
                balance-=amount;
            }
            else{
                System.out.println("Insufficient amount to withdraw");
            }
        }

        public void checkBalance(){
            System.out.println("Your balance is"+balance);
        }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        bank account=new bank();
        int userchoice;
        do{
        System.out.println(" Welcome to Banking System:");
        System.out.println("1.Deposite");
        System.out.println("2.Withdraw");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit");
        System.out.println("Enter your choice");
        userchoice=sc.nextInt();
        switch(userchoice){
            case 1:
                System.out.println("Enter the amount to deposite:");
                double DepositeAmount=sc.nextDouble();
                account.deposite(DepositeAmount);
                break;
            case 2:
                System.out.println("Enter the amount to withdraw:");
                double WithdrawAmount=sc.nextDouble();
                account.deposite(WithdrawAmount);
                break;

            case 3:
                account.checkBalance();
                break;
            
            case 4:
                System.out.println("Thank you, Exiting");
                break;

            default:
             System.out.println("Invalid choice");
            }
        }while(userchoice !=4);
            sc.close();
        }
    }
