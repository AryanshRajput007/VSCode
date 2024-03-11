package Java;

class Node61 {
    int data;
    Node61 next;

    public Node61(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Question61 {

    private Node61 head;

    public Question61() {
        head = null;
    }

    public void insertAtEnd(int data) {
        Node61 newnode = new Node61(data);
        if(head == null) {
            head = newnode;
            return;
        }
        Node61 current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newnode;
    }

    void rotator(int rotate) {
        if (head == null || head.next == null) {
            return; // Nothing to rotate
        }
    
        Node61 current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
    
        current.next = head; // Connect the last node to the head to form a cycle
    
        rotate = rotate % length; // Adjust rotation if it's greater than the length of the list
    
        int stepsToNewHead = length - rotate - 1; // Number of steps to the new head node
        current = head; // Reset current to the head node
    
        for (int i = 0; i < stepsToNewHead; i++) {
            current = current.next;
        }
    
        head = current.next; // New head node
        current.next = null; // Break the cycle
    }
    

    public void printLL() {
        Node61 current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Question61 list = new Question61();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.printLL();

        list.rotator(3);
        list.printLL();
    }
}
