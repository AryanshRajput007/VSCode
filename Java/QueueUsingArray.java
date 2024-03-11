package Java;

public class QueueUsingArray {

    private int [] queue;
    private int front;
    private int rear;
    int size;

    public QueueUsingArray(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void Enqueue(int data) {
        if(isFUll()) {
            System.out.println("Queue is Overflow");
            return;
        }

        if(this.rear == -1 && this.front == -1) {
            this.front++;
            this.rear++;
            queue[rear] = data;
        }

        else{
            rear = ++rear % size;
            queue[rear] = data;
        }
    }

    public int Dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int data = 0;
        if(this.front == this.rear) {
            data = queue[front];
            this.rear = this.front = -1;
        }
        else{
            data = queue[front];
            front = ++front % size;
        }
        return data;
    }

    public void printQueue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        int i = front;
        while(i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println(queue[i]);
    }

    public boolean isEmpty() {
        return this.front == -1;
    }

    public boolean isFUll() {
        return (this.rear + 1) % size == front;
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(7);
        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.printQueue();
        queue.Dequeue();
        queue.printQueue();
        //System.out.println(this.front);
    }
}
