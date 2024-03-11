package Java;

// class QueueNode {
//     int data;
//     QueueNode next;

//     public QueueNode(int data) {
//         this.data = data;
//         this.next = null;
//     }
// }

// class Queue {
//     private QueueNode front, rear;

//     public Queue() {
//         this.front = this.rear = null;
//     }

//     public void enqueue(int data) {
//         QueueNode newNode = new QueueNode(data);

//         if (isEmpty()) {
//             this.front = this.rear = newNode;
//             return;
//         }

//         this.rear.next = newNode;
//         this.rear = newNode;
//     }

//     public int dequeue() {
//         if (isEmpty())
//             throw new IllegalStateException("Queue is empty");

//         int data = this.front.data;
//         this.front = this.front.next;

//         if (this.front == null)
//             this.rear = null;

//         return data;
//     }

//     public int peek() {
//         if (isEmpty())
//             throw new IllegalStateException("Queue is empty");

//         return this.front.data;
//     }

//     public boolean isEmpty() {
//         return this.front == null;
//     }
    
//     public void display() {
//         if (isEmpty()) {
//             System.out.println("Queue is empty");
//             return;
//         }
        
//         QueueNode current = this.front;
//         while (current != null) {
//             System.out.print(current.data + " ");
//             current = current.next;
//         }
//         System.out.println();
//     }
// }

// public class QueuesUsingLinkedList {
//     public static void main(String[] args) {
//         Queue queue = new Queue();

//         queue.enqueue(10);
//         queue.enqueue(20);
//         queue.enqueue(30);

//         System.out.println("Queue:");
//         queue.display();

//         System.out.println("Dequeue: " + queue.dequeue());
//         System.out.println("Peek: " + queue.peek());

//         System.out.println("Queue after dequeue:");
//         queue.display();
//     }
// }


class QueueNode {
    int data;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {

    private QueueNode front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        QueueNode newnode = new QueueNode(data);
        if(isEmpty()) {
            this.front = this.rear = newnode;
            return;
        }
        this.rear.next = newnode;
        this.rear = newnode;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = this.front.data;
        this.front = this.front.next;
        if(this.front == null) {
            this.rear = null;
        }
        return data;
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.front.data;
    }

    public void display() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        QueueNode current = this.front;
        while(current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println(" ");
    }

    boolean isEmpty() {
        return this.front == null;
    }
}

public class QueuesUsingLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.dequeue();
        queue.display();
    }
}