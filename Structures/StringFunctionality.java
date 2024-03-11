package Structures;

public class StringFunctionality {
    // Method to reverse a string using StringBuilder
    public String reverseStringUsingStringBuilder(String str) {
        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse();
        return reversed.toString();
    }

    // Method to reverse a string using Array 
    public String reverseStringUsingArray(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    
    public int[] stringToIntArray(String str) {
        // Create an integer array to store the converted integers
        int[] intArray = new int[str.length()];

        // Convert each character to an integer and store it in the integer array
        for (int i = 0; i < str.length(); i++) {
            intArray[i] = Character.getNumericValue(str.charAt(i));
        }

        return intArray;
    }
}
