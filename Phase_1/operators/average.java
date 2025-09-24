package Phase_1.operators;
public class average {
            int num1=12;
            int num2=15;
            float length=100;
            float breath=60;
    double avg(){
        double sum=(double)num1+num2;
        return (sum)/(2);
    }
    float areaofrectangle(){
        float area=length*breath;
        return area;
    }

    public static void main(String[] args){

        average obj2=new average();
        System.out.println(obj2.areaofrectangle());
    }
}


