package Java;

public class Question1642 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladders = 2;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - nums[i + 1] <= bricks / 2){
                bricks = nums[i] - nums[i + 1];
                count++;
            }
            else if (nums[i] - nums[i + 1] >= bricks / 2 && ladders <= 0)  {
                ladders--;
                count++;
            }
            
        }
    }
}
