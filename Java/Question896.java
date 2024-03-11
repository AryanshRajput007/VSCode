package Java;

public class Question896 {

    public static Boolean isIncreasing(int [] nums) {
        Boolean result = true;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] <= nums[i + 1]) {
                continue;
            }
            else {
                result = false;
                return result;
            }
        }
        return result;
    }

    public static Boolean isDecreasing(int [] nums) {
        Boolean result = true;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] >= nums[i + 1]) {
                continue;
            }
            else {
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,3,2};
        boolean increasing = isIncreasing(nums);
        boolean decreasing = isDecreasing(nums);
        if(increasing || decreasing ) {
            System.out.println("True");
        } 
        else {
            System.out.println("False");
        }
    }
}
