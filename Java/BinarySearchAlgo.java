package Java;

public class BinarySearchAlgo {

    private static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int pivot = low + (high - low) / 2;
            
            if(nums[pivot] == target) {
                return pivot;
            } else if(nums[pivot] < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9,10};
        int index = binarySearch(nums, 7);
        System.out.println(index);
    }
}
