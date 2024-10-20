package main.java.com.ssss.algo.lab1;

import java.util.*;

public class TaskE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split1 = scanner.nextLine().split(" ");
        String[] split2 = scanner.nextLine().split(" ");
        List<Integer> collect1 = Arrays.stream(split1).map((Integer::parseInt)).toList();
        List<Integer> collect2 = Arrays.stream(split2).map(Integer::parseInt).toList();
        Queue<Integer> queue1 = new LinkedList<>(collect1);
        Queue<Integer> queue2 = new LinkedList<>(collect2);
        int checker = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty() && checker != Math.pow(10, 6)) {
            Integer firstValue = queue1.remove();
            Integer secondValue = queue2.remove();
            if ((firstValue == 0 && secondValue ==9) || (firstValue > secondValue) && !(firstValue == 9 && secondValue == 0)) {
                queue1.add(firstValue);
                queue1.add(secondValue);
            } else {
                queue2.add(firstValue);
                queue2.add(secondValue);
            }
            checker++;
        }
        if (checker == Math.pow(10, 6)) {
            System.out.println("suu");
            return;
        }
        System.out.println((queue2.isEmpty() ? "Boris " : "Nursik ") + checker);


    }

}
