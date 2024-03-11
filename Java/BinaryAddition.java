package Java;

public class BinaryAddition {
    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        int length_a = a.length() - 1;
        int length_b = b.length() - 1;
        int int_a = 0, int_b = 0;

        // Convert string a to integer int_a
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            int_a += Character.getNumericValue(x) * Math.pow(2, length_a);
            length_a--;
        }

        // Convert string b to integer int_b
        for (int i = 0; i < b.length(); i++) {
            char x = b.charAt(i);
            int_b += Character.getNumericValue(x) * Math.pow(2, length_b);
            length_b--;
        }

        // Add int_a and int_b
        int sum = int_a + int_b;

        // Convert sum to binary string
        StringBuilder binarySum = new StringBuilder();
        while (sum > 0) {
            int remainder = sum % 2;
            binarySum.insert(0, remainder); // Insert remainder at the beginning of the string
            sum /= 2;
        }

        if (binarySum.length() == 0) {
            binarySum.append("0"); // If sum is 0, binary representation is "0"
        }

        System.out.println("Binary sum: " + binarySum);
    }
}
