package Java;

public class Question48 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][] result = new int[nums.length][nums[0].length];
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                result[j][i] = nums[i][j];
            }
        }
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}
