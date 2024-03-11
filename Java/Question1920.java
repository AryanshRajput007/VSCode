package Java;

public class Question1920 {
    public static void main(String[] args) {
        int []nums = {5,0,1,2,3,4};
        int []result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
//0,1,2,4,5,3 4,5,0,1,2,3