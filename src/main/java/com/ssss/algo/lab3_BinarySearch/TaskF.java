package main.java.com.ssss.algo.lab3_BinarySearch;

import java.io.*;
import java.util.Arrays;

public class TaskF {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] opponents = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rounds = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(opponents);
        int[] prefixSums = new int[size];
        prefixSums[0] = opponents[0];
        for (int i = 1; i < size; i++) {
            prefixSums[i] = prefixSums[i - 1] + opponents[i];
        }

        int[][] answers = new int[rounds][2];
        for (int i = 0; i < rounds; i++) {
            int strength = Integer.parseInt(bufferedReader.readLine());
            int strongerThan = binarySearch(opponents, strength);
            answers[i][0] = strongerThan;
            if(strongerThan != 0){
                answers[i][1] = prefixSums[strongerThan - 1];
            }else {
                answers[i][1] = 0;
            }
        }
        for (int[] answer : answers) {
            for (int a : answer) {
                bufferedWriter.write(a + " ");
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
    }

    public static int binarySearch(int[] array, int strength) {
        int leftPointer = 0;
        int rightPointer = array.length - 1;
        while (rightPointer >= leftPointer) {
            int m = (leftPointer + (rightPointer - leftPointer) / 2);
            if (array[m] <= strength) {
                leftPointer = m + 1;
            } else {
                rightPointer = m - 1;
            }
        }
        return leftPointer;
    }

//    public static void quickSort(int[] array) {
//        if (array.length < 2) {
//            return;
//        }
//        int pivot = array[array.length / 2];
//        int[] bigger = Arrays.stream(array).filter(x -> x >= pivot).toArray();
//        int[] smaller = Arrays.stream(array).filter(x -> x < pivot).toArray();
//        return concat(quickSort(bigger), quickSort(smaller), array.length);
//
//    }
//
//    private static int[] concat(int[] bigger, int[] smaller, int length) {
//        int[] result = new int[length];
//        System.arraycopy(smaller, 0, result, 0, smaller.length);
//        System.arraycopy(bigger, 0, result, smaller.length, bigger.length);
//
//        return result;
//    }

//    public static void bubbleSort(int[] array) {
//        boolean swapped;
//        int temp;
//        for (int i = array.length - 1; i > 0; i--) {
//            swapped = false;
//            for (int j = 0; j < i; j++) {
//                if (array[j] > array[j + 1]) {
//                    temp = array[j + 1];
//                    array[j + 1] = array[j];
//                    array[j] = temp;
//                    swapped = true;
//                }
//            }
//            if (!swapped) {
//                break;
//            }
//        }
//    }
}
