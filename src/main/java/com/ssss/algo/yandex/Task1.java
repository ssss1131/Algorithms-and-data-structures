package main.java.com.ssss.algo.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        List<Integer> uniqueValues = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .distinct()
                .toList();

        switch (uniqueValues.size()) {
            case 2 -> System.out.println(Math.abs(uniqueValues.get(1) - uniqueValues.get(0)));
            case 1 -> System.out.println(0);
            default -> System.out.println(-1);
        }
    }
}
