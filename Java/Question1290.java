package Java;

import Structures.LinkedList;
import Structures.StringFunctionality;


public class Question1290 {
    public static void main(String[] args) {
        LinkedList head = new LinkedList();
        head.insertAtBeginning(1);
        head.insertAtEnd(0);
        head.insertAtEnd(1);
        // head.printList();
        // head.delete(20);
        // head.printList();
        int result = binaryListToInt32(head);
        System.out.println(result);
    }

    public static int binaryListToInt32(LinkedList head) {
        String binaryString = head.toString();
        // System.out.println(binaryString);
        StringFunctionality stringFunc = new StringFunctionality();
        String reverse = stringFunc.reverseStringUsingStringBuilder(binaryString);
        System.out.println(reverse);
        int decimal = 0;
        for (int i = 0; i < reverse.length(); i++) {
            char c = reverse.charAt(i);
            int digitValue = c - '0';
            decimal += digitValue * Math.pow(2, i);
        }
        return decimal;
    }
}
