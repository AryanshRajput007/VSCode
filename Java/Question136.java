package Java;

import java.util.Arrays;
import java.util.Collections;

public class Question136 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,4,1,1};
        int result = -1;
        Integer[] integerArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        for(int i = 0; i < nums.length; i++) {
            if(Collections.frequency(Arrays.asList(integerArray), nums[i]) == 1) {
                result = nums[i];
            }
        }
        System.out.println(result);
    }
}
