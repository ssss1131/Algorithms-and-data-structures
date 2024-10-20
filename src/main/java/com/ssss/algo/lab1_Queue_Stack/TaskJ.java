package main.java.com.ssss.algo.lab1;

import java.util.*;

public class TaskJ {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        List<Object> result = new ArrayList<>();
        while(true){
            String[] split = scanner.nextLine().split(" ");
            if(split[0].equals("+")){
                deque.addFirst(Integer.valueOf(split[1]));
            } else if (split[0].equals("-")) {
                deque.addLast(Integer.valueOf(split[1]));
            } else if(split[0].equals("*")){
                if(!deque.isEmpty()){
                    Integer first = deque.removeFirst();
                    if(deque.isEmpty()){
                        result.add(first + first);
                    } else{
                        result.add(first + deque.removeLast());
                    }
                }else{
                    result.add("error");
                }
            } else if(split[0].equals("!")){
                break;
            }
        }
        for (Object o : result) {
            System.out.println(o);
        }
    }
}
