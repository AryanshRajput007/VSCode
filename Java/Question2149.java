package Java;

import java.util.LinkedList;
import java.util.Queue;

public class Question2149 {
    public static void main(String[] args) {
        int [] nums = new int[]{3,1,-2,-5,2,-4};
        int [] nums2 = new int[nums.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                queue.offer(nums[i]);
            }
            else if(nums[i] > 0) {
                if(i - 1 >= 0) {
                    if(nums[i - 1] > 0 && i - 1 >= 0) {
                        continue;
                    }
                    else if(nums[i - 1] < 0 && nums[i] > 0) {
                        nums2[count++] = nums[i];
                    }
                    else if(nums[i - 1] > 0 && nums[i] < 0) {
                        nums2[count++] = nums[i];
                    }
                }
                else if(count == 0 && nums[i] > 0) {
                    nums2[count] = nums[i];
                    count++;
                }
            }
        }
        for(int i = 0; i < nums2.length; i++) {
            System.out.println(nums2[i]);
        }
    }
}