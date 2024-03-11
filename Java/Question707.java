package Java;

class Node707 {
    int data;
    Node707 next;

    public Node707(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {

    private Node707 head;

    public MyLinkedList() {
        this.head = null;
    }

    public void addAtHead(int data) {
        Node707 newnode = new Node707(data);
        if(this.head == null) {
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void addAtTail(int data) {
        Node707 newnode = new Node707(data);
        if(head == null) {
            head = newnode;
            return;
        }
        Node707 current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newnode;
    }

    public void addAtIndex(int data, int index) {
        if(index < 0) {
            return;
        }
        Node707 newnode = new Node707(data);
        if(index == 0) {
            newnode.next = head;
            head = newnode;
            return;
        }
        Node707 current = head;
        int count = 0;
        while(current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if(current != null) {
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    public int get(int index) {
        int count = 0;
        Node707 current = head;
        while(current != null && count < index)  {
            current = current.next;
            count++;
        }
        if (current != null) {
            return current.data;
        }
        else {
            return -1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        int count = 0;
        Node707 current = head;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    public void printLL() {
        Node707 current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

public class Question707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(2, 1);
        myLinkedList.printLL();
        int result = myLinkedList.get(1);    
        System.out.println(result);
        myLinkedList.deleteAtIndex(1);
        result = myLinkedList.get(1);  
        System.out.println(result);
    }
}
