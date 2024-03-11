package Java;

class Stack {
    int data;
    Stack next;

    public Stack(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MinStack {
    Stack stack;
    Stack minStack;

    public MinStack() {
        stack = null;
        minStack = null;
    }

    public void push(int data) {
        Stack node = new Stack(data);
        if (stack == null && minStack == null) {
            stack = node;
            minStack = node;
        } else {
            node.next = stack;
            stack = node;
            if (node.data <= minStack.data) {
                Stack minNode = new Stack(node.data);
                minNode.next = minStack;
                minStack = minNode;
            }
        }
    }

    public void pop() {
        
    }
}
