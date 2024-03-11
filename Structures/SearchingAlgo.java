package Structures;

public class SearchingAlgo {
    public int binarySearchFromEnd(int[] arr, int target) {
        // Reverse the array
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }
        
        int left = 0;
        int right = reversedArray.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reversedArray[mid] == target) {
                // Adjust the index to reflect the position from the end of the original array
                return arr.length - 1 - mid;
            } else if (reversedArray[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1; // Element not found
    }
}
