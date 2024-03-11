package Java;
import Structures.SearchingAlgo;
import Structures.StringFunctionality;

public class Question2864 {
    public static void main(String[] args) {
        String s = "0101";
        SearchingAlgo algo = new SearchingAlgo();
        StringFunctionality f = new StringFunctionality();
        int[] arr = f.stringToIntArray(s);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int index = algo.binarySearchFromEnd(arr, 1);
        System.out.println(index);
    }
}
