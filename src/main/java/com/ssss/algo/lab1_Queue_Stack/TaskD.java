package main.java.com.ssss.algo.lab1_Queue_Stack;

import java.util.Scanner;
import java.util.Stack;

public class TaskD {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(!stack.isEmpty() && stack.peek().equals(c)){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}

