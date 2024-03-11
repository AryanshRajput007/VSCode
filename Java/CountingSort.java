package Java;

public class CountingSort {

    private static void countingSort(int[] nums) {
        // Find the maximum value in the array
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        // Perform counting sort using the determined maximum value
        int[] count = new int[max + 1];

        // Count frequencies of elements
        for (int num : nums) {
            count[num]++;
        }

        // Modify counts to store actual position of elements in output
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(" " + count[i]);
        }

        int[] output = new int[nums.length];

        // Build the output array
        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[nums[i]] - 1] = nums[i];
            count[nums[i]]--;
        }

        // Copy sorted elements back to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
        
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        countingSort(nums);

        System.out.println("Sorted array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
