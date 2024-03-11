package Java;

public class Question2540 {

    public static void main(String[] args) {
        int [] nums1 = new int[]{1,2,3};
        int [] nums2 = new int[]{2,3};

        int result = firstCommonElement(nums1, nums2);
        System.out.println(result);
    }

    private static int firstCommonElement(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int common = -1;

        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                common = nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }
}
