package main.java.com.ssss.algo.algorithms;

import java.util.Arrays;

public class MergeSort {

    static void merge(int[] arr, int beg, int mid, int end) {
        int[] left = new int[mid - beg + 2];//сюда добавим миддл элемент еще помимо бесконечности
        int[] right = new int[end - mid + 1];
        left[mid - beg + 1] = Integer.MAX_VALUE;
        right[end - mid] = Integer.MAX_VALUE;

        for (int i = 0; i < mid - beg + 1; i++) {
            left[i] = arr[beg + i];
        }
        for (int i = 0; i < end - mid; i++) {
            right[i] = arr[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = beg;
        while (k <= end) {
            if (left[i] >= right[j]) {
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[i];
                i++;
            }
            k++;
        }
        left = null;
        right = null;
    }

    static void mergeSort(int[] arr, int beg, int end) {
        if (end > beg) {
            int mid = beg + (end - beg) / 2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,7,1,3,6};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
