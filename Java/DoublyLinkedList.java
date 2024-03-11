package Java;

class DNode {
    int data;
    DNode next;
    DNode prev;

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyList {
    DNode head;

    public DoublyList() {
        head = null;
    }

    public void insertAtBeginning(int data) {
        DNode newnode = new DNode(data);
        if (head == null) {
            head = newnode;
            newnode.next = newnode;
            newnode.prev = newnode;
            return;
        }
        head.prev.next = newnode;
        newnode.prev = head.prev;
        head.prev = newnode;
        newnode.next = head;
        head = newnode;
    }

    public void insertAtEnd(int data) {
        DNode newnode = new DNode(data);
        if (head == null) {
            head = newnode;
            newnode.next = newnode;
            newnode.prev = newnode;
            return;
        }
        newnode.prev = head.prev;
        head.prev.next = newnode;
        newnode.next = head;
        head.prev = newnode;
    }

    public void insertAtIndex(int data, int index) {
        if (index < 0) {
            System.out.println("The index entered is invalid(negative)");
            return;
        }
        DNode newnode = new DNode(data);
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }
        int count = 0;
        DNode current = head;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Index out of bounds");
            return;
        }
        current.prev.next = newnode;
        newnode.prev = current.prev;
        newnode.next = current;
        current.prev = newnode;
    }

    public void printLL() {
        DNode current = head;
        while (current.next != head) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
        System.out.println(" ");
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyList list = new DoublyList();
        list.insertAtBeginning(100);
        list.insertAtEnd(200);
        list.insertAtBeginning(500);
        list.insertAtIndex(300, 0);
        list.printLL(); // Print the list to verify insertion
    }
}
