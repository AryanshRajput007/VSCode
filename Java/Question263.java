package Java;

public class Question263 {
    public static void main(String[] args) {
        int n = 6;
        boolean result = true;
        for (int i = 2; i < (int)Math.sqrt(n); i++) {
            if(n % i == 0 && (i != 2 || i != 3 || i !=5)) {
                result = false;
            }
        }
        System.out.println(result);
    }
}
