package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class TaskB {

    static int partition(int[] array, int beg, int end) {
        int pivot = beg + new Random().nextInt(end - beg + 1);
        int cur = beg;
        swap(array, pivot, end);

        for (int i = beg; i < end; i++) {
            if (array[i] <= array[end]) {
                swap(array, i, cur);
                cur++;
            }
        }
        swap(array, cur, end);
        return cur;
    }

    private static void swap(int[] array, int i, int end) {
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
    }

    static void quickSort(int[] array, int beg, int end) {
        if (end > beg) {
            int p = partition(array, beg, end);
            quickSort(array, beg, p - 1);
            quickSort(array, p + 1, end);
        }
    }

    static void findWithTwoPointers(int[] firstSortedArray, int[] secondSortedArray,
                                    int firstArraySize, int secondArraySize, BufferedWriter bw)
            throws IOException {
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < firstArraySize && secondPointer < secondArraySize) {
            if (firstSortedArray[firstPointer] == secondSortedArray[secondPointer]) {
                bw.write(firstSortedArray[firstPointer] + " ");
                firstPointer++;
                secondPointer++;
            } else if (firstSortedArray[firstPointer] > secondSortedArray[secondPointer]) {
                secondPointer++;
            } else {
                firstPointer++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstSize = Integer.parseInt(st.nextToken());
        int secondSize = Integer.parseInt(st.nextToken());
        int[] firstArray = new int[firstSize];
        if (firstSize > 0) {
            firstArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            quickSort(firstArray, 0, firstSize - 1);
        }
        int[] secondArray = new int[secondSize];
        if (secondSize > 0) {
            secondArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            quickSort(secondArray, 0, secondSize - 1);
        }
        findWithTwoPointers(firstArray, secondArray, firstSize, secondSize, bw);
        bw.flush();

    }

}
