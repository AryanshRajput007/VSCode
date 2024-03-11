package Java;
import Structures.SortingAlgo;

public class Question977 {
    public static void main(String[] args) {
        int [] nums = new int[]{-4,-1,0,3,10};
        SortingAlgo algo = new SortingAlgo();
        for(int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        algo.mergeSort(nums, 0, nums.length - 1); 
        for( int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
