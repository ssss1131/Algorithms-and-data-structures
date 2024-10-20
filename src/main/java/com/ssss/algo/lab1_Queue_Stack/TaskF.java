package main.java.com.ssss.algo.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskF {

    private static List<Integer> basePrimes = new ArrayList<>(List.of(2, 3, 5, 7, 11));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(basePrimes.contains(n)){
            System.out.println("YES");
            return;
        }
        int max = (int) Math.round(Math.sqrt(n));
        int current = basePrimes.get(4);
        while (current <= max){
            if (isPrime(current)) {
                basePrimes.add(current);
            }
            current++;
        }

        System.out.println(isPrime(n)?"YES":"NO");
    }

    private static boolean isPrime(int num) {
        if(num<2){
            return false;
        }

        for (Integer basePrime : basePrimes) {
            if (num % basePrime == 0) {
                return false;
            }
        }
        return true;
    }
}
