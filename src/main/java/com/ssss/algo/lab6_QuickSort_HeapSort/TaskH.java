package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskH {


    static char binarySearch(Character[] array, char searchingChar, int size) {
        int leftPointer = 0;
        int rightPointer = size - 1;
        char result =array[0];
        while (rightPointer >= leftPointer) {
            int mid = leftPointer + (rightPointer - leftPointer) / 2;
            if (array[mid] > searchingChar) {
                result = array[mid];
                rightPointer = mid - 1;
            } else {
                leftPointer = mid + 1;
            }
        }
        return result;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Character[] array = Arrays.stream(input)
                .map(s -> s.charAt(0))
                .toArray(Character[]::new);

        char searchingChar = br.readLine().charAt(0);
        char c = binarySearch(array, searchingChar, size);
        System.out.println(c);
    }

}
