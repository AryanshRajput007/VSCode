package Java;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {

    Node head;

    void insertAtBeginning(int data) {
        Node newnode = new Node(data);
        if(head == null) {
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    void insertAtEnd(int data) {
        Node newnode = new Node(data);
        if(head == null) {
            head = newnode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newnode;
    }

    void insertAtIndex(int data, int index) {
        if(index < 0) {
            System.out.println("The index entered is invalid!");
            return;
        }
        Node newnode = new Node(data);
        if(index == 0) {
            newnode.next = head;
            head = newnode;
        }
        Node current = head;
        int count = 0;
        while (current.next != null && count < index) {
            current = current.next;
            count++;
        }
        newnode.next = current.next;
        current.next = newnode;
    }

    void printLL() {
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

public class linkedlist {
    public static void main(String[] args) {
        SinglyLinkedList head = new SinglyLinkedList();
        head.insertAtBeginning(10);
        head.insertAtEnd(20);
        head.printLL();
    }
}