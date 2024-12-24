package main.java.com.ssss.algo.dataStructeres;

public class Stack {

    private final int MAX_SIZE;
    private int top = -1;
    private int[] stack;

    public Stack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        stack = new int[MAX_SIZE];
    }

    private boolean isFull(){
        return top + 1 == MAX_SIZE;
    }

    public void push(int value){
        if(!isFull()){
            stack[++top] = value;
        }else {
            System.out.println("Stack is full");
        }
    }

    public int pop(){
        if(top != -1){
            return stack[top--];
        }else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

}

class StackTest{
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
