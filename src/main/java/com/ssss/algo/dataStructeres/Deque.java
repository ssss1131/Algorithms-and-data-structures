package main.java.com.ssss.algo.dataStructeres;

public class Deque {

    private final int MAX_SIZE;
    private int front;
    private int size;
    private int rear;
    private final int[] deque;

    public Deque(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        deque = new int[MAX_SIZE];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void addFirst(int value){
        if(isFull()){
            System.out.println("Deque is full");
            return;
        }
        if(isEmpty()){
            front = rear = 0;
        }else {
            front = (front - 1 + MAX_SIZE) % MAX_SIZE;
        }
        deque[front] = value;
        size++;
    }

    public void addLast(int value){
        if(isFull()){
            System.out.println("Deque is full");
            return;
        }
        if(isEmpty()) {
            front = rear = 0;
        }else {
            rear = (rear + 1) % MAX_SIZE;
        }
        deque[rear] = value;
        size++;
    }

    public int removeFirst(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return -1;
        }
        int result = deque[front];
        if(front == rear){
            front = rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
        size--;
        return result;
    }

    public int removeLast(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return -1;
        }
        int result = deque[rear];
        if(front == rear){
            front = rear = -1;
        }else {
            rear = (rear - 1 + MAX_SIZE) % MAX_SIZE;
        }
        size--;
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque elements: ");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(deque[i] + " ");
            i = (i + 1) % MAX_SIZE;
        }
        System.out.println();
    }
}

class DequeTest{
    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);
        deque.printDeque();

        System.out.println("Removed First: " + deque.removeFirst());
        System.out.println("Removed Last: " + deque.removeLast());
        deque.printDeque();

        deque.addFirst(50);
        deque.addLast(40);
        deque.printDeque();
    }
}
