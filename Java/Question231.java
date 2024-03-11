package Java;

public class Question231 {
    public static void main(String[] args) {
        int n = 16;
        boolean con = true;
        while (n > 1) {
            if (n % 2 != 0) {
                con = false;
                break;
            }
            n = n / 2;
        }
        System.out.println(con);
    }
}