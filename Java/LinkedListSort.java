package Java;

class SortNode {
    int data;
    SortNode next;

    public SortNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SortLinkedList {

    public SortNode insertAtEnd(SortNode head, int data) {
        SortNode newnode = new SortNode(data);
        if(head == null) {
            head = newnode;
            return head;
        }

        SortNode current = head;

        while(current.next != null) {
            current = current.next;
        }
        current.next = newnode;
        return head;
    }

    public SortNode merge(SortNode left, SortNode right) {
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }

        SortNode result = null;

        if(left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    public SortNode mergeSort(SortNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        SortNode middle = getMiddle(head);
        SortNode nextOfMiddle = middle.next;
        middle.next = null;

        SortNode left = mergeSort(head);
        SortNode right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private SortNode getMiddle(SortNode head) {
        if(head == null) {
            return head;
        }

        SortNode fast = head;
        SortNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

public class LinkedListSort {
    public static void main(String[] args) {
        SortLinkedList list = new SortLinkedList();
        SortNode head = null;

        head = list.insertAtEnd(head, 10);
        head = list.insertAtEnd(head, 5);
        head = list.insertAtEnd(head, 15);
        head = list.insertAtEnd(head, 2);
        head = list.insertAtEnd(head, 20);

        System.out.println("Original List:");
        printList(head);

        head = list.mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }

    public static void printList(SortNode head) {
        SortNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
