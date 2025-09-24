package Phase_1.oops;

import java.util.*;
public class simple {
    private double amount;
    private double time;
    private double rate;

    public void setamount(double amount){
        if(amount>0){
            this.amount=amount;
        } 
        else{
            System.out.println("Invalid amount entered");
        }
    }

    public double getamount(){
        return amount;
    }

    public void settime(double time){
        if(time>0){
            this.time=time;
        } 
        else{
            System.out.println("Invalid breath entered");
        }
    }

    public double gettime(){
        return time;
    }

        public void setrate(double rate){
        if(rate>0){
            this.rate=rate;
        } 
        else{
            System.out.println("Invalid breath entered");
        }
    }

        public double getrate(){
        return rate;
    }

        public double SimpleInterst(){
            return amount*time*rate/100;
        }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        simple obj=new simple();

        System.out.print("Enter the amount:");
        double amount=sc.nextInt();
        obj.setamount(amount);

        System.out.print("Enter the time:");
        double time=sc.nextInt();
        obj.settime(time);

        System.out.print("Enter the rate:");
        double rate=sc.nextInt();
        obj.setrate(rate);

        System.out.println("-------------The result is----------------");
        System.out.println("Principal: " + obj.getamount());
        System.out.println("Rate: " + obj.getrate());
        System.out.println("Time: " + obj.gettime());
        System.out.println("Simple Interest: " + obj.SimpleInterst());
        System.out.println("-------------------------------------------");
    }
}
