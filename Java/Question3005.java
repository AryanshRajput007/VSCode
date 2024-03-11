package Java;

// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;

public class Question3005 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,1,4};

        int result = maxFrequency(nums);
        System.out.println(result);
    }

    private static int maxFrequency(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        // System.out.println(maxNum);
        for (int num : nums) {
            if(maxNum < num) {
                maxNum = num;
            }
        }
        // System.out.println(maxNum);

        int[] frequency = new int[maxNum + 1];

        int maxFreq = 0;

        for (int i = 0; i < nums.length; i++) {
            frequency[nums[i]]++;
            maxFreq = Math.max(maxFreq, frequency[nums[i]]);
        }

        // for(int ele : frequency) {
        //     System.out.print(ele + " ");
        // }

        int count = 0;
        for(int val: frequency) {
            if(maxFreq == val) {
                count++;
            }
        }

        // System.out.print(count);

        return count * maxFreq;
    }

    // private static int maxFrequency(int[] nums) {
    //     Map<Integer, Integer> frequencyMap = new HashMap<>();
    //     Set<Integer> set = new HashSet<>();

    //     for (int elem : nums) {
    //         set.add(elem);
    //         frequencyMap.put(elem, frequencyMap.getOrDefault(elem, 0) + 1);
    //     }

    //     System.out.println(frequencyMap);

    //     int maxFrequency = 0;
    //     int count = 0;

    //     for (int frequency : frequencyMap.values()) {
    //         if (frequency > maxFrequency) {
    //             maxFrequency = frequency;
    //             count = 1;
    //         } else if (frequency == maxFrequency) {
    //             count++;
    //         }
    //     }

    //     return maxFrequency * count;
    // }

    
}
