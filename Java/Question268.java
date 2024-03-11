package Java;

public class Question268 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 3};
        int n = nums.length;
        int expectedSum = 0;
        int actualSum = 0;
        for(int i = 0; i < n; i++) {
            actualSum += nums[i];
        }
        while(n >= 0) {
            expectedSum += n;
            n--;
        }
        System.out.println(expectedSum - actualSum);
    }
}
