package main.java.com.ssss.algo.lab1;

import java.util.*;
import java.util.stream.Collectors;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer cases = Integer.valueOf(scanner.nextLine());
        Deque<Integer> numbers = new ArrayDeque<>();
        Map<Integer, Deque<Integer>> existSequences = new HashMap<>();
        while (cases != 0) {
            numbers.addLast(Integer.valueOf(scanner.nextLine()));
            cases--;
        }
        while (!numbers.isEmpty()) {
            findSequence(numbers.removeFirst(), existSequences);
        }
    }

    private static void findSequence(int quantity, Map<Integer, Deque<Integer>> existSequences) {
        if(existSequences.containsKey(quantity)){
            System.out.println(existSequences.get(quantity).stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        Deque<Integer> result = new ArrayDeque<>();
        while (quantity != 0) {
            result.addFirst(quantity);
            for (int i = 0; i < quantity; i++) {
                result.addFirst(result.removeLast());
            }
            quantity--;
        }
        existSequences.put(result.size(), result);
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
