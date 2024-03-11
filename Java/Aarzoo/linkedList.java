package Java.Aarzoo;

class AarzooNode {
    int data;
    AarzooNode next;

    public AarzooNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class newLinkedList {

    AarzooNode head;

    public newLinkedList() {
        head = null;
    }

    void insertAtBeginning(int data) {
        AarzooNode newnode = new AarzooNode(data);
        if (head == null) {
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    void print() {
        
    }
}

public class linkedList {
    public static void main(String[] args) {
        newLinkedList list = new newLinkedList();
        list.insertAtBeginning(30);
    }
}
