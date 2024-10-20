package main.java.com.ssss.algo.lab1;

import java.util.*;
import java.util.stream.Collectors;

public class TaskB {

    //2 1 5 8 3

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt( scanner.nextLine());

        String[] split = scanner.nextLine().split(" ");
        int[] ages = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int[] results = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && ages[stack.peek()] > ages[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                results[i] = -1;
            }else {
                results[i] = ages[stack.peek()];
            }
            stack.push(i);
        }
        System.out.println(Arrays.stream(results).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
