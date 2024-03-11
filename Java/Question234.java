package Java;

class Node234 {
    int data;
    Node234 next;

    public Node234(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList234 {

    Node234 head;

    public SinglyLinkedList234() {
        head = null;
    }

    public void insert(int data) {
        Node234 newnode = new Node234(data);
        if(head == null) {
            head = newnode;
            return;
        }
        Node234 current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newnode;
        return;
    }

    void linkedListPalindromeChecker() {
        Node234 current = head;
        String x = "";
        while(current != null) {
            x += current.data;
            current = current.next;
        }
        System.out.println(x);
        //int temp = Integer.parseInt(x);
        int count = 0;
        int left = 0;
        int right = x.length() - 1;
        for(int i = 0; i < (x.length() / 2); i++) {
            if(x.charAt(left) == x.charAt(right)) {
                count++;
                left++;
                right--;
            }
        }
        if(count == x.length() / 2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public void printList() {
        Node234 current = head;
        while(current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println(" ");
    }
}

public class Question234 {
    public static void main(String[] args) {
        SinglyLinkedList234 list = new SinglyLinkedList234();
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(0);
        list.printList();
        list.linkedListPalindromeChecker();
        //boolean x = list.linkedListPalindromeChecker2();
        //System.out.println(x);
    }
}