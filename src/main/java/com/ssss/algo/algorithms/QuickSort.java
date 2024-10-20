package main.java.com.ssss.algo.algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    static int partition(long[] array, int beg, int end) {
        int pivot = beg + new Random().nextInt(end - beg);
        swap(array, end, pivot);

        int cur = beg;
        for (int i = beg; i < end; i++) {
            if (array[end] >= array[i]) {
                swap(array, i, cur);
                cur++;
            }
        }
        swap(array, cur, end);
        return cur;
    }

    static void quickSort(long[] array, int beg, int end) {
        if (end > beg) {
            int p = partition(array, beg, end);
            quickSort(array, beg, p - 1);
            quickSort(array, p + 1, end);
        }
    }


    static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        long[] array = new long[]{1, 651, 2, 3, 5, 1, 6, 7, 1, 35, 4, 6};
        quickSort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
