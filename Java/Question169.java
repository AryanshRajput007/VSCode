package Java;

// import java.util.HashMap;

public class Question169 {
    public static void main(String[] args) {
        int []nums = new int[]{3,2,3};
        int result = 0;
        int count;
        for(int i = 0; i < nums.length; i++) {
            count = 0;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    nums[j]  = -1;
                    count++;
                }
            }
            if(count > 0) {
                nums[i] = -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != -1) {
                result = nums[i];
                break;
            }
        }
        System.out.println(result);
    }
}
