package Structures;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private static class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the beginning of the linked list
    public void insertAtBeginning(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a new node at the end of the linked list
    public void insertAtEnd(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to delete a node with given key
    public void delete(Object key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data.equals(key)) {
            head = temp.next;
            return;
        }
        while (temp != null && !temp.data.equals(key)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    // Method to convert the linked list to an array of Objects
    public Object[] toArray() {
        List<Object> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        // Convert list to array of Objects
        return list.toArray();
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data);
            current = current.next;
        }
        return result.toString();
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeElement(int val) {
        while (head != null && (int) head.data == val) {
            head = head.next;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if ((int) current.next.data == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public Node linkedListSorter() {
        return linkedListSorterRec(head);
    }

    private Node linkedListSorterRec(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = linkedListSorterRec(head);
        Node right = linkedListSorterRec(nextOfMiddle);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node result = null;

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        if ((int) left.data <= (int) right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    public Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
