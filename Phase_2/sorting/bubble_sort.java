package Phase_2.sorting;
import java.util.*;
public class bubble_sort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the array length: ");
        int len=sc.nextInt();
        int arr[]=new int[len];
        System.out.print("Enter the array elements: ");
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
         System.out.print("Original array elements: ");
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }

        //Bubble sort
        int n=arr.length;
        for(int i=n-1;i>=1;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1] = arr[j]^arr[j+1];
                    arr[j] = arr[j]^arr[j+1];
                }
                // a=a+b;
                // b=a-b;
                // a=a-b;

                // a=a*b;
                // b=a/b;
                // a=a/b;

            }
        }
         System.out.print("After sorting array elements: ");
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
