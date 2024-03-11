package Java;

class Node092 {
    int data;
    Node092 next;

    public Node092(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    private Node092 head;

    public Solution() {
        this.head = null;
    }

    public void insert(int data) {
        Node092 newnode = new Node092(data);
        if(head == null) {
            head = newnode;
            return;
        }
        Node092 current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newnode;
    }

    public void printLL() {
        Node092 current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("");
    }
    //public Node092 reverseBetween(int left, int right);
}

public class Question92 {
    public static void main(String[] args) {
        Solution head = new Solution();
        head.insert(10);
        head.insert(20);
        head.printLL();
    }
}
