package Java;

import Structures.LinkedList;

public class Question141 {
    public static void main(String[] args) {
        LinkedList head = new LinkedList();
        head.insertAtEnd(3);
        head.insertAtEnd(2);
        head.insertAtEnd(0);
        head.insertAtEnd(-4);
        //head.printList();
        boolean result = head.hasCycle();
        System.out.println(result);
    }
}
