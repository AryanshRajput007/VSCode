package Java;

import java.util.ArrayList;
import java.util.List;

public class Question46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Skip if element already exists
                tempList.add(nums[i]);
                backtrack(nums, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        List<List<Integer>> permutations = permute(nums);
        System.out.println("All permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
