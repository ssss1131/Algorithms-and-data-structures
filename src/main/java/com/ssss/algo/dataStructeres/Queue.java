package main.java.com.ssss.algo.dataStructeres;

public class Queue {

    private final int MAX_SIZE;
    private int[] queue;
    private int front = 0;
    private int arrayIndex = 0;

    public Queue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        queue = new int[MAX_SIZE];
    }

    public boolean isEmpty(){
        return arrayIndex == 0;
    }

    private boolean isFull(){
        return arrayIndex == MAX_SIZE;
    }

    public void enqueue(int value){
        if(!isFull()){
            queue[arrayIndex++] = value;
        } else {
            System.out.println("Queue is fulL!");
        }
    }

    public int dequeue(){
        if(!isEmpty() && front != MAX_SIZE){
            return queue[front++];
        }else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public int peek(){
        return queue[front];
    }
}

class QueueTest{
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.dequeue());
        queue.dequeue();

    }
}
