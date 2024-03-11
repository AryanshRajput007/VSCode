package Java;

class Node225 {
    int data;
    Node225 next;

    public Node225(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyStack {

    private Node225 front, rear;

    public MyStack() {
        this.front = this.rear = null;
    }

    public void push(int data) {
        Node225 newnode = new Node225(data);
        if(isEmpty()) {
            this.front = this.rear = newnode;
            return;
        }
        this.rear.next = newnode;
        this.rear = newnode;
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int data = this.rear.data;
        Node225 current = front;
        while(current.next != rear) {
            current = current.next;
        }
        current.next = null;
        this.rear = current;
        return data;
    }

    public int top() {
        return this.rear.data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
}

public class StacksUsingQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        int popped_element = stack.pop();
        int top_element = stack.top();
        System.out.println("The popped element is " + popped_element);
        System.out.println("The top element is " + top_element);
    }
}