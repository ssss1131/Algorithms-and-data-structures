package main.java.com.ssss.algo.lab1_Queue_Stack;

import java.util.Scanner;
import java.util.Stack;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next1 = scanner.next();
        String next2 = scanner.next();
        int length = Math.max(next1.length(), next2.length());

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < length; i++) {

            if(i < next1.length()){
                char c1 = next1.charAt(i);
                if (c1 != '#') {
                    stack1.push(c1);
                } else {
                    stack1.pop();
                }
            }
            if(i< next2.length()){
                char c2 = next2.charAt(i);
                if (c2 != '#') {
                    stack2.push(c2);
                } else {
                    stack2.pop();
                }
            }
        }
        System.out.println(stack1.equals(stack2)?"Yes":"No");
    }
}
