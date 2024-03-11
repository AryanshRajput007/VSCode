package Java;

public class Question279 {
    public static void main(String[] args) {
        int a = 12;
        int[] squares = new int[(int)Math.sqrt(a) + 10]; // Specify the size of the array
        int i = 0;
        int leftover = a;
        while(leftover >= 1) { // Corrected loop condition
            leftover = (int)(Math.sqrt(leftover));
            squares[i] = leftover;
            i++;
        }
    }
}
