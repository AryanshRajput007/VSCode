package Java;

public class Question2529 {
    public static void main(String[] args) {
        int []nums = new int[]{-2,-1,-1,1,2,3};
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                count2++;
            }
            else if(nums[i] > 0) {
                count1++;
            }
        }
        System.out.println(Math.max(count1, count2));
    }
}
