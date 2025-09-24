package Phase_1.operators;
public class swap_num_using_xor {
    public static void main(String[] args) {
        int x = 4, y = 2;

        // Print original values
        System.out.println("Before swapping: x = " + x + ", y = " + y);

        // Swap using XOR
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        // Print swapped values
        System.out.println("After swapping: x = " + x + ", y = " + y);
    }
}
