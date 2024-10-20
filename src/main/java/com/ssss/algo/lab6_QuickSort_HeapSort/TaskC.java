package main.java.com.ssss.algo.lab6_QuickSort_HeapSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TaskC {

    static int partition(long[] array, int beg, int end) {
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

    private static void swap(long[] array, int i, int end) {
        long temp = array[i];
        array[i] = array[end];
        array[end] = temp;
    }

    static void quickSort(long[] array, int beg, int end) {
        if (end > beg) {
            int p = partition(array, beg, end);
            quickSort(array, beg, p - 1);
            quickSort(array, p + 1, end);
        }
    }

    public static void findLeastDiffPairs(long[] arr, int size, BufferedWriter bw) throws IOException {
        long minDifference = Long.MAX_VALUE;
        List<String> pairs = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            long currentDifference = Math.abs(arr[i] - arr[i - 1]);
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                pairs.clear();
                pairs.add(arr[i - 1] + " " + arr[i]);
            } else if (currentDifference == minDifference) {
                pairs.add(arr[i - 1] + " " + arr[i]);
            }
        }
        for (String pair : pairs) {
            bw.write(pair + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        quickSort(arr, 0, size - 1);
        findLeastDiffPairs(arr, size, bw);
        bw.flush();
    }
}
