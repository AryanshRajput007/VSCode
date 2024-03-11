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

    public void insertAtBeginning(int data) {
        Node newnode = new Node(data);
        if(head == null) {
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void printLL() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println(" ");
    }

    public Node removeNodeAtGivenPositionFromEnd(int n) {
        Node current = head;
        int count = 0;
        while(current != null) {
            current = current.next;
            count++;
        }
        if(count == n) {
            head = head.next;
            return head;
        }
        int x = count - n - 1;
        current = head;
        while(x > 0) {
            current = current.next;
            x--;
        }
        current.next = current.next.next;
        return head;
    }

    public Node removeNodeAtGivenPositionFromEndM2(int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

public class Question19 {
    public static void main(String[] args) {
        SinglyLinkedList head = new SinglyLinkedList();
        head.insertAtBeginning(50);
        head.insertAtBeginning(40);
        head.insertAtBeginning(30);
        head.insertAtBeginning(20);
        head.insertAtBeginning(10);
        head.removeNodeAtGivenPositionFromEnd(2);
        head.printLL();

        //Using method 2

        // SinglyLinkedList head2 = new SinglyLinkedList();
        // head2.insertAtBeginning(50);
        // head2.insertAtBeginning(40);
        // head2.insertAtBeginning(30);
        // head2.insertAtBeginning(20);
        // head2.insertAtBeginning(10);
        // head2.removeNodeAtGivenPositionFromEnd(1);
        // head2.printLL();
    }
}
