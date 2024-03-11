package Java;

class queueArray {
    private int Max_size;
    private int [] queue;
    private int front;
    private int rear;
    private int currentSize;

    public queueArray(int Max_size) {
        this.Max_size = Max_size;
        queue = new int[Max_size];
        front = 0;
        rear =-1;
        currentSize = 0;
    }

    public void enqueue(int data) {
        if(isFull()) {
            System.out.println("The queue is full! Cannot enqueue" + data);
            return;
        }
        rear = (rear + 1) % Max_size;
        queue[rear] = data;
        currentSize++;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        int data = queue[front];
        front = front + 1 % Max_size;
        currentSize--;
        return data;
    }

    public void display() {
        if(isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        for(int i = front, count = 0; count < currentSize; count++) {
            System.out.println(queue[i]);
            i = (i + 1) % Max_size;
        }
        System.out.println(" ");
    }

    public int peek() {
        return queue[front];
    }

    public int rear() {
        return queue[rear];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == Max_size - 1;
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        queueArray queue = new queueArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.display();
        queue.dequeue();
        queue.display();
    }
}
