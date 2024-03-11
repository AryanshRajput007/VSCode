package Java;

import java.util.Arrays;

public class Question2971 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,12,1,2,5,50,3};
        Arrays.sort(nums);
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            sum -= nums[i];
            if (sum > nums[i]) {
                System.out.println(sum + nums[i]);
                break;
            }
        }
    }
}
