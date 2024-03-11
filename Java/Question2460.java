package Java;

public class Question2460 {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,2,1,1,0};
        int[] result = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                result[count++] = nums[i];
            }
        }
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
