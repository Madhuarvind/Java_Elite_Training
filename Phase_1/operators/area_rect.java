
package Phase_1.operators;
import java.util.*;
public class area_rect {
    private double length;
    private double breath;

    public void setlength(double len){
        if(len>0){
            this.length=len;
        } 
        else{
            System.out.println("Invalid length entered");
        }
    }

    public double getlength(){
        return length;
    }

    public void setbreath(double bre){
        if(bre>0){
            this.breath=bre;
        } 
        else{
            System.out.println("Invalid breath entered");
        }
    }

    public double getbreath(){
        return breath;
    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        area_rect obj=new area_rect();

        System.out.print("Enter the length:");
        double length=sc.nextInt();
        obj.setlength(length);

        System.out.print("Enter the Breath:");
        double breath=sc.nextInt();
        obj.setbreath(breath);

        System.out.println("The area of Rectangl is:"+obj.getlength()*obj.getbreath());

    }
}
