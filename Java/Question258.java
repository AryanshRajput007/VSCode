package Java;

public class Question258 {
    public static void main(String[] args) {
        int n = 39;
        int result = 0;
        while(n > 9) {
            String a = String.valueOf(n); 
            result = 0;
            for(int i = 0; i < a.length(); i++) {
                result += Character.getNumericValue(a.charAt(i));
            }
            n = result;
        }
        System.out.println(result);
    }
}
