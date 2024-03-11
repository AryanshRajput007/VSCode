package Java;

public class Question88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        int n = 3;
        int m = 3;
        int k = m + n;
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            if(n > 0 && m > 0) {
                if(nums1[n - 1] < nums2[m - 1]) {
                    result[i] = nums1[n - 1];
                    n--;
                }
                else {
                    result[i] = nums2[m - 1];
                    m--;
                }
            }
            else if(m > 0) {
                result[i] = nums2[m - 1];
                m--;
            }
            else if(n > 0) {
                result[i] = nums1[n - 1];
                n--;
            }
        }
        // int temp  = 0;
        // for(int i = 0; i < result.length; i++) {
        //     for(int j = i + 1; j < result.length; j++) {
        //         if(result[i] > result[j]) {
        //             temp = result[i];
        //             result[i] = result[j];
        //             result[j] = temp;
        //         }
        //     }
        // }
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
