package Java;

public class Question1929 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,1};
        int[] result = new int[2 * nums.length];
        
        // Copy elements from nums to result
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        
        // Populate the second half of result with elements from nums in reverse order
        for (int i = nums.length, j = 0; i < result.length; i++, j++) {
            result[i] = nums[j];
        }
        
        // Printing the result array to verify
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
