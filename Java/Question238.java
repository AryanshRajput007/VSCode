package Java;

public class Question238 {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4};
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        for(int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
